package fuelcostcalculator;

import java.util.Scanner; // Required to access the Scanner class [4]

public class FuelCostCalculator // Class names should use Upper Camel casing [5, 6]
{
    public static void main(String[] args) // The entry point of the application [2, 7]
    {
        // Create a Scanner object to read from the standard input device (keyboard) [3, 4]
        Scanner inputDevice = new Scanner(System.in);

        // Declare variables using the double data type for decimal precision [8, 9]
        double tripDistance;
        double fuelEfficiency;
        double fuelPrice;
        double fuelNeeded;
        double totalCost;

        // Prompt the user and retrieve input using nextDouble() [4, 10, 11]
        System.out.print("Enter the total trip distance (in kilometers) >> ");
        tripDistance = inputDevice.nextDouble();

        System.out.print("Enter the car's fuel efficiency (km per liter) >> ");
        fuelEfficiency = inputDevice.nextDouble();

        System.out.print("Enter the fuel price per liter >> ");
        fuelPrice = inputDevice.nextDouble();

        // Calculate fuel required using the division operator (/) [12]
        fuelNeeded = tripDistance / fuelEfficiency;

        // Calculate total cost using the multiplication operator (*) [12]
        totalCost = fuelNeeded * fuelPrice;

        // Display the total fuel cost using String concatenation (+) [4, 13]
        System.out.println("The total fuel cost for your trip is: $" + totalCost);
        
        // Close the scanner
        inputDevice.close();
    }
}