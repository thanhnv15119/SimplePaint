package test.thanhnv;

import org.junit.Test;
import thanhnv.command.DrawLineCommand;
import thanhnv.command.DrawRectangleCommand;
import thanhnv.exception.InvalidCommandException;
import thanhnv.exception.NullCanvasException;
import thanhnv.model.Canvas;

public class DrawRectangleCommandTest {

    @Test(expected = NullCanvasException.class)
    public void givenNullCanvas_DrawRectangleExec() {
        Canvas canvas = null;
        String command = "R 6 3 6 4";
        DrawRectangleCommand drawRectangleCommand = new DrawRectangleCommand(canvas);
        drawRectangleCommand.exec(command).render();
    }

    @Test(expected = InvalidCommandException.class)
    public void givenErrorCommand_DrawRectangleExec() {
        Canvas canvas = new Canvas(20,20);
        String command = "L 6 3 6 4";
        DrawRectangleCommand drawRectangleCommand = new DrawRectangleCommand(canvas);
        drawRectangleCommand.exec(command).render();
    }

    @Test(expected = InvalidCommandException.class)
    public void givenNegativeCoordinate_DrawRectangleExec() {
        Canvas canvas = new Canvas(20,20);
        String command = "R 1 1 -3 -3";
        DrawRectangleCommand drawRectangleCommand = new DrawRectangleCommand(canvas);
        drawRectangleCommand.exec(command).render();
    }

    @Test(expected = InvalidCommandException.class)
    public void givenNotEnougnParam_DrawRectangleExec() {
        Canvas canvas = new Canvas(20,20);
        String command = "R 6 3 6";
        DrawRectangleCommand drawRectangleCommand = new DrawRectangleCommand(canvas);
        drawRectangleCommand.exec(command).render();
    }
}