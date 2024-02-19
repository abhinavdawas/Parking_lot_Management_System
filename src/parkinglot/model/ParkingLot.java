package parkinglot.model;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private Map<Integer, Car> parkingSlots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingSlots = new HashMap<>();
        for (int i = 1; i <= capacity; i++) {
            parkingSlots.put(i, null);
        }
    }

    public int park(Car car) {
        for (int i = 1; i <= capacity; i++) {
            if (parkingSlots.get(i) == null) {
                parkingSlots.put(i, car);
                return i;
            }
        }
        return -1; // Parking lot is full
    }

    public boolean leave(int slot) {
        if (slot < 1 || slot > capacity) {
            return false; // Invalid slot number
        }
        if (parkingSlots.get(slot) == null) {
            return false; // Slot is already empty
        }
        parkingSlots.put(slot, null);
        return true;
    }

    public void status() {
        System.out.println("Slot No. Registration No Colour");
        for (int i = 1; i <= capacity; i++) {
            Car car = parkingSlots.get(i);
            if (car != null) {
                System.out.println(i + " " + car.getRegistrationNumber() + " " + car.getColor());
            }
        }
    }

    public String getRegistrationNumbersForColor(String color) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= capacity; i++) {
            Car car = parkingSlots.get(i);
            if (car != null && car.getColor().equalsIgnoreCase(color)) {
                result.append(car.getRegistrationNumber()).append(", ");
            }
        }
        return result.length() > 0 ? result.substring(0, result.length() - 2) : "Not found";
    }

    public int getSlotNumberForRegistration(String registrationNumber) {
        for (int i = 1; i <= capacity; i++) {
            Car car = parkingSlots.get(i);
            if (car != null && car.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                return i;
            }
        }
        return -1; // Not found
    }

    public String getSlotNumbersForColor(String color) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= capacity; i++) {
            Car car = parkingSlots.get(i);
            if (car != null && car.getColor().equalsIgnoreCase(color)) {
                result.append(i).append(", ");
            }
        }
        return result.length() > 0 ? result.substring(0, result.length() - 2) : "Not found";
    }

    public int getCapacity() {
        return capacity;
    }
}
