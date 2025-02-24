package tyler.command;

import tyler.storage.Storage;
import tyler.task.list.TaskList;
import tyler.ui.Ui;

/**
 * Represents a command to mark an element at the specified index as undone.
 */
public class UnmarkCommand extends Command {
    private final String[] tokens;

    public UnmarkCommand(String[] tokens) {
        super();
        this.tokens = tokens;
    }

    /**
     * Marks the task at the specified index as undone.
     *
     * @param tasks The list of tasks which has a task needing to be unmarked.
     * @param ui The UI object for any required printing.
     * @param storage The storage for I/O involving storing the tasks on the disk (unused).
     * @return The list with the respective task unmarked.
     */
    @Override
    public TaskList execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.get(Integer.parseInt(tokens[1]) - 1).markAsUndone();
        return tasks;
    }
}
