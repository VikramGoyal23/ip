package task;

public class Task {
    //@@author VikramGoyal23-reused
    // Reused from https://nus-cs2103-ay2425s2.github.io/website/se-book-adapted/projectDuke/
    // with minor modifications

    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    void setDone(boolean done) {
        isDone = done;
    }

    public void markAsDone() {
        setDone(true);
        System.out.println("\t " + "I've marked this task as done: ");
        System.out.println("\t\t [X] " + this.getDescription());
    }

    public void markAsUndone() {
        setDone(false);
        System.out.println("\t " + "I've marked this task as incomplete: ");
        System.out.println("\t\t [ ] " + this.getDescription());
    }

    public String getDescription() {
        return description;
    }

    //@@author
}
