package main

import (
	"fmt"
	"math"
	"math/rand"
	"sync"
	"time"
)

// returns true if number is prime
func isPrime(v int64) bool {
	sq := int64(math.Sqrt(float64(v))) + 1
	var i int64
	for i = 2; i < sq; i++ {
		if v%i == 0 {
			return false
		}
	}
	return true
}

// get a random prime number between 1 and maxP
func getPrime(maxP int64) int64 {
	var i int64
	for i = 0; i < maxP; i++ {
		n := rand.Int63n(maxP)
		if isPrime(n) {
			return n
		}
	}
	return 1 // just in case
}
func processQ3(wg *sync.WaitGroup, maxPrime int64, c chan int64) {
	for i := 0; i < 2000; i++ {
		p := getPrime(maxPrime) // add a new prime
		//fmt.Println(p)
		c <- p
	}
	defer wg.Done()

}
func main() {
	var primes []int64              // slice of prime numbers
	const maxPrime int64 = 10000000 // max value for primes
	c := make(chan int64, 10000)
	var wg sync.WaitGroup
	wg.Add(5)
	start := time.Now()
	go processQ3(&wg, maxPrime, c)
	go processQ3(&wg, maxPrime, c)
	go processQ3(&wg, maxPrime, c)
	go processQ3(&wg, maxPrime, c)
	go processQ3(&wg, maxPrime, c)

	for i := 0; i < 10000; i++ {
		primes = append(primes, <-c)
	}
	wg.Wait()
	end := time.Now()
	fmt.Println("End of program.", end.Sub(start))
}
