// Part(b) of Question 3

package main

import (
	"fmt"
	"sync"
)

const alphabet = "abcdefghijklmnopqrstuvwxyz"

func CaesarCipherList(m []string, shift int) string {
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
	str = strings.Replace(str, "/", "", -1)
	str = strings.Replace(str, "1", "", -1)
	str = strings.Replace(str, "2", "", -1)
	str = strings.Replace(str, "3", "", -1)
	str = strings.Replace(str, "4", "", -1)
	str = strings.Replace(str, "5", "", -1)
	str = strings.Replace(str, "6", "", -1)
	str = strings.Replace(str, "7", "", -1)
	str = strings.Replace(str, "8", "", -1)
	str = strings.Replace(str, "9", "", -1)
	return string(str)
}

func main() {

    // List of messages
    messages:= []string{"Csi2520", "Csi2120", "3 Paradigms", 
                        "Go is 1st", "Prolog is 2nd", "Scheme is 3rd", 
                        "uottawa.ca", "csi/elg/ceg/seg", "800 King Edward"}

    // Create channels
    var channel chan int = make(chan int)

    // call go funtion
    go CaesarCipherList(messages[:],2) {
    	message <- messages
		    }// send channels

    // print results 
    fmt.Println(<-message)
    // add synchronisation 
    wp := new(sync.WaitGroup)
    wp.Wait()

}
