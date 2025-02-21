package tyler.command;

import tyler.storage.Storage;
import tyler.task.list.TaskList;
import tyler.ui.Ui;

public class MarkCommand extends Command {
    private final String[] tokens;

    public MarkCommand(String[] tokens) {
        super();
        this.tokens = tokens;
    }

    /**
     * @param tasks The list of tasks which has a task needing to be marked.
     * @param ui The UI object for any required printing.
     * @return The list with the respective task marked off.
     */
    @Override
    public TaskList execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.get(Integer.parseInt(tokens[1]) - 1).markAsDone();
        return tasks;
    }
}
