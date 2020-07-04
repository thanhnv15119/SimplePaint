package thanhnv.drawer;

import thanhnv.constant.AppConstant;
import thanhnv.constant.Message;
import thanhnv.exception.InvalidCoordinateException;
import thanhnv.exception.NullCanvasException;
import thanhnv.model.BucketFill;
import thanhnv.model.Canvas;

public class FillBucketAction extends DrawerAction{

    private BucketFill bucketFill;

    public BucketFill getBucketFill() {
        return bucketFill;
    }

    public void setBucketFill(BucketFill bucketFill) {
        this.bucketFill = bucketFill;
    }

    public FillBucketAction(Canvas canvas) {
        super(canvas);

    }

    @Override
    public void render() {
        //check null canvas
        if (canvas == null) {
            throw new NullCanvasException();
        }
        if (!canvas.isInside(bucketFill.getCoordinate())) {
            throw new InvalidCoordinateException(Message.COORDINATE_OUT_SIDE_CANVAS_ERROR_MESSAGE);
        }
        //fill bucket
        fill(bucketFill.getCoordinate().getX() - 1,
                bucketFill.getCoordinate().getY() - 1, bucketFill.getCharacter());
        canvas.render();
    }

    /**
     * recursion method for fill bucket
     * @param x
     * @param y
     * @param fill
     */
    private void fill(int x, int y, char fill) {
        char[][]views = canvas.getViews();
        //check is not out of bound array
        if (x >= 0 && y >= 0 && y < views.length && x < views[0].length) {
            //check is Blank this pixel blank
            if (views[y][x] == AppConstant.DEFAULT_CHARACTER_VALUE) {
                //fill blank with fill character
                views[y][x] = fill;
                //recursion fill for the right pixel of x,y pixel
                fill(x + 1, y, fill);
                //recursion fill for the left pixel of x,y pixel
                fill(x - 1, y, fill);
                //recursion fill for the bottom pixel of x,y pixel
                fill(x, y + 1, fill);
                //recursion fill for the top pixel of x,y pixel
                fill(x, y - 1, fill);
            }
        }
    }

}
