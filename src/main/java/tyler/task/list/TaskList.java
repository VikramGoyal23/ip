package tyler.task.list;

import java.util.ArrayList;

import tyler.task.Task;

public class TaskList extends ArrayList<Task> {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.addAll(new ArrayList<>());
    }

    public TaskList(TaskList tasks) {
        this.addAll(tasks);
    }

    /**
     * Adds task to array passed in as argument at specified index.
     * Returns the index of the next position to add a task.
     *
     * @param task Task to be added.
     *
     * @throws IllegalArgumentException If task description is blank.
     */
    public void addToList(Task task) throws IllegalArgumentException {
        if (task.getDescription().isBlank()) {
            throw new IllegalArgumentException("\t !!Please add a description for the task!!");
        }
        this.add(task);
        System.out.println("\t I've added: \n\t\t" + task);
        System.out.println("\t There's now " + this.size() + " task(s) in the list.");
    }
}
