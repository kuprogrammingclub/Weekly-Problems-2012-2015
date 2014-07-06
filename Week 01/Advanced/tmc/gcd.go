package gcd

import (
	"fmt"
)

func Gcd(a, b int) int {
	for a != b {
		if b < a {
			b, a = a, b
		}
		b = b - a
	}
	return a
}
