package command;

import storage.Storage;
import task.list.TaskList;
import ui.Ui;

public class EndCommand extends Command {

    public EndCommand() {
        super(true);
    }

    /**
     * @param tasks The list of tasks.
     * @param ui The UI object for any required printing.
     * @return The unmodified list.
     */
    @Override
    public TaskList execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showFarewell();
        return tasks;
    }
}
