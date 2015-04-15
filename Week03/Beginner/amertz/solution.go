package main

import (
  "fmt"
  "bufio"
  "os"
  "strconv"
  "bytes"
  )

func main() {
  reader := bufio.NewReader(os.Stdin)

  //  Get input
  fmt.Println("Enter values")
  line, prefix, err := reader.ReadLine()
  if err != nil {
    fmt.Println("Error:", err)
    return
  } else {
    fmt.Printf("%v, %s, %v\n", line, string(line), prefix)
  }

  //  Convert rows to int
  rows, err := strconv.Atoi(string(line[0]))
  if err != nil {
    fmt.Println("Error:", err)
    return
  } else {
    fmt.Println(rows)
  }

  //  Convert trunk and leaves
  trunk := rune(line[2])
  leaves := rune(line[4])


  s := emptyString(rows)

  //  Get two starting index values
  mid := rows / 2
  right, left := mid, mid
  fmt.Println(right)
  for i:= 0; i <= (rows / 2) + 1; i++ {

    if i < 1 {
      s = replaceAtIndex(s, leaves, right)
    } else if i < (rows / 2) + 1 {
      s = replaceAtIndex(s, leaves, right)
      s = replaceAtIndex(s, leaves, left)
    } else {
      s = emptyString(rows)
      s = replaceAtIndex(s, trunk, mid)
      n := mid
      mid++
      n--
      s = replaceAtIndex(s, trunk, mid)
      s = replaceAtIndex(s, trunk, n)
    }
    fmt.Println(s)
    right++
    left--
  }

}

func replaceAtIndex(in string, r rune, i int) string {
    out := []rune(in)
    out[i] = r
    return string(out)
}

func emptyString(n int) string {
  var buffer bytes.Buffer
  for i := 0; i < n; i++ {
    buffer.WriteString(" ")
  }
  return buffer.String()
}
