package thanhnv.command;

import thanhnv.constant.AppConstant;
import thanhnv.drawer.DrawRectangleAction;
import thanhnv.exception.InvalidCommandException;
import thanhnv.model.Canvas;
import thanhnv.model.Coordinate;
import thanhnv.model.Rectangle;
import thanhnv.validator.CommandValidator;

public class DrawRectangleCommand implements Command<DrawRectangleAction> {

    private Canvas canvas;

    public DrawRectangleCommand(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void validate(String command) {
        CommandValidator validator = new CommandValidator();
        if (!validator.validateAddRectangleCommand(command)) {
            throw new InvalidCommandException("Do you mean R x1 y1 x2 y2 command?");
        }
    }

    @Override
    public DrawRectangleAction exec(String command) {
        validate(command);
        String[] commands = command.split("\\s");

        //create 2 coordinate from command info C x1 y1 x2 y2
        Coordinate from = new Coordinate(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
        Coordinate to = new Coordinate(Integer.parseInt(commands[3]), Integer.parseInt(commands[4]));

        //create line and add to canvas
        Rectangle rectangle = new Rectangle(from, to, AppConstant.EDGE_CHARACTER);
        DrawRectangleAction drawRectangleAction = new DrawRectangleAction(canvas);
        drawRectangleAction.setRectangle(rectangle);
        return drawRectangleAction;
    }
}
