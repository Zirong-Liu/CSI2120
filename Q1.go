package main

import (
	"fmt"
	"strconv"
)

type StaffMember interface {
	toString() string
	pay() float32
}

type Volunteer struct {
	name    string
	address string
	phone   string
}

func (V *Volunteer) toString() string {
	var result string = "Name: " + V.name + "\n"
	result += "Address: " + V.address + "\n"
	result += "Phone: " + V.phone
	return result
}
func (V *Volunteer) pay() float32 {
	return 0.0
}
func (V *Volunteer) Init(eName string, eAddress string, ePhone string) {
	V.name = eName
	V.address = eAddress
	V.phone = ePhone
}

type Employee struct {
	StaffMember
	name                 string
	address              string
	phone                string
	socialSecurityNumber string
	payRate              float32
}

type Executive struct {
	Employee
	bonus float32
}

type Hourly struct {
	Employee
	hoursWorked int
}

func (E *Employee) Init(eName string, eAddress string, ePhone string, socSecNumber string, rate float32) {
	E.name = eName
	E.address = eAddress
	E.phone = ePhone
	E.socialSecurityNumber = socSecNumber
	E.payRate = rate
}

func (E *Employee) toString() string {
	var result string = "Name: " + E.name + "\n"
	result += "Address: " + E.address + "\n"
	result += "Phone: " + E.phone
	result += "\nSocial Security Number: " + E.socialSecurityNumber
	return result
}
func (E *Employee) pay() float32 {
	return E.payRate
}

func (E *Executive) Init(eName string, eAddress string, ePhone string, socSecNumber string, rate float32) {
	E.name = eName
	E.address = eAddress
	E.phone = ePhone
	E.socialSecurityNumber = socSecNumber
	E.payRate = rate
	E.bonus = 0
}
func (H *Hourly) Init(eName string, eAddress string, ePhone string, socSecNumber string, rate float32) {
	H.name = eName
	H.address = eAddress
	H.phone = ePhone
	H.socialSecurityNumber = socSecNumber
	H.payRate = rate
	H.hoursWorked = 0
}

func (E *Executive) awardBonus(execBonus float32) {
	E.bonus = execBonus
}
func (E *Executive) pay() float32 {
	var payment = E.payRate + E.bonus
	E.bonus = 0
	return payment
}
func (H *Hourly) addHours(moreHours int) {
	H.hoursWorked += moreHours
}

func (H *Hourly) pay() float32 {
	var payment = H.payRate * float32(H.hoursWorked)
	H.hoursWorked = 0
	return payment
}
func (E *Executive) toString() string {
	var result = "Name: " + E.name + "\n"
	result += "Address: " + E.address + "\n"
	result += "Phone: " + E.phone
	return result
}
func (H *Hourly) toString() string {
	var result = "Name: " + H.name + "\n"
	result += "Address: " + H.address + "\n"
	result += "Phone: " + H.phone
	result += "\nCurrent hours: " + strconv.Itoa(H.hoursWorked)
	return result
}

func main() {
	var staffList [6]StaffMember
	e1 := Executive{}
	e1.Init("Sam", "123 Main Line",
		"555-0469", "123-45-6789", 2423.07)
	e2 := Employee{}
	e2.Init("Carla", "456 Off Line",
		"555-0101", "987-65-4321", 1246.15)
	e3 := Employee{}
	e3.Init("Woody", "789 Off Rocker",
		"555-0000", "010-20-3040", 1169.23)
	e4 := Hourly{}
	e4.Init("Diane", "678 Fifth Ave.",
		"555-0690", "958-47-3625", 10.55)
	e5 := Volunteer{}
	e5.Init("Norm", "987 Suds Blvd.",
		"555-8374")
	e6 := Volunteer{}
	e6.Init("Cliff", "321 Duds Lane",
		"555-7282")
	e1.awardBonus(500.00)
	e4.addHours(40)
	staffList[0] = &e1
	staffList[1] = &e2
	staffList[2] = &e3
	staffList[3] = &e4
	staffList[4] = &e5
	staffList[5] = &e6

	var amount float32 = 0
	for i := 0; i < 6; i++ {

		fmt.Println(staffList[i].toString())
		amount = staffList[i].pay() // polymorphic
		if amount == 0.0 {
			fmt.Println("Thanks!")
		} else {

			fmt.Println("Paid: " + strconv.FormatFloat(float64(amount), 'f', 2, 32))
		}
		fmt.Println("-----------------------------------")
	}

}
