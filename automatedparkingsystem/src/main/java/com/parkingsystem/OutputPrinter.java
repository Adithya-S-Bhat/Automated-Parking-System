package com.parkingsystem;

public class OutputPrinter {

    public void welcome() {
        printWithNewLine("Welcome to the Parking Lot.");
    }

    public void end() {
        printWithNewLine("Thank you for using our Parking Lot Service.");
    }

    public void notFound() {
        printWithNewLine("Not found.");
    }

    public void statusHeader() {
        printWithNewLine("Slot No.    Registration No    Colour");
    }

    public void parkingLotFull() {
        printWithNewLine("Parking Lot is full.");

    }

    public void parkingLotEmpty() {
        printWithNewLine("Parking Lot is empty.");
    }
    
    public void invalidFile() {
        printWithNewLine("Invalid file given.");
    }

    public void printWithNewLine(final String msg) {
        System.out.println(msg);
    
    }
    
}


