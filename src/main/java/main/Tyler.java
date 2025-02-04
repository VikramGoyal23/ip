package main;

import task.Deadline;
import task.Event;
import task.Task;
import task.ToDo;

import java.io.IOException;
import java.io.FileWriter;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;

public class Tyler {
    public static void main(String[] args) throws IOException {

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
        System.out.print(separator + greeting + separator);

        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        String home = System.getProperty("user.dir");
        Path dirPath = Paths.get(home, "data");
        boolean hasDataDir = Files.exists(dirPath);
        if (!hasDataDir) {
            Files.createDirectories(dirPath);
        }
        Path tylerPath = Paths.get(home,"data", "tyler.txt");
        boolean hasTylerFile = Files.exists(tylerPath);
        if (!hasTylerFile) {
            Files.createFile(tylerPath);
        }

        List<String> stored = Files.readAllLines(tylerPath);
        for (String item: stored) {
            List<String> itemTokens = Arrays.asList(item.split("\\|"));
            itemTokens.replaceAll(String::strip);
            boolean isNewAdded = false;
            if (itemTokens.get(0).equals("T") && itemTokens.size() == 3) {
                tasks.add(new ToDo(itemTokens.get(2)));
                isNewAdded = true;

            } else if (itemTokens.get(0).equals("D") && itemTokens.size() == 4) {
                tasks.add(new Deadline(itemTokens.get(2), itemTokens.get(3)));
                isNewAdded = true;
            } else if (itemTokens.get(0).equals("E") && itemTokens.size() == 5) {
                tasks.add(new Event(itemTokens.get(2), itemTokens.get(3), itemTokens.get(4)));
                isNewAdded = true;
            }
            if (isNewAdded && itemTokens.get(1).equals("1")) {
                tasks.get(tasks.size() - 1).markAsDone();
            }
        }

        loop: while (true) {
            try {
                String input = sc.nextLine();
                System.out.print(separator);
                String[] tokens = input.split(" ", 2);
                String command = tokens[0];
                switch (command.toLowerCase()) {
                case "list":
                    for (int j = 0; j < tasks.size(); j++) {
                        System.out.println("\t " + (j + 1) + ". " + tasks.get(j));
                    }
                    break;
                case "bye":
                    break loop;
                case "mark":
                    tasks.get(Integer.parseInt(tokens[1]) - 1).markAsDone();
                    break;
                case "unmark":
                    tasks.get(Integer.parseInt(tokens[1]) - 1).markAsUndone();
                    break;
                case "delete":
                    System.out.println("\t I've removed this task: \n"
                            + "\t " + tasks.remove(Integer.parseInt(tokens[1]) - 1));
                    System.out.println("\t There are " + tasks.size() + " tasks left in the list.");
                    break;
                case "todo":
                    ToDo toDo = new ToDo(tokens[1]);
                    Task.addToList(tasks, toDo);
                    break;
                case "deadline":
                    if (!tokens[1].contains("/by") || tokens[1].split("/by ")[1].isBlank()) {
                        throw new IllegalArgumentException("\t !!Deadline must include a 'by' time!!");
                    }
                    Deadline deadline = new Deadline(
                            tokens[1].split(" /by")[0], tokens[1].split("/by ")[1]);
                    Task.addToList(tasks, deadline);
                    break;
                case "event":
                    if (!tokens[1].contains("/from") || !tokens[1].contains("/to")
                            || tokens[1].split("/from ")[1].split(" /to")[0].isBlank()
                            || tokens[1].split("/to ")[1].isBlank()
                    ) {
                        throw new IllegalArgumentException(
                                "\t !!Event must include a 'from' time and 'to' time!!");
                    }
                    Event event = new Event(tokens[1].split(" /from")[0],
                            tokens[1].split("/from ")[1].split(" /to")[0],
                            tokens[1].split("/to ")[1]);
                    Task.addToList(tasks, event);
                    break;
                default:
                    throw new IllegalArgumentException("\t !!I'm sorry, I don't know what that means!!");
                }
            } catch (NumberFormatException e) {
                System.out.println("\t !!Please enter a number as the argument!!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("\t !!Please provide the correct number of arguments!!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\t !!There aren't this many tasks in the list!!");
            }
            System.out.print(separator);
        }
        List<String> formattedTasks = getFormattedTasks(tasks);
        Files.write(tylerPath, formattedTasks);
        System.out.println(farewell + separator);
    }

    private static List<String> getFormattedTasks(ArrayList<Task> tasks) {
        List<String> formattedTasks = new ArrayList<>();
        for (Task t: tasks) {
            int completed = t.getStatusIcon().equals("X") ? 1 : 0;
            String formattedTask = t.getCategory() + "|" + completed + "|" + t.getDescription();
            if (t.getCategory().equals("D")) {
                Deadline d = (Deadline) t;
                formattedTask = formattedTask + "|" + d.getBy();
            } else if (t.getCategory().equals("E")) {
                Event e = (Event) t;
                formattedTask = formattedTask + "|" + e.getFrom() + "|" + e.getTo();
            }
            formattedTasks.add(formattedTask);
        }
        return formattedTasks;
    }
}
