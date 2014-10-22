#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <string.h>
#include <stddef.h>

#include <readline/readline.h>
#include <readline/history.h>

#define x1 100.0
#define x2 -50.0

char *trimwhitespace(char *str) {
  char *end;
  while(isspace(*str)) str++;

  if(*str == 0) return str;
  end = str + strlen(str) - 1;
  while(end > str && isspace(*end)) end--;
  *(end+1) = 0;

  return str;
}

struct vals {
	float slope1;
	float intercept1;
	float slope2;
	float intercept2;
};

void calc(struct vals value){

	float ay1 = value.slope1*x1+value.intercept1;
	float ay2 = value.slope1*x2+value.intercept1;

	float by1 = value.slope2*x1+value.intercept2;
	float by2 = value.slope2*x2+value.intercept2;

	float A1 = ay2 - ay1;
	float B1 = x1 - x2;
	float C1 = A1*x1+B1*ay1;

	float A2 = by2 - by1;
	float B2 = x1 - x2;
	float C2 = A2*x1+B2*by1;

	float det = A1*B2 - A2*B1;
	
	if (det == 0) {
		printf("%s\n", "ERROR: PARALLEL LINES");
	} else {
		float x_inter = (B2*C1 - B1*C2)/det;
		float y_inter = (A1*C2 - A2*C1)/det;
		printf("(%.2g, %.2g)\n", x_inter, y_inter);
	}
}

float slope(char * input) {
	char * first = strsep(&input, "=");
	char * second = strsep(&input, "x");
	return atof(second);
}

float intercept(char * input) {
	char * first = strsep(&input, "x");
	char * second = strsep(&input, "x");
	return atof(second);
}

void parser(char* input){

	char * A = strchr(input, '-');
	char * B = strchr(input, '+');
	char * C = strchr(input, '=');
	char * D = strchr(input, 'x');
	char * E = strchr(input, 'y');
	char * F = strchr(input, ';');

	if(!(A || B) || !C || !D || !E || !F) {

		printf("ERROR: IMPROPERLY FORMATTED STRING\n");
		printf("NEEDS TO BE IN FORMAT y=mx+b;y=mx+b\n");

	} else {

		char * first = strsep(&input, ";");
		char * first_dup = strdup(first);
		char * second = strsep(&input, ";");
		char * second_dup = strdup(second);

		struct vals value;
		value.slope1 = slope(first);
		value.slope2 = slope(second);
		value.intercept1 = intercept(first_dup);
		value.intercept2 = intercept(second_dup);
		
		calc(value);

	}
}

int main(int argc, char** argv) {
	char* input, shell_prompt[100];
	rl_bind_key('\t', rl_complete);

	do { 
    	snprintf(shell_prompt, sizeof(shell_prompt), "~> ");
        input = readline(shell_prompt);
        if (!input) break;
        add_history(input);

    	if(strcmp("exit", input) != 0 & strcmp("quit", input) != 0){
    		if(strlen(input) > 1)  {
    			char * s; char * d;
	  			for (s=d=input;*d=*s;d+=(*s++!='\n'));
	  			parser(trimwhitespace(input));
    		}
    	} else {
    		break;
    	}
        free(input);
        
    } while (1);	

}