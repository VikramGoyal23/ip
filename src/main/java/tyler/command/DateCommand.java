package tyler.command;

import java.time.LocalDate;

import tyler.storage.Storage;
import tyler.task.Deadline;
import tyler.task.Event;
import tyler.task.Task;
import tyler.task.list.TaskList;
import tyler.ui.Ui;

import java.time.LocalDate;

/**
 * Represents a command to print the tasks occurring on a specific date.
 */
public class DateCommand extends Command {
    private final String[] tokens;

    public DateCommand(String[] tokens) {
        super();
        this.tokens = tokens;
    }

    /**
     * Shows the tasks which happen on the specified date.
     *
     * @param tasks The list of tasks to check for matching dates.
     * @param ui The UI object for any required printing.
     * @param storage The storage for I/O involving storing the tasks on the disk (unused).
     * @return The unmodified list.
     */
    @Override
    public TaskList execute(TaskList tasks, Ui ui, Storage storage) {
        LocalDate date = LocalDate.parse(tokens[1]);
        int i = 1;
        for (Task t : tasks) {
            if (t.getCategory().equals("D")) {
                if (((Deadline) t).getBy().toLocalDate().equals(date)) {
                    ui.showTask(i, t);
                    i++;
                }
            } else if (t.getCategory().equals("E")) {
                if (((Event) t).getFrom().toLocalDate().equals(date)
                        || ((Event) t).getTo().toLocalDate().equals(date)) {
                    ui.showTask(i, t);
                    i++;
                }
            }
        }
        return tasks;
    }
}
