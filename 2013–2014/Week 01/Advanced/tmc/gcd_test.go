package gcd

import "testing"

func TestGcd(t *testing.T) {
	if Gcd(0, 0) != 0 {
		t.Error("0 !=", Gcd(0, 0))
	}
}	if Gcd(30, 4) != Gcd(4, 30) || Gcd(4, 30) != 2 {
		t.Error("!=", Gcd(30, 4), Gcd(4, 30), 2)
	}

