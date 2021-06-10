// Part(a) of Question 3

package main

import (
	"fmt"
	"strings"
)

const alphabet = "abcdefghijklmnopqrstuvwxyz"

func CaesarCipher(m string, shift int) string {
	shift %= 26
	b := []byte(m)
	for i, c := range b {
		c |= 0x20
		if 'a' <= c && c <= 'z' {
			b[i] = alphabet[(int(('z'-'a'+1)+(c-'a'))+shift)%26]
		}
	}
	upperStr := strings.ToUpper(string(b))
	str := strings.Replace(upperStr, " ", "", -1)
	str = strings.Replace(str, "!", "", -1)
	return string(str)
}

func main() {
	fmt.Println(CaesarCipher("I love CS!", 5))
}
