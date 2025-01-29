package main;

import task.Deadline;
import task.Event;
import task.Task;
import task.ToDo;

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
        Task[] tasks = new Task[100];
        int i = 0;

        loop: while (true) {
            String input = sc.nextLine();
            System.out.print(separator);
            String[] tokens = input.split(" ", 2);
            String command = tokens[0];
            switch (command.toLowerCase()) {
            case "list":
                for (int j = 0; j < 100; j++) {
                    if (tasks[j] == null) {
                        break;
                    } else {
                        System.out.println("\t " + (j + 1) + ". " + tasks[j]);
                    }
                }
                break;
            case "bye":
                break loop;
            case "mark":
                tasks[Integer.parseInt(tokens[1]) - 1].markAsDone();
                break;
            case "unmark":
                tasks[Integer.parseInt(tokens[1]) - 1].markAsUndone();
                break;
            case "todo":
                tasks[i] = new ToDo(tokens[1]);
                System.out.println("\t I've added: \n\t\t" + tasks[i]);
                i += 1;
                System.out.println("\t There's now " + i + " task(s) in the list.");
                break;
            case "deadline":
                tasks[i] = new Deadline(tokens[1].split(" /by")[0],tokens[1].split("/by ")[1]);
                System.out.println("\t I've added: \n\t\t" + tasks[i]);
                i += 1;
                System.out.println("\t There's now " + i + " task(s) in the list.");
                break;
            case "event":
                tasks[i] = new Event(tokens[1].split(" /from")[0],
                        tokens[1].split("/from ")[1].split(" /to")[0],
                        tokens[1].split("/to ")[1]);
                System.out.println("\t I've added: \n\t\t" + tasks[i]);
                i += 1;
                System.out.println("\t There's now " + i + " task(s) in the list.");
                break;
            default:
                System.out.println("\t I'm sorry, I don't know what that means!");
                break;
            }
            System.out.print(separator);
        }
        System.out.println(farewell + separator);
    }
}
