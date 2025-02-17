package command;

import storage.Storage;
import task.Deadline;
import task.Event;
import task.ToDo;
import task.list.TaskList;
import ui.Ui;

public class AddCommand extends Command {
    private final String[] tokens;

    public AddCommand(String[] tokens) {
        super();
        this.tokens = tokens;
    }

    /**
     * @param tasks The list of tasks to which the tasks should be added.
     * @param ui The UI object for any required printing.
     * @return The list with the task added.
     */
    @Override
    public TaskList execute(TaskList tasks, Ui ui, Storage storage) {
        if (tokens[0].equalsIgnoreCase("todo")) {
            ToDo toDo = new ToDo(tokens[1]);
            tasks.addToList(toDo);
        } else if (tokens[0].equalsIgnoreCase("deadline")) {
            if (!tokens[1].contains("/by") || tokens[1].split("/by ")[1].isBlank()) {
                throw new IllegalArgumentException("\t !!Deadline must include a 'by' time!!");
            }
            Deadline deadline = new Deadline(
                    tokens[1].split(" /by")[0], tokens[1].split("/by ")[1]);
            tasks.addToList(deadline);
        } else if (tokens[0].equalsIgnoreCase("event")) {
            if (!tokens[1].contains("/from") || !tokens[1].contains("/to")
                    || tokens[1].split("/from ")[1].split(" /to")[0].isBlank()
                    || tokens[1].split("/to ")[1].isBlank()
            ) {
                throw new IllegalArgumentException(
                        "\t !!Event must include a 'from' time and 'to' time!!");
            }
            Event event = new Event(tokens[1].split(" /from")[0],
                    tokens[1].split("/from ")[1].split(" /to")[0],
                    tokens[1].split("/to ")[1]);
            tasks.addToList(event);
        }
        return tasks;
    }
}
