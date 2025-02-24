package tyler.main;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import tyler.command.Command;
import tyler.parser.Parser;
import tyler.storage.Storage;
import tyler.task.Deadline;
import tyler.task.Event;
import tyler.task.Task;
import tyler.task.list.TaskList;
import tyler.ui.Ui;

public class Tyler {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Tyler(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (IOException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showGreeting();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showSeparator();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (NumberFormatException e) {
                System.out.println("\t !!Please enter a number as the argument!!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("\t !!Please provide the correct number of arguments!!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\t !!There aren't this many tasks in the list!!");
            } catch (DateTimeParseException e) {
                System.out.println("\t !!Please enter the date in YYYY-MM-DD format!!");
            } finally {
                ui.showSeparator();
            }
        }
        List<String> formattedTasks = getFormattedTasks(tasks);
        try {
            storage.save(formattedTasks);
        } catch (IOException e) {
            System.out.println("\t !!Unable to save tasks!!");
        }
    }

    public static void main(String[] args) {
        new Tyler("data/tyler.txt").run();
    }

    private static List<String> getFormattedTasks(ArrayList<Task> tasks) {
        List<String> formattedTasks = new ArrayList<>();
        for (Task t: tasks) {
            int completed = t.getStatusIcon().equals("X") ? 1 : 0;
            String formattedTask = t.getCategory() + "|" + completed + "|" + t.getDescription();
            if (t.getCategory().equals("D")) {
                Deadline d = (Deadline) t;
                formattedTask = formattedTask + "|" + d.getBy();
            } else if (t.getCategory().equals("E")) {
                Event e = (Event) t;
                formattedTask = formattedTask + "|" + e.getFrom() + "|" + e.getTo();
            }
            formattedTasks.add(formattedTask);
        }
        return formattedTasks;
    }
}
