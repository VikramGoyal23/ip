package command;

import storage.Storage;
import task.list.TaskList;
import ui.Ui;

public abstract class Command {
    private final boolean exit;

    protected Command() {
        this.exit = false;
    }

    protected Command(boolean exit) {
        this.exit = exit;
    }

    /**
     * @param tasks The list of tasks which the command should be operated on.
     * @param ui The UI object for any required printing.
     * @return The transformed list.
     */
    public abstract TaskList execute(TaskList tasks, Ui ui, Storage storage);

    public boolean isExit() {
        return exit;
    }
}
