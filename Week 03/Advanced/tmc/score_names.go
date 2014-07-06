// PE#22
// reads stdin
package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"sort"
	"strings"
)

func scoreString(s string) (result int) {
	for _, c := range s {
		result += int(byte(c) - 'A' + 1)
	}
	return
}

func main() {
	buf, _ := ioutil.ReadAll(os.Stdin)
	names := strings.Split(string(buf), ",")
	sort.Strings(names)
	score := 0
	for i, s := range names {
		s = strings.Trim(s, "\"")
		score += (i + 1) * scoreString(s)
	}
	fmt.Println(score)
}
