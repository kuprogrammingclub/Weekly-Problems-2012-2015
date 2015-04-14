package main

import (
  "fmt"
  "encoding/csv"
  "io"
  "os"
  "math"
  "strconv"
  )

func main() {

  //  Open file
  file, err := os.Open("../lakes.csv")
  if err != nil {
    fmt.Println("Error: ", err)
    return  //  Exit if you receive an error
  }
  defer file.Close()  //  Close file at end

  reader := csv.NewReader(file) //  Create a new reader

  //  Get all data out of csv
  var records[][]string //  Where all values will be stored
  for {
    record, err := reader.Read()
    if err == io.EOF {
      break
    } else if err != nil {
      fmt.Println("Error:", err)
      return
    }
    records = append(records, record)
  }

  //  Get lake size data as strings
  data_col := 2
  var lake_size[]string
  for i := 0; i < len(records); i++ {
    if  records[i][1] == "" || records[i][0] == "LAKE" {
      //  Do nothing
    } else { //  Is the data we want to look at
      lake_size = append(lake_size, records[i][data_col])
    }
  }

  //  Count for each leading integer
  count := map[string]int {
    "1" : 0,
    "2" : 0,
    "3" : 0,
    "4" : 0,
    "5" : 0,
    "6" : 0,
    "7" : 0,
    "8" : 0,
    "9" : 0,
  }
  //  So I can print the counts in order
  keys := [...]string{"1", "2", "3", "4", "5", "6", "7", "8", "9",}

  //  Count all the values
  for i := 0; i < len(lake_size); i++ {
    //  Get the value array as float64
    val, err := strconv.ParseFloat(lake_size[i], 32)
    if err != nil {
      fmt.Println("Error:", err)
      return
    } else {
      //  Find the length of the integer version
      //  of val and subtract 1
      a := float64(len(strconv.Itoa(int(val))) - 1)
      //  Calculate the divisor
      divisor := int(math.Pow(10, a))
      //  Find the leadsing integer
      leading_int := int(val) / divisor
      //  Increment the count
      count[strconv.Itoa(leading_int)]++
    }
  }

  //  Print results in order
  for i := 0; i < len(keys); i++ {
    fmt.Println("value:", keys[i], "count:", count[keys[i]])
  }
}
