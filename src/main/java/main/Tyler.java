package main;

import java.util.Scanner;

public class Tyler {
    public static void main(String[] args) {
        String logo = "  _____      _           \n"
                + " |_   _|   _| | ___ _ __ \n"
                + "   | || | | | |/ _ \\ '__|\n"
                + "   | || |_| | |  __/ |   \n"
                + "   |_| \\__, |_|\\___|_|   \n"
                + "       |___/             \n";
        System.out.println("Hello from\n" + logo);

        String separator = "\t"
                + "____________________________________________________________\n";
        String greeting = "\t" + " Hello! I'm Tyler!\n"
                + "\t" + " What can I do for you?\n";
        String farewell = "\t" + " Bye-bye now!\n";
        System.out.print(separator + greeting
                + separator);

        Scanner sc = new Scanner(System.in);
        String[] tasks = new String[100];
        int i = 0;

        while (true) {
            String input = sc.nextLine();
            System.out.print(separator);
            if (input.equals("list")) {
                for (int j = 0; j < 100; j++) {
                    if (tasks[j] == null) {
                        break;
                    } else {
                        System.out.println("\t " + (j + 1)
                                + ". " + tasks[j]);
                    }
                }
            } else if (input.equals("bye")) {
                break;
            } else {
                tasks[i] = input;
                i += 1;
                System.out.println("\t added: " + input);
            }
            System.out.print(separator);
        }
        System.out.println(farewell + separator);
    }
}
