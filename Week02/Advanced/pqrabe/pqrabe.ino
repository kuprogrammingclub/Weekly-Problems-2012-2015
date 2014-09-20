unsigned long iteration = 1;
unsigned long output = 0;
unsigned long prevout = 0;
int overflows = 0;
//uint64_t - do i need this?

void setup() {
  //opens serial port, set baud to 9800 bps
  Serial.begin(9800);
  
}

void loop() {
  
  output += sigma(iteration);
  if (prevout > output){
    //Serial.println("Output Overflow Error!");
    overflows++;
  }
  iteration++;
  if (iteration%100 == 0){
    Serial.println(iteration);
    if (iteration%1000 == 0){
      Serial.println("");
      Serial.print(output);
      Serial.print(" + ");
      Serial.print(overflows);
      Serial.println(" x ((2^32)-1)");
      Serial.println("");
    }
  }
  if (iteration == 100000){//64000000
    Serial.println("");
    Serial.println("");
    Serial.print(output);
    Serial.print(" + ");
    Serial.print(overflows);
    Serial.print(" x ((2^32)-1)");
    while(true){
      //Just to keep the processor busy.
      delay(10000);
    }
  }
  prevout = output;
  
}

/* 
 * this function is similar to sigma, 
 * but returns 0 if the sum is not a perfect square.
 */

unsigned long sigma(unsigned long arg){
  unsigned long sum = 0;
  unsigned long prevsum = 0;
  for(unsigned long i = 1; i <= arg; i++){
    if (arg%i == 0){
        sum = i*i;
        if (prevsum > sum){
          Serial.println("Sum Overflow Error!");
        }
        prevsum = sum;
      }
    }
  float temp = sqrt(float(sum));
  if(temp == floor(temp)){
  //if(perfect_square(sum)){
    return sum;
  }else{
    return 0;
  }
}

boolean perfect_square(unsigned long n)
{
  unsigned long sqr=1;
  unsigned long div = n/2;
  for(unsigned long i=1; i<=div; i++)
   {
    sqr = i*i;
      if(sqr==n)
      return true;
   }
     return false;
}


