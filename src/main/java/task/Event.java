package task;

public class Event extends Task {
    //@@author VikramGoyal23-reused
    // Reused from https://nus-cs2103-ay2425s2.github.io/website/se-book-adapted/projectDuke/
    // with minor modifications

    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getCategory() {
        return "E";
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return super.toString() + " (from: " + from + " to: " + to + ")";
    }

    //@@author
}