package tyler.task;

public class ToDo extends Task {
    //@@author VikramGoyal23-reused
    // Reused from https://nus-cs2103-ay2425s2.github.io/website/se-book-adapted/projectDuke/
    // with minor modifications

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String getCategory() {
        return "T";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    //@@author
}