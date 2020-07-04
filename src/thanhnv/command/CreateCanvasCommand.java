package thanhnv.command;

import thanhnv.drawer.DrawCanvasAction;
import thanhnv.exception.InvalidCommandException;
import thanhnv.model.Canvas;
import thanhnv.validator.CommandValidator;

public class CreateCanvasCommand implements Command<DrawCanvasAction> {

    @Override
    public void validate(String command) {
        CommandValidator validator = new CommandValidator();
        if (!validator.validateCreateCanvasCommand(command)) {
            throw new InvalidCommandException("Do you mean C w h command?");
        }
    }

    @Override
    public DrawCanvasAction exec(String command) {
        validate(command);
        String[] commands = command.split("\\s");
        //create newCanvas
        Canvas canvas = new Canvas(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
        return new DrawCanvasAction(canvas);
    }
}
