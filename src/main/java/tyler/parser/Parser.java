package tyler.parser;

import tyler.command.AddCommand;
import tyler.command.Command;
import tyler.command.DateCommand;
import tyler.command.DeleteCommand;
import tyler.command.EndCommand;
import tyler.command.ListCommand;
import tyler.command.MarkCommand;
import tyler.command.UnmarkCommand;

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
