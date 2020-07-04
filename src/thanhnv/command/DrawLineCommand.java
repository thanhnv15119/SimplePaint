package thanhnv.command;

import thanhnv.constant.AppConstant;
import thanhnv.drawer.DrawLineAction;
import thanhnv.exception.InvalidCommandException;
import thanhnv.model.Canvas;
import thanhnv.model.Coordinate;
import thanhnv.model.Line;
import thanhnv.validator.CommandValidator;

public class DrawLineCommand implements Command<DrawLineAction> {

    private Canvas canvas;

    public DrawLineCommand( Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void validate(String command) {
        CommandValidator validator = new CommandValidator();
        if (!validator.validateAddLineCommand(command)) {
            throw new InvalidCommandException("Do you mean L x1 y1 x2 y2 command?");
        }
    }

    @Override
    public DrawLineAction exec(String command) {
        validate(command);
        String[] commands = command.split("\\s");

        //create 2 coordinate from command info L x1 y1 x2 y2
        Coordinate from = new Coordinate(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
        Coordinate to = new Coordinate(Integer.parseInt(commands[3]), Integer.parseInt(commands[4]));

        //create line and add to canvas
        DrawLineAction drawLineAction = new DrawLineAction(canvas);
        Line line = new Line(from, to, AppConstant.EDGE_CHARACTER);
        drawLineAction.setLine(line);

        return drawLineAction;
    }
}
