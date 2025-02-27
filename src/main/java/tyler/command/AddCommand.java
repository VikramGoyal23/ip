package tyler.command;

import tyler.storage.Storage;
import tyler.task.Deadline;
import tyler.task.Event;
import tyler.task.Task;
import tyler.task.ToDo;
import tyler.task.list.TaskList;
import tyler.ui.Ui;

/**
 * Represents a command to add a new element to the list.
 */
public class AddCommand extends Command {
    private final String[] tokens;

    public AddCommand(String[] tokens) {
        super();
        this.tokens = tokens;
    }

    /**
     * Adds specified task to the list of tasks and returns the modified list.
     *
     * @param tasks The list of tasks to which the tasks should be added.
     * @param ui The UI object for any required printing.
     * @param storage The storage for I/O involving storing the tasks on the disk (unused).
     * @return The list with the task added.
     */
    @Override
    public TaskList execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            if (tokens[0].equalsIgnoreCase("todo")) {
                ToDo toDo = new ToDo(tokens[1]);
                assert toDo.getCategory().equals("T");
                boolean noDuplicates = true;
                for (Task t: tasks) {
                    if (toDo.equals(t)){
                        noDuplicates = false;
                        break;
                    }
                }
                if (noDuplicates) {
                    tasks.addToList(toDo, ui);
                } else {
                    ui.showMessage("\t !!This task already exists!!");
                }
            } else if (tokens[0].equalsIgnoreCase("deadline")) {
                if (!tokens[1].contains("/by") || tokens[1].split("/by ")[1].isBlank()) {
                    throw new IllegalArgumentException("\t !!Deadline must include a 'by' time!!");
                }
                Deadline deadline = new Deadline(
                        tokens[1].split(" /by")[0], tokens[1].split("/by ")[1]);
                assert deadline.getCategory().equals("D");
                boolean noDuplicates = true;
                for (Task d: tasks) {
                    if (deadline.equals(d)){
                        noDuplicates = false;
                        break;
                    }
                }
                if (noDuplicates) {
                    tasks.addToList(deadline, ui);
                } else {
                    ui.showMessage("\t !!This task already exists!!");
                }
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
                assert event.getCategory().equals("E");
                boolean noDuplicates = true;
                for (Task e: tasks) {
                    if (event.equals(e)){
                        noDuplicates = false;
                        break;
                    }
                }
                if (noDuplicates) {
                    tasks.addToList(event, ui);
                } else {
                    ui.showMessage("\t !!This task already exists!!");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            ui.showMessage("\t !!Please provide the correct number of arguments!!");
        } catch (IllegalArgumentException e) {
            ui.showMessage(e.getMessage());
        }
        return tasks;
    }
}
