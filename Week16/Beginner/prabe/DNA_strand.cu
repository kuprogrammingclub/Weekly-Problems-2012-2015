#include <stdio.h>

#define DNA_LENGTH 2062336
#define THREADS	1024 	//1024 max threads per block 
#define BLOCKS	1024

__global__ void DNA_func(int *org, int *newar, int n)
{
	//each thread in each block determines which part of the array it is working on.
	int i = blockIdx.x * blockDim.x + threadIdx.x;
	
	//catch if there are more threads than there is data to be worked on.(to prevent memory access issues)
	if (i < n)
	{
		switch(org[i]) {
			case 'A':
			case 'a':
			newar[i] = 'T';
			break;
			
			case 'T':
			case 't':
			newar[i] = 'A';
			break;
			
			case 'G':
			case 'g':
			newar[i] = 'C';
			break;
			
			case 'C':
			case 'c':
			newar[i] = 'G';
			break;
			
			default:
			newar[i] = 'N';
			break;
		}
	}
}

int main()
{
	cudaFree(0);//init cuda(its lazy and does not startup until needed)
	
	int *Original, *Newar;//declaration of array for host(cpu)
	int *d_Original, *d_Newar; //declaration of arrays for device(gpu)
	int c,n;//char from file, number of chars pulled
	c = 0;
	n = 0;
	
	Original = (int *)malloc(DNA_LENGTH*sizeof(int));//alcoate memory of arrays in host(cpu)
	Newar = (int *)malloc(DNA_LENGTH*sizeof(int));
	
	cudaMalloc( &d_Original, DNA_LENGTH*sizeof(int));//init of arrays in device(gpu)
	cudaMalloc( &d_Newar, DNA_LENGTH*sizeof(int));
	
	FILE *fp = fopen("dna.txt", "r");
	if (fp == NULL){
	 printf("File DNE");
	 return 1;
	 }
	 c = fgetc(fp);
	while((c != EOF)&&(n < DNA_LENGTH)){
			if ((c == 'A')||(c == 'a')||(c == 'T')||(c == 't')||(c == 'G')||(c == 'g')||(c == 'C')||(c == 'c')){
			Original[n] = c;
			Newar[n] = c;
		
			n++;
			}
		c = fgetc(fp);
	 	}
	 	fclose(fp);
	cudaMemcpy( d_Original, Original, DNA_LENGTH*sizeof(int), cudaMemcpyHostToDevice );//copy array data to device(gpu)
	cudaMemcpy( d_Newar, Newar, DNA_LENGTH*sizeof(int), cudaMemcpyHostToDevice );
	
	DNA_func<<< THREADS, BLOCKS >>>(d_Original, d_Newar, n-1);//init gpu kernel (the magic happens here!)
	
	cudaMemcpy( Newar, d_Newar, DNA_LENGTH*sizeof(int), cudaMemcpyDeviceToHost );//copy array output data back to host (cpu)
	FILE *fp2 = fopen("dna_out.txt", "w");

if (n <= 25){
	for(int i = 0; i<(n-1); i++)
		{
			printf("%c %c \n",Original[i],Newar[i]);//prints out the output if it is small...
		}
}
	for(int i = 0; i<(n-1); i++)
		{
			fprintf(fp2,"%c %c \n",Original[i],Newar[i]);//outputs to a file so you are not waiting for the terminal forever.
		}
		fclose(fp2);
	free(Original);
	free(Newar);
	cudaFree(d_Original);
	cudaFree(d_Newar);
	return 0;
}
