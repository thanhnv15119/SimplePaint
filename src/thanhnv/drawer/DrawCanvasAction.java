package thanhnv.drawer;

import thanhnv.constant.AppConstant;
import thanhnv.model.Canvas;

public class DrawCanvasAction extends DrawerAction{

    public DrawCanvasAction(Canvas canvas) {
        super(canvas);
    }

    @Override
    public void render() {
        char[][] views = canvas.getViews();
        //render top edge of canvas
        for (int i = 0; i <= views[0].length + 2; i++) {
            System.out.print(AppConstant.HORIZONTAL_EDGE_CHARACTER);
        }
        System.out.println();


        for (int i = 0; i < views.length; i++) {
            //render vertical edge of canvas
            System.out.print(AppConstant.VERTICAL_EDGE_CHARACTER);

            //render content of canvas
            for (int j = 0; j < views[0].length; j++) {
                //fill array if it's blank
                char pixel = views[i][j] != AppConstant.DEFAULT_CHARACTER_VALUE ? views[i][j] : ' ';
                System.out.print(pixel);
            }

            //render vertical edge of canvas
            System.out.println(AppConstant.VERTICAL_EDGE_CHARACTER);
        }

        //render bottom edge of canvas
        for (int i = 0; i <= views[0].length + 2; i++) {
            System.out.print(AppConstant.HORIZONTAL_EDGE_CHARACTER);
        }
        System.out.println();
    }
}
