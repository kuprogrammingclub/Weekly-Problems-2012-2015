void setup() {
  //opens serial port, set baud to 9800 bps
  Serial.begin(9800);
}

void loop() {
  int pos = -1;
  int first = -1;
  int second = -1;
  int third = -1;
  int ans = 0;
  
  //clear the input buffer
  while (Serial.available() > 0) {
  Serial.read();
  }
  
  Serial.println("Please enter the number of postions on the lock and then the combination: ");
  
  //wait for an input
  while (Serial.available() == 0) {
    ;
  }
  
  //get input
  pos = Serial.parseInt();
  first = Serial.parseInt();
  second = Serial.parseInt();
  third = Serial.parseInt();
  
  //check boundaries
  if ((first >= pos)||(first < 0)){
    Serial.println("Error: First value is out of bounds!");
  }else if ((second >= pos)||(second < 0)){
    Serial.println("Error: Second value is out of bounds!");
  }else if ((third >= pos)||(third < 0)){ 
    Serial.println("Error: Third value is out of bounds!");
  }else if ((pos > 255)||(pos < 1)){
    Serial.println("Error: Positions value is out of bounds!");
  }else{
    
    //all boundaries are satisifed, can do the math:
    ans += 3*pos;
    ans += first*2;
    ans -= second*2;
    ans += third;
    if(first < second){
      ans += pos;
    }
    if (second > third){
     ans += pos;
    }
    
    //print answer
    Serial.print("Total increments: ");
    Serial.println(ans);
    Serial.println("");
    
    //delay before restarting loop
    delay (3000);
    
    //alternate math:
    /*
    ans += pos*2;
    ans += first;
    ans += pos;
    if(first < second){
      ans += first-second+pos;
    }else{
      ans += first-second;
    }
    if (second > third){
     ans += third-second+pos;
    }else{
     ans += third-second; 
    }
    */
  }
}
