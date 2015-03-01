#include <stdio.h>
/*
	A GPU implemenation of finding the dates of easter using a Nvidia Cuda GPU with Cuda C.
	
	nvcc -o easter Gpu_easter_calc.cu
	
	Preston Rabe
	
*/

#define YEARS	16384	//years = treads * blocks (16384 years after year 2000!)
#define THREADS	128 	//1024 max threads per block 
#define BLOCKS	128		


__global__ void easter(int *yr, int *mon, int *day, int n)//GPU task arguement 'n' is to catch if more threads are started than there is data to be worked on
{
	int i = blockIdx.x * blockDim.x + threadIdx.x;//each thread in each block determines which part of the array it is working on.
	
	if (i < n)//catch if there are more threads than there is data to be worked on.(to prevent memory access issues)
	{
		//Computeing easter day/month (can't have many variables per thread, memory is limited.)
		int a = (yr[i]+2000) % 19;
		int b = (yr[i]+2000)>>2;
		int c = b/25+1;
		int d = (c*3)>>2;
		int e = ((a*19) - ((c*8+5)/25) +d +15)%30;
		e += (29578 -a -e *32) >> 10;
		e -= (((yr[i]+2000)%7)+b-d+e+2)%7;
		d = e>>5;
		//saveing day/month in to GPU memory arrays
		day[i] = e-d*31;
		mon[i] = d+3;
	}
}

int main()
{

	int *a, *b, *c;//declaration of array for host(cpu)
	int *d_a, *d_b, *d_c;//declaration of arrays for device(gpu)
	
	a = (int *)malloc(YEARS*sizeof(int));//alcoate memory of arrays in host(cpu)
	b = (int *)malloc(YEARS*sizeof(int));
	c = (int *)malloc(YEARS*sizeof(int));
	
	cudaMalloc( &d_a, YEARS*sizeof(int));//init of arrays in device(gpu)
	cudaMalloc( &d_b, YEARS*sizeof(int));
	cudaMalloc( &d_c, YEARS*sizeof(int));
	
	for( int i = 0; i < YEARS; ++i )//init arrays values
	{
		a[i] = i;//years (after 2000)
		b[i] = 0;//month
		c[i] = 0;//days
	}
	
	cudaMemcpy( d_a, a, YEARS*sizeof(int), cudaMemcpyHostToDevice );//copy array data to device(gpu)
	cudaMemcpy( d_b, b, YEARS*sizeof(int), cudaMemcpyHostToDevice );
	cudaMemcpy( d_c, c, YEARS*sizeof(int), cudaMemcpyHostToDevice );
	
	easter<<< THREADS, BLOCKS >>>(d_a, d_b, d_c, YEARS);//init gpu kernel (the magic happens here!)
	
	cudaMemcpy( b, d_b, YEARS*sizeof(int), cudaMemcpyDeviceToHost );//copy array output data back to host (cpu)
	cudaMemcpy( c, d_c, YEARS*sizeof(int), cudaMemcpyDeviceToHost );
	
	for( int i = 0; i < YEARS; ++i)
		printf("%2d, %d,%d\n", c[i],b[i],i+2000);//print out data to terminal (day,month,year)
	
	free(a);
	free(b);
	free(c);//free memory in host(cpu)
	
	cudaFree(d_a);
	cudaFree(d_b);
	cudaFree(d_c);//free memory in device(gpu)
	
	return 0;//exit program
}
