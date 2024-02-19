

package parkinglot;

import parkinglot.service.CommandParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandParser commandParser = new CommandParser();

        while (true) {
            String command = scanner.nextLine();
            commandParser.parseCommand(command);
        }
    }
}


