# Automated-Parking-System

## Problem Statement 

Automated Parking System that allows customers  to use parking lots without human intervention.
Consider a parking lot with ‘n’ cars and the slots are numbered from 1 to n increasing with increasing distance from the entry point in steps of one. A ticket is issued to the driver and the customer should be allocated a parking slot nearest to the entry. The parking lot administrator can view the slots where the cars are parked and their details like registration number, color of the car, slot in which a car with a particular number or color is parked and a list of all available slots. All the system interaction is done using a set of commands without manual allocation or entry of details.

## Functionalities

- A ticket is issued for every car of a customer based on the registration number and color of the car.
- The ticket should be issued for the available free slot nearest to the entry of the parking lot.
- We can have ‘n’ such parking lots and then the system suggests the parking lots, with vacant slots, that are nearest to the user.
At any point of time the system should provide :
    - Registration numbers of all cars of a particular color.
    - Slot number in which a car with a given registration number is parked.
    - Slot numbers of all slots where a car of a particular color is parked.
- When a car leaves the parking lot, the parking slot that was occupied by that car should be marked as vacant.
- Two types of system interaction is provided :
    - Interactive command prompt based shell where commands can be typed in
    - Accept a filename as a parameter at the command prompt and read the commands from that file
- Keep track of time for which a car is parked which can be used in determining the parking fees.
- Invoice generation for each customer billed according to the duration for which it is parked.

## LICENSE
MIT




