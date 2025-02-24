package tyler.ui;

import tyler.task.Task;

import java.util.Scanner;

public class Ui {
    private static final String LOGO = "  _____      _           \n"
            + " |_   _|   _| | ___ _ __ \n"
            + "   | || | | | |/ _ \\ '__|\n"
            + "   | || |_| | |  __/ |   \n"
            + "   |_| \\__, |_|\\___|_|   \n"
            + "       |___/             \n";
    private static final String SEPARATOR = "\t"
            + "____________________________________________________________\n";
    private static final String GREETING = "\t" + " Hello! I'm Tyler!\n"
            + "\t" + " What can I do for you?\n";
    private static final String FAREWELL = "\t" + " Bye-bye now!\n";

    private Scanner sc = new Scanner(System.in);

    public Ui() {
    }

    public void showGreeting() {
        System.out.println("Hello from\n" + LOGO);
        System.out.print(SEPARATOR + GREETING + SEPARATOR);
    }

    public void showSeparator() {
        System.out.print(SEPARATOR);
    }

    public void showDeletedTask(Task deletedTask) {
        System.out.println("\t I've removed this task: \n" + "\t " + deletedTask);
    }

    public void showTasksLength(int size) {
        System.out.println("\t There are " + size + " tasks left in the list.");
    }

    public void showTask(int index, Task task) {
        System.out.println("\t " + index + ". " + task);
    }

    public void showFarewell() {
        System.out.print(FAREWELL);
        sc.close();
    }

    public void showLoadingError() {
        System.out.println("\t " + "Old tasks could not be loaded.\n" + SEPARATOR);
    }

    public void showFindCommandHeader() {
        System.out.println("\t " + "Here are the matching tasks in your list:" );
    }

    public String readCommand() {
        return sc.nextLine();
    }
}
