package main;

import command.Command;
import parser.Parser;
import storage.Storage;
import task.Deadline;
import task.Event;
import task.Task;
import task.list.TaskList;
import ui.Ui;

import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

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
