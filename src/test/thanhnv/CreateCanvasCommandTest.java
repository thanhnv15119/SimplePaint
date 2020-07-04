package test.thanhnv;

import org.junit.Test;
import thanhnv.command.CreateCanvasCommand;
import thanhnv.exception.InvalidCommandException;


public class CreateCanvasCommandTest {

    @Test(expected = InvalidCommandException.class)
    public void givenNegativeNumber_CreateCanvasExec() {
        String command = "C -20 4";
        CreateCanvasCommand createCanvasCommand = new CreateCanvasCommand();
        createCanvasCommand.exec(command);
    }

    @Test(expected = InvalidCommandException.class)
    public void givenErrorSyntax_CreateCanvasExec() {
        String command = "C20 4";
        CreateCanvasCommand createCanvasCommand = new CreateCanvasCommand();
        createCanvasCommand.exec(command);
    }
}