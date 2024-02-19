package parkinglot.service;

import parkinglot.model.Car;
import parkinglot.model.ParkingLot;

public class ParkingLotManager {
    private ParkingLot parkingLot;

    public ParkingLotManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void createParkingLot(int capacity) {
        if (capacity <= 0) {
            System.out.println("Invalid capacity. Capacity must be greater than zero.");
            return;
        }
        parkingLot = new ParkingLot(capacity);
        System.out.println("Created a parking lot with " + capacity + " slots");
    }

    public void park(Car car) {
        if (parkingLot == null) {
            System.out.println("Parking lot is not created yet");
            return;
        }
        int slotNumber = parkingLot.park(car);
        if (slotNumber == -1) {
            System.out.println("Sorry, parking lot is full");
        } else {
            System.out.println("Allocated slot number: " + slotNumber);
        }
    }

    public void leave(int slot) {
        if (parkingLot == null) {
            System.out.println("Parking lot is not created yet");
            return;
        }
        if (slot < 1 || slot > parkingLot.getCapacity()) {
            System.out.println("Invalid slot number");
            return;
        }
        boolean success = parkingLot.leave(slot);
        if (success) {
            System.out.println("Slot number " + slot + " is free");
        } else {
            System.out.println("Slot number " + slot + " is already free");
        }
    }

    public void status() {
        if (parkingLot == null) {
            System.out.println("Parking lot is not created yet");
            return;
        }
        parkingLot.status();
    }

    public void getRegistrationNumbersForColor(String color) {
        if (parkingLot == null) {
            System.out.println("Parking lot is not created yet");
            return;
        }
        String registrationNumbers = parkingLot.getRegistrationNumbersForColor(color);
        System.out.println(registrationNumbers.equals("Not found") ? "Not found" : registrationNumbers);
    }

    public void getSlotNumberForRegistration(String registrationNumber) {
        if (parkingLot == null) {
            System.out.println("Parking lot is not created yet");
            return;
        }
        int slotNumber = parkingLot.getSlotNumberForRegistration(registrationNumber);
        if (slotNumber == -1) {
            System.out.println("Not found");
        } else {
            System.out.println(slotNumber);
        }
    }

    public void getSlotNumbersForColor(String color) {
        if (parkingLot == null) {
            System.out.println("Parking lot is not created yet");
            return;
        }
        String slotNumbers = parkingLot.getSlotNumbersForColor(color);
        System.out.println(slotNumbers.equals("Not found") ? "Not found" : slotNumbers);
    }
}
