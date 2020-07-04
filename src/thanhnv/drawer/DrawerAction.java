package thanhnv.drawer;

import thanhnv.model.Canvas;

public abstract class DrawerAction {
    protected Canvas canvas;

    public DrawerAction(Canvas canvas) {
        this.canvas = canvas;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public void render() {}

}
