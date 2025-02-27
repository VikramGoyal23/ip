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

    private String message;

    private Scanner scanner = new Scanner(System.in);

    public Ui() {
    }

    /**
     * Displays the greeting when the application starts.
     */
    public void showGreeting() {
        this.message = ("Hello from\n" + LOGO + "\n"
                + SEPARATOR + GREETING + SEPARATOR);
    }

//    /**
//     * Displays the line separator.
//     */
//    public void showSeparator() {
//        System.out.print(SEPARATOR);
//    }

    /**
     * Displays a deleted task.
     */
    public void showDeletedTask(Task deletedTask) {
        this.message =  "\t I've removed this task: \n" + "\t " + deletedTask;
    }

    /**
     * Displays the size of a list of tasks.
     */
    public void showTasksLength(int size) {
        this.message = "\t There are " + size + " tasks in the list.";
    }

    /**
     * Displays a task with its details.
     */
    public void showListTask(int index, Task task) {
        this.message = "\t " + index + ". " + task;
    }

    /**
     * Displays a task with its details.
     */
    public void showTaskWithTab(Task task) {
        this.message = "\t\t" + task;
    }

    /**
     * Displays an added task with its details.
     */
    public void showAddedTask(Task task) {
        this.message = "\t I've added: \n\t\t" + task;
    }

    /**
     * Displays the farewell message when the program ends and closes the scanner.
     */
    public void showFarewell() {
        this.message = FAREWELL;
        scanner.close();
    }

    /**
     * Displays an error message when the file containing the tasks cannot be loaded.
     */
    public void showLoadingError() {
        this.message = "\t " + "!!Old tasks could not be loaded!!\n" + SEPARATOR;
    }

    public void showFindCommandHeader() {
        this.message = "\t " + "Here are the matching tasks in your list:\n";
    }

    /**
     * Displays a message to the user.
     *
     * @param message The message to be shown.
     */
    public void showMessage(String message) {
        this.message = message;
    }

    /**
     * Reads a command from the user as input.
     *
     * @return The user input as a string.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Returns the UI message.
     *
     * @return The current message of the UI.
     */
    public String getMessage() {
        return this.message;
    }

}
