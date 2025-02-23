package tyler.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import tyler.command.AddCommand;
import tyler.command.Command;
import tyler.command.EndCommand;
import tyler.command.ListCommand;
import tyler.command.MarkCommand;
import tyler.command.UnmarkCommand;
import tyler.command.DeleteCommand;
import tyler.command.DateCommand;


public class ParserTest {

    @Test
    void testParseCommandValid() {
        Command command = Parser.parse("todo read book");
        assertInstanceOf(AddCommand.class, command);

        command = Parser.parse("deadline return book /by 31/1/2025 2359");
        assertInstanceOf(AddCommand.class, command);

        command = Parser.parse("event meeting /from 24/1/2025 1400 /to 24/1/2025 1600");
        assertInstanceOf(AddCommand.class, command);

        command = Parser.parse("mark 5");
        assertInstanceOf(MarkCommand.class, command);

        command = Parser.parse("unmark 4");
        assertInstanceOf(UnmarkCommand.class, command);

        command = Parser.parse("delete 3");
        assertInstanceOf(DeleteCommand.class, command);

        command = Parser.parse("date 2024-04-05");
        assertInstanceOf(DateCommand.class, command);

        command = Parser.parse("list");
        assertInstanceOf(ListCommand.class, command);

        command = Parser.parse("bye");
        assertInstanceOf(EndCommand.class, command);

    }
}
