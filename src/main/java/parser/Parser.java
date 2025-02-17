package parser;

import command.Command;
import command.DateCommand;
import command.EndCommand;
import command.ListCommand;
import command.MarkCommand;
import command.UnmarkCommand;
import command.DeleteCommand;
import command.AddCommand;

public class Parser {

    public static Command parse(String input) {
        String[] tokens = input.split(" ", 2);
        String command = tokens[0];
        return switch (command.toLowerCase()) {
            case "list" -> new ListCommand();
            case "bye" -> new EndCommand();
            case "date" -> new DateCommand(tokens);
            case "mark" -> new MarkCommand(tokens);
            case "unmark" -> new UnmarkCommand(tokens);
            case "delete" -> new DeleteCommand(tokens);
            case "todo", "deadline", "event" -> new AddCommand(tokens);
            default -> throw new IllegalArgumentException("\t !!I'm sorry, I don't know what that means!!");
        };
    }
}
