package thanhnv.model;

import thanhnv.exception.InvalidCoordinateException;
import thanhnv.exception.NullCanvasException;

/**
 * CanvasImp
 * {@inheritDoc Canvas}
 */
public class Canvas {
    private final char HORIZONTAL_EDGE_CHARACTER = '-';
    private final char VERTICAL_EDGE_CHARACTER = '|';
    private final char DEFAULT_CHARACTER_VALUE = '\u0000';

    private int width;
    private int height;
    private char[][] views;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getViews() {
        return views;
    }

    public void setViews(char[][] views) {
        this.views = views;
    }

    public Canvas() {

    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        views = new char[height][width];
    }

    /**
     * Render views arrays to console screen
     */
    public void render() {
        //render top edge of canvas
        for (int i = 0; i <= views[0].length + 2; i++) {
            System.out.print(HORIZONTAL_EDGE_CHARACTER);
        }
        System.out.println();


        for (int i = 0; i < views.length; i++) {
            //render vertical edge of cavas
            System.out.print(VERTICAL_EDGE_CHARACTER);

            //render content of canvas
            for (int j = 0; j < views[0].length; j++) {
                //fill array if it's blank
                char pixel = views[i][j] != DEFAULT_CHARACTER_VALUE ? views[i][j] : ' ';
                System.out.print(pixel);
            }

            //render vertical edge of cavas
            System.out.println(VERTICAL_EDGE_CHARACTER);
        }

        //render bottom edge of canvas
        for (int i = 0; i <= views[0].length + 2; i++) {
            System.out.print(HORIZONTAL_EDGE_CHARACTER);
        }
        System.out.println();
    }

    /**
     * Add line to views array and render to console view
     * @exception InvalidCoordinateException
     * @exception NullCanvasException
     * @param line
     */

    public void addLine(Line line) {
        //check is isInside the canvas from and to coordinate of line
        if (!isInside(line.getFrom()) || !isInside(line.getTo())) {
            throw new InvalidCoordinateException("Coordinate is outside of cavas");
        }
        //save line to array
//        draw(line.getFrom().getX(), line.getFrom().getY(), line.getTo().getX(), line.getTo().getY(), line.getCharacter());
        render();
    }

    /**
     * Add rectangle to views array and render to console view
     * @exception InvalidCoordinateException
     * @exception NullCanvasException
     * @param rec
     */

//    public void addRectangle(Rectangle rec) {
//        //check is isInside the canvas from and to coordinate of rectangle
//        if (!isInside(rec.getFrom())||!isInside(rec.getTo())) {
//            throw new InvalidCoordinateException("Coordinate is outside of canvas");
//        }
//        //draw top edge
//        draw(rec.getFrom().getX(), rec.getFrom().getY(), rec.getTo().getX(), rec.getFrom().getY(), rec.getCharacter());
//        //draw left edge
//        draw(rec.getFrom().getX(), rec.getFrom().getY(), rec.getFrom().getX(), rec.getTo().getY(), rec.getCharacter());
//        //draw bottom edge
//        draw(rec.getFrom().getX(), rec.getTo().getY(), rec.getTo().getX(), rec.getTo().getY(), rec.getCharacter());
//        //draw right edge
//        draw(rec.getTo().getX(), rec.getFrom().getY(), rec.getTo().getX(), rec.getTo().getY(), rec.getCharacter());
//        render();
//    }

    /**
     * Fill Bucket to views array and render to console view
     * @exception InvalidCoordinateException
     * @exception NullCanvasException
     * @param bucketFill
     */

    public void fillBucket(BucketFill bucketFill) {
        //check isInside the canvas coordinate of buckFill
        if (!isInside(bucketFill.getCoordinate())) {
            throw new InvalidCoordinateException("Coordinate is outside of cavas");
        }
        //check null views Array
        if (views == null) {
            throw new NullCanvasException();
        }
        //fill bucket
        fill(bucketFill.getCoordinate().getX() - 1,
                bucketFill.getCoordinate().getY() - 1, bucketFill.getCharacter());
        render();
    }

    /**
     * Create new Canvas and render to console view
     * @param width
     * @param height
     */



    /**
     * recursion method for fill bucket
     * @param x
     * @param y
     * @param fill
     */
    private void fill(int x, int y, char fill) {
        //check is not out of bound array
        if (x >= 0 && y >= 0 && y < views.length && x < views[0].length) {
            //check is Blank this pixel blank
            if (views[y][x] == DEFAULT_CHARACTER_VALUE) {
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


    /**
     * Check coordinate is inside the views array
     * @param coordinate
     * @return isInside
     */
    public boolean isInside(Coordinate coordinate) {
        return (coordinate.getX() > 0 && coordinate.getX() <= width) && (coordinate.getY() > 0 && coordinate.getY() <= height);
    }

}
