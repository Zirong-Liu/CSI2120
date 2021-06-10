package main

import (
	"fmt"
	"sync"
	"time"
)

func process(v int, wg *sync.WaitGroup) {
	time.Sleep(1500 * time.Millisecond) // simulate compute time
	fmt.Println(2 * v)
	defer wg.Done()
}
func main() {
	var wg sync.WaitGroup
	for _, value := range []int{9, 35, 27, 56, 88, 80} {
		wg.Add(1)
		go process(value, &wg)
	}
	wg.Wait()
}
