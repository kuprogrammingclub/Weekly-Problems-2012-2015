/* Howard Cheng */

#include <stdio.h>

int primes[10] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

int main(void)
{
  /* 10 primes should be enough, since the product of them is
     >= 2^31-1 */
  int a[10];
  int n, n2;
  int i, j, k, printed;
  FILE *in, *out;

  in = fopen("primebases.in", "r");
  //out = fopen("primebases.out", "w");

  while (fscanf(in, "%d", &n) == 1 && n > 0) {
    i = 0;
    n2 = n;
    while (n2 > 0) {
      a[i] = n2 % primes[i];
      n2 /= primes[i];
      i++;
    }

    printf("%d = ", n);
    printed = 0;
    for (k = 0; k < i; k++) {
      if (a[k]) {
	if (printed) {
	  printf(" + ");
	}
	printf("%d", a[k]);
	for (j = 0; j < k; j++) {
	  printf("*%d", primes[j]);
	}
	printed = 1;
      }
    }
    printf("\n");
  }
  return 0;
}
