package thanhnv;

public class DrawUtils {

    private char[][] views;

    public void draw(int x1, int y1, int x2, int y2, char fill) {
        if (views != null) {
            if (y1 == y2) {
                for (int i = Math.min(x1, x2); i <= Math.max(x2, x1); i++) {
                    views[y1 - 1][i - 1] = fill;
                }
            }
            if (x1 == x2) {
                for (int i = Math.min(y2, y1); i <= Math.max(y2, y1); i++) {
                    views[i - 1][x1 - 1] = fill;
                }
            }
        } else {
            System.out.println("Please create Canvas before draw something!");
        }
    }

    public void drawLine(int x1, int y1, int x2, int y2, char fill) {
        draw(x1, y1, x2, y2, fill);
        render(views);
    }

    public void drawRectangle(int x1, int y1, int x2, int y2, char fill) {
        drawLine(x1, y1, x2, y1, fill);
        drawLine(x1, y1, x1, y2, fill);
        drawLine(x1, y2, x2, y2, fill);
        drawLine(x2, y1, x2, y2, fill);
        render(views);
    }

    public void drawCanvas(int w, int h) {
        views = new char[h][w];
        render(views);
    }

    public void bucketFill(int x, int y, char fill) {
        if (views != null) {
            fill(x - 1, y - 1, fill);
        } else {
            System.out.println("Create Canvas before fill something!");
        }
        render(views);
    }

    public void fill(int x, int y, char fill) {
        if (x >= 0 && y >= 0 && y < views.length && x < views[0].length) {
            if (views[y][x] == '\u0000') {
                views[y][x] = fill;
                fill(x + 1, y, fill);
                fill(x - 1, y, fill);
                fill(x, y + 1, fill);
                fill(x, y - 1, fill);
            }

        }
    }

    public void render(char[][] views) {
        for (int i = 0; i <= views[0].length + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < views.length; i++) {
            System.out.print("|");
            for (int j = 0; j < views[0].length; j++) {
                char render = views[i][j] != '\u0000' ? views[i][j] : ' ';
                System.out.print(render);
            }
            System.out.println("|");
        }
        for (int i = 0; i <= views[0].length + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
