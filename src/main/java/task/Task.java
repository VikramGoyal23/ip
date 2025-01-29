package task;

public class Task {
    //@@author VikramGoyal23-reused
    // Reused from https://nus-cs2103-ay2425s2.github.io/website/se-book-adapted/projectDuke/

    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    //@@author

    void setDone(boolean done) {
        isDone = done;
    }

    public void markAsDone() {
        setDone(true);
        System.out.println("\t " + "I've marked this task as done: ");
        System.out.println("\t\t" + this);
    }

    public void markAsUndone() {
        setDone(false);
        System.out.println("\t " + "I've marked this task as incomplete: ");
        System.out.println("\t\t" + this);
    }

    public String getDescription() {
        return description;
    }

    // Will try to implement properly soon
    public int addToList(Task[] tasks, int index) {
        System.out.println("\t I've added: \n\t\t" + tasks[index]);
        index += 1;
        System.out.println("\t There's now " + index + " task(s) in the list.");
        return index;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription();
    }
}
