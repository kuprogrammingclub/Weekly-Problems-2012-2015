package main

import (
	"bytes"
	"fmt"
	"io"
	"os"
)

func main() {
	fmt.Println(string(grade(os.Stdin)))
}

type record struct {
	name   string
	grades []float64
	avg    float64
}

func grade(in io.Reader) []byte {
	var n, m int
	fmt.Fscanln(in, &n, &m)

	records := []record{}

	var overallavg float64
	for i := 0; i < n; i++ {
		r := record{}
		fmt.Fscan(in, &r.name)
		for j := 0; j < m; j++ {
			var tmp float64
			fmt.Fscan(in, &tmp)
			r.grades = append(r.grades, tmp)
			r.avg += tmp
		}
		r.avg /= float64(len(r.grades))
		overallavg += r.avg
		records = append(records, r)
	}
	overallavg /= float64(n)

	o := new(bytes.Buffer)
	fmt.Fprintf(o, "%.2f\n", overallavg)
	for _, r := range records {
		fmt.Fprintf(o, "%s %.2f\n", r.name, r.avg)
	}
	return o.Bytes()
}
