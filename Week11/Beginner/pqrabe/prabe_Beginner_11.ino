int i = 1;
void setup(){
  forth();
  forth();  
}
void loop(){
  
  
}
void printer(){
  Serial.println(i);
  i++;
  
}
void first(){//5
 printer(); 
 printer();
 printer();
 printer();
 printer();
}
void second(){//25
 first(); 
 first();
 first();
 first();
 first();
}
void third(){//100
 second();
 second();
 second();
 second();
}
void forth(){//1000
 third();
 third();
 third();
 third();
 third();
}
