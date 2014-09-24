#include <stdlib.h> 

void setup() {
}

void loop() {
  //start serial port at 9600 baud
  Serial.begin(9600);
  Serial.println("Enter the size of the tree, the tree charectors, and the trunk charectors.");
  
  //wait for input
  while (Serial.available() == 0){
    ;
  }
  char number[3];
  Serial.readBytesUntil(' ',number,3);
  int num = atoi(number);
  
  //print number
  Serial.println(num);
  
  //read first character
  int char1 = Serial.read();
  while (char1 == -1 || char1 == 32){
     char1 = Serial.read(); 
  }
  
  //read second character
  int char2 = Serial.read();
  while (char2 == -1 || char2 == 32){
     char2 = Serial.read(); 
  }
  
  //check for greator than three and odd
  if ((num >= 3)&&(num % 2 == 1))
  {
    
    //itterations for tree height
    for(int i = 0; i < (num/2)+1; i++){
      for(int j = ((num/2)-i); j>0; j--){
        Serial.print(" ");
      }
      for(int k = 0;k < ((i*2)+1); k++){
        Serial.write(char2);
      }
      Serial.println();
    }
    
    //itterations for trunk
    for(int i = 1; i<(num/2); i++){
     Serial.print(" "); 
    }
    for(int i = 0; i<3; i++){
     Serial.write(char1);
    }
    Serial.println();
  }
  //clear input buffer
  Serial.end();
}
