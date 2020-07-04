package thanhnv.drawer;

import thanhnv.constant.Message;
import thanhnv.exception.InvalidCoordinateException;
import thanhnv.exception.NullCanvasException;
import thanhnv.model.Canvas;
import thanhnv.model.Line;

public class DrawLineAction extends DrawerAction{

    private Line line;

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public DrawLineAction(Canvas canvas) {
        super(canvas);
    }

    @Override
    public void render() {
        //check is isInside the canvas from and to coordinate of line
        if (canvas == null) {
            throw new NullCanvasException();
        }
        if (!canvas.isInside(line.getFrom()) || !canvas.isInside(line.getTo())) {
            throw new InvalidCoordinateException(Message.COORDINATE_OUT_SIDE_CANVAS_ERROR_MESSAGE);
        }
        //save line to array
        drawLine(line);
        canvas.render();
    }

    public void drawLine(Line line) {
        drawLine(line.getFrom().getX(), line.getFrom().getY(), line.getTo().getX(), line.getTo().getY(), line.getCharacter());
    }

    /**
     * Draw line to the array with coordinate (currently not support for diagonal line)
     * @exception NullCanvasException
     * @exception InvalidCoordinateException
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param fill
     */
    public void drawLine(int x1, int y1, int x2, int y2, char fill) {
        //check null views array
        if (canvas.getViews() == null) {
            throw new NullCanvasException();
        }
        char[][] views = canvas.getViews();
        //check is diagonal line
        if (x1 != x2 && y1 != y2) {
            throw new InvalidCoordinateException(Message.NOT_SUPPORTED_DRAW_DIAGONAL_LINE_MESSAGE);
        }
        //check horizontal line
        if (y1 == y2) {
            for (int i = Math.min(x1, x2); i <= Math.max(x2, x1); i++) {
                views[y1 - 1][i - 1] = fill;
            }
        }
        //check vertical line
        if (x1 == x2) {
            for (int i = Math.min(y2, y1); i <= Math.max(y2, y1); i++) {
                views[i - 1][x1 - 1] = fill;
            }
        }
        canvas.setViews(views);
    }

}
