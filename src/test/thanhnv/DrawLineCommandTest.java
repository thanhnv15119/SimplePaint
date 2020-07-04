package test.thanhnv;

import org.junit.Test;
import thanhnv.command.DrawLineCommand;
import thanhnv.exception.InvalidCommandException;
import thanhnv.exception.NullCanvasException;
import thanhnv.model.Canvas;

import static org.junit.Assert.*;

public class DrawLineCommandTest {

    @Test(expected = NullCanvasException.class)
    public void givenNullCanvas_DrawLineExec() {
        Canvas canvas = null;
        String command = "L 6 3 6 4";
        DrawLineCommand drawLineCommand = new DrawLineCommand(canvas);
        drawLineCommand.exec(command).render();
    }

    @Test(expected = InvalidCommandException.class)
    public void givenErrorCommand_DrawLineExec() {
        Canvas canvas = new Canvas(20,20);
        String command = "R 6 3 6 4";
        DrawLineCommand drawLineCommand = new DrawLineCommand(canvas);
        drawLineCommand.exec(command).render();
    }

    @Test(expected = InvalidCommandException.class)
    public void givenNegativeCoordinate_DrawLineExec() {
        Canvas canvas = new Canvas(20,20);
        String command = "L 6 -3 -6 4";
        DrawLineCommand drawLineCommand = new DrawLineCommand(canvas);
        drawLineCommand.exec(command).render();
    }

    @Test(expected = InvalidCommandException.class)
    public void givenNotEnougnParam_DrawLineExec() {
        Canvas canvas = new Canvas(20,20);
        String command = "L 6 -3 6";
        DrawLineCommand drawLineCommand = new DrawLineCommand(canvas);
        drawLineCommand.exec(command).render();
    }
}