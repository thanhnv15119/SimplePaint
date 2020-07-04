package test.thanhnv;

import org.junit.Test;
import thanhnv.command.DrawRectangleCommand;
import thanhnv.command.FillBucketCommand;
import thanhnv.exception.InvalidCommandException;
import thanhnv.exception.NullCanvasException;
import thanhnv.model.Canvas;

public class FillBucketCommandTest {

    @Test(expected = NullCanvasException.class)
    public void givenNullCanvas_FillBucketExec() {
        Canvas canvas = null;
        String command = "B 1 1 c";
        FillBucketCommand fillBucketCommand = new FillBucketCommand(canvas);
        fillBucketCommand.exec(command).render();
    }

    @Test(expected = InvalidCommandException.class)
    public void givenErrorCommand_FillBucketExec() {
        Canvas canvas = new Canvas(3,4);
        String command = "B 1 1c";
        FillBucketCommand fillBucketCommand = new FillBucketCommand(canvas);
        fillBucketCommand.exec(command).render();
    }

    @Test(expected = InvalidCommandException.class)
    public void givenNegativeCoordinate_FillBucketExec() {
        Canvas canvas = new Canvas(3,4);
        String command = "B 1 -1 c";
        FillBucketCommand fillBucketCommand = new FillBucketCommand(canvas);
        fillBucketCommand.exec(command).render();
    }

    @Test(expected = InvalidCommandException.class)
    public void givenNotEnougnParam_FillBucketCommandExec() {
        Canvas canvas = new Canvas(3,4);
        String command = "B 1 1";
        FillBucketCommand fillBucketCommand = new FillBucketCommand(canvas);
        fillBucketCommand.exec(command).render();
    }
}