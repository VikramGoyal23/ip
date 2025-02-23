package tyler.command;

import tyler.storage.Storage;
import tyler.task.Task;
import tyler.task.list.TaskList;
import tyler.ui.Ui;

/**
 * Represents a command to delete an element at the specified index.
 */
public class DeleteCommand extends Command {
    private final String[] tokens;

    public DeleteCommand(String[] tokens) {
        super();
        this.tokens = tokens;
    }

    /**
     * Removes the task at the specified index. Returns the list with the task deleted.
     *
     * @param tasks The list of tasks which has an object needing to be deleted.
     * @param ui The UI object for any required printing.
     * @param storage The storage for I/O involving storing the tasks on the disk (unused).
     * @return The list with the task now deleted.
     */
    @Override
    public TaskList execute(TaskList tasks, Ui ui, Storage storage) {
        Task deletedTask = tasks.remove(Integer.parseInt(tokens[1]) - 1);
        ui.showDeletedTask(deletedTask);
        ui.showTasksLength(tasks.size());
        return tasks;
    }
}
