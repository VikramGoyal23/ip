package tyler.command;

import tyler.storage.Storage;
import tyler.task.Deadline;
import tyler.task.Event;
import tyler.task.Task;
import tyler.task.list.TaskList;
import tyler.ui.Ui;

import java.time.LocalDate;

public class DateCommand extends Command {
    private final String[] tokens;

    public DateCommand(String[] tokens) {
        super();
        this.tokens = tokens;
    }

    /**
     * @param tasks The list of tasks to check for matching dates.
     * @param ui The UI object for any required printing.
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
