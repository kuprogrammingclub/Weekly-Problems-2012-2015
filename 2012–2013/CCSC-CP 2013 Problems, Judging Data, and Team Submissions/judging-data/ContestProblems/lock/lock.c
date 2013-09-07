/* Howard Cheng */

#include <stdio.h>

int main(void)
{
  int N, T1, T2, T3;
  int ticks;      /* number of ticks if the mark is initially at T1 */
  FILE *in, *out;

  in = fopen("lock.in", "r");
  //out = fopen("lock.out", "w");

  while (fscanf(in, "%d %d %d %d", &N, &T1, &T2, &T3) == 4 &&
	 (N || T1 || T2 || T3)) {
    ticks = 2*N;       /* first turn */
    ticks += N + ((T2 > T1) ? T2 - T1 : T2 + N - T1);    /* second turn */
    ticks += (T2 > T3) ? T2 - T3 : T2 + N - T3;
    printf("%.3f\n", ticks + (N-1)/2.0);
  }


  return 0;
}
