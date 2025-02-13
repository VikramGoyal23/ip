package task;

import java.util.ArrayList;

public class Task {
    //@@author VikramGoyal23-reused
    // Reused from https://nus-cs2103-ay2425s2.github.io/website/se-book-adapted/projectDuke/

    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns status icon of task instance.
     *
     * @return Status icon.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    //@@author

    void setDone(boolean done) {
        isDone = done;
    }

    /**
     * Sets the completion status of the task as complete.
     *
     */
    public void markAsDone() {
        setDone(true);
        System.out.println("\t " + "I've marked this task as done: ");
        System.out.println("\t\t" + this);
    }

    /**
     * Sets the completion status of the task as incomplete.
     *
     */
    public void markAsUndone() {
        setDone(false);
        System.out.println("\t " + "I've marked this task as incomplete: ");
        System.out.println("\t\t" + this);
    }

    /**
     * Returns description of task instance.
     *
     * @return Task description.
     */
    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return "";
    }

    /**
     * Adds task to array passed in as argument at specified index.
     * Returns the index of the next position to add a task.
     *
     * @param tasks Array to which task must be added.
     * @param task Task to be added.
     *
     * @throws IllegalArgumentException If task description is blank.
     */
    public static void addToList(ArrayList<Task> tasks, Task task) throws IllegalArgumentException {
        if (task.getDescription().isBlank()) {
            throw new IllegalArgumentException("\t !!Please add a description for the task!!");
        }
        tasks.add(task);
        System.out.println("\t I've added: \n\t\t" + task);
        System.out.println("\t There's now " + tasks.size() + " task(s) in the list.");
    }

    @Override
    public String toString() {
        return "[" + getCategory() + "]" + "[" + getStatusIcon() + "] " + getDescription();
    }
}
