package tyler.ui;

import java.util.Scanner;

import tyler.task.Task;

/**
 * Handles user interactions in the application.
 */
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

    private Scanner scanner = new Scanner(System.in);

    public Ui() {
    }

    /**
     * Displays the greeting when the application starts.
     */
    public void showGreeting() {
        System.out.println("Hello from\n" + LOGO);
        System.out.print(SEPARATOR + GREETING + SEPARATOR);
    }

    /**
     * Displays the line separator.
     */
    public void showSeparator() {
        System.out.print(SEPARATOR);
    }

    /**
     * Displays a deleted task.
     */
    public void showDeletedTask(Task deletedTask) {
        System.out.println("\t I've removed this task: \n" + "\t " + deletedTask);
    }

    /**
     * Displays the size of a list of tasks.
     */
    public void showTasksLength(int size) {
        System.out.println("\t There are " + size + " tasks left in the list.");
    }

    /**
     * Displays a task with its details.
     */
    public void showTask(int index, Task task) {
        System.out.println("\t " + index + ". " + task);
    }

    /**
     * Displays the farewell message when the program ends and closes the scanner.
     */
    public void showFarewell() {
        System.out.print(FAREWELL);
        scanner.close();
    }

    /**
     * Displays an error message when the file containing the tasks cannot be loaded.
     */
    public void showLoadingError() {
        System.out.println("\t " + "!!Old tasks could not be loaded!!\n" + SEPARATOR);
    }

    public void showFindCommandHeader() {
        System.out.println("\t " + "Here are the matching tasks in your list:" );
    }

    /**
     * Reads a command from the user as input.
     *
     * @return The user input as a string.
     */
    public String readCommand() {
        return scanner.nextLine();
    }
}
