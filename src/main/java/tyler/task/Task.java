package tyler.task;

public class Task {
    //@@author VikramGoyal23-reused
    // Reused from https://nus-cs2103-ay2425s2.github.io/website/se-book-adapted/projectDuke/

    private String description;
    private boolean isDone;

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

    private void setDone(boolean isDone) {
        this.isDone = isDone;
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

    @Override
    public String toString() {
        return "[" + getCategory() + "]" + "[" + getStatusIcon() + "] " + getDescription();
    }
}
