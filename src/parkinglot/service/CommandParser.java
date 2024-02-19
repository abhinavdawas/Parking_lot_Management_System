package parkinglot.service;

import parkinglot.model.Car;

public class CommandParser {
    private ParkingLotManager parkingLotManager;

    public CommandParser() {
        this.parkingLotManager = new ParkingLotManager(null);
    }

    public void parseCommand(String command) {
        String[] tokens = command.trim().split("\\s+");
        if (tokens.length == 0) {
            System.out.println("Invalid command");
            return;
        }

        String commandName = tokens[0].toLowerCase();
        String[] args = new String[tokens.length - 1];
        System.arraycopy(tokens, 1, args, 0, args.length);

        switch (commandName) {
            case "create_parking_lot":
                if (args.length != 1) {
                    System.out.println("Invalid arguments for create_parking_lot command");
                    return;
                }
                int capacity;
                try {
                    capacity = Integer.parseInt(args[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid capacity format");
                    return;
                }
                parkingLotManager.createParkingLot(capacity);
                break;
            case "park":
                if (args.length != 2) {
                    System.out.println("Invalid arguments for park command");
                    return;
                }
                parkingLotManager.park(new Car(args[0], args[1]));
                break;
            case "leave":
                if (args.length != 1) {
                    System.out.println("Invalid arguments for leave command");
                    return;
                }
                int slot;
                try {
                    slot = Integer.parseInt(args[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid slot format");
                    return;
                }
                parkingLotManager.leave(slot);
                break;
            case "status":
                parkingLotManager.status();
                break;
            case "registration_numbers_for_cars_with_colour":
                if (args.length != 1) {
                    System.out.println("Invalid arguments for registration_numbers_for_cars_with_colour command");
                    return;
                }
                parkingLotManager.getRegistrationNumbersForColor(args[0]);
                break;
            case "slot_number_for_registration_number":
                if (args.length != 1) {
                    System.out.println("Invalid arguments for slot_number_for_registration_number command");
                    return;
                }
                parkingLotManager.getSlotNumberForRegistration(args[0]);
                break;
            case "slot_numbers_for_cars_with_colour":
                if (args.length != 1) {
                    System.out.println("Invalid arguments for slot_numbers_for_cars_with_colour command");
                    return;
                }
                parkingLotManager.getSlotNumbersForColor(args[0]);
                break;
            default:
                System.out.println("Invalid command");
        }
    }
}
