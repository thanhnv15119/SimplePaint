package thanhnv.command;

import thanhnv.constant.Message;
import thanhnv.drawer.DrawCanvasAction;
import thanhnv.drawer.DrawerAction;
import thanhnv.exception.InvalidCommandException;
import thanhnv.exception.InvalidCoordinateException;
import thanhnv.exception.NullCanvasException;
import thanhnv.model.Canvas;

import java.util.Scanner;

/**
 * CommandProcesser
 */
public class CommandProcesser {

    private Canvas canvas;

    public CommandProcesser() {
    }

    /**
     * main process for application
     */
    public void process() {
        Scanner sc = new Scanner(System.in);
        String command;
        do {
            try {
                System.out.print("enter command: ");
                //get command string
                command = sc.nextLine();
                //check command string not blank
                if (command.length() != 0) {
                    //exec function base on first letter of command string
                    switch (command.charAt(0)) {
                        //create new canvas
                        case 'C':
                            CreateCanvasCommand createCanvasCommand = new CreateCanvasCommand();
                            DrawCanvasAction drawCanvasAction = createCanvasCommand.exec(command);
                            canvas = drawCanvasAction.getCanvas();
                            canvas.render();
                            break;
                        case 'L':
                            //add new Line
                            DrawLineCommand drawLineCommand = new DrawLineCommand(canvas);
                            DrawerAction drawLineAction = drawLineCommand.exec(command);
                            drawLineAction.render();
                            break;
                        case 'R':
                            //add new Rectangle
                            DrawRectangleCommand drawRectangleCommand = new DrawRectangleCommand(canvas);
                            DrawerAction drawRectangleAction = drawRectangleCommand.exec(command);
                            drawRectangleAction.render();
                            break;
                        case 'B':
                            //fill Bucket
                            FillBucketCommand fillBucketCommand = new FillBucketCommand(canvas);
                            DrawerAction fillBucketAction = fillBucketCommand.exec(command);
                            fillBucketAction.render();
                            break;
                        case 'Q':
                            System.exit(0);
                            break;
                        default:
                            System.out.println(Message.RECOMMEND_SYNTAX);
                    }
                }
            } catch (InvalidCommandException | InvalidCoordinateException e) {
                System.out.println(Message.ERROR_SYNTAX_MESSAGE + e.getMessage());
            } catch (NullCanvasException e) {
                System.out.println(Message.NULL_CANVAS_EXCEPTION_MESSAGE);
            }
        } while (true);
    }
}
