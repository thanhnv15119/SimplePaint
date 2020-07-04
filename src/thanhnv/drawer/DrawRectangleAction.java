package thanhnv.drawer;

import thanhnv.constant.Message;
import thanhnv.exception.InvalidCoordinateException;
import thanhnv.exception.NullCanvasException;
import thanhnv.model.Canvas;
import thanhnv.model.Rectangle;

public class DrawRectangleAction extends DrawerAction{

    private Rectangle rectangle;

    public DrawRectangleAction(Canvas canvas) {
        super(canvas);

    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void render() {
        if (canvas == null) {
            throw new NullCanvasException();
        }
        //check is isInside the canvas from and to coordinate of line
        if (!canvas.isInside(rectangle.getFrom()) || !canvas.isInside(rectangle.getTo())) {
            throw new InvalidCoordinateException(Message.COORDINATE_OUT_SIDE_CANVAS_ERROR_MESSAGE);
        }
        drawRectangle(rectangle);
        canvas.render();
    }

    /**
     * Draw Rectangle in Canvas
     * @param rec Rectangle
     */
    public void drawRectangle(Rectangle rec) {
        if (canvas.getViews() == null) {
            throw new NullCanvasException();
        }
        //check is isInside the canvas from and to coordinate of rectangle
        if (!canvas.isInside(rec.getFrom())||!canvas.isInside(rec.getTo())) {
            throw new InvalidCoordinateException(Message.COORDINATE_OUT_SIDE_CANVAS_ERROR_MESSAGE);
        }
        DrawLineAction drawLineAction = new DrawLineAction(canvas);
        //draw top edge
        drawLineAction.drawLine(rec.getFrom().getX(), rec.getFrom().getY(), rec.getTo().getX(), rec.getFrom().getY(), rec.getCharacter());
        //draw left edge
        drawLineAction.drawLine(rec.getFrom().getX(), rec.getFrom().getY(), rec.getFrom().getX(), rec.getTo().getY(), rec.getCharacter());
        //draw bottom edge
        drawLineAction.drawLine(rec.getFrom().getX(), rec.getTo().getY(), rec.getTo().getX(), rec.getTo().getY(), rec.getCharacter());
        //draw right edge
        drawLineAction.drawLine(rec.getTo().getX(), rec.getFrom().getY(), rec.getTo().getX(), rec.getTo().getY(), rec.getCharacter());
        canvas.render();
    }

}
