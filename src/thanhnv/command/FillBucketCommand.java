package thanhnv.command;

import thanhnv.drawer.FillBucketAction;
import thanhnv.exception.InvalidCommandException;
import thanhnv.model.BucketFill;
import thanhnv.model.Canvas;
import thanhnv.model.Coordinate;
import thanhnv.validator.CommandValidator;

public class FillBucketCommand implements Command {

    private Canvas canvas;

    public FillBucketCommand(Canvas canvas) {

        this.canvas = canvas;
    }

    @Override
    public void validate(String command) {
        CommandValidator validator = new CommandValidator();
        if(!validator.validateBucketFillCommand(command)) {
            throw new InvalidCommandException("Do you mean B x y c command?");
        }
    }

    @Override
    public FillBucketAction exec(String command) {
        validate(command);
        String[] commands = command.split("\\s");

        //create 2 coordinate from command info C x1 y1 x2 y2
        Coordinate coordinate = new Coordinate(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
        char fillChar = commands[3].charAt(0);

        //create line and add to canvas
        BucketFill bucketFill = new BucketFill(coordinate, fillChar);
        FillBucketAction fillBucketAction = new FillBucketAction(canvas);
        fillBucketAction.setBucketFill(bucketFill);
        return fillBucketAction;
    }
}
