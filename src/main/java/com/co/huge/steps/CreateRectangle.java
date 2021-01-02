package com.co.huge.steps;

import com.co.huge.utils.UtilsCanvas;

public class CreateRectangle extends UtilsCanvas {
    int x1;
    int y1;
    int x2;
    int y2;
    int canvas_x;
    int canvas_y;

    public CreateRectangle(String[] params, int canvas_x, int canvas_y) {
        if (params.length < 4) {
            System.out.println("Draw line command expects 4 params");
        } else {
            int x1 = Integer.parseInt(params[1]);
            int y1 = Integer.parseInt(params[2]);
            int x2 = Integer.parseInt(params[3]);
            int y2 = Integer.parseInt(params[4]);
            shape = new char[canvas_y + 2][canvas_x + 2];

            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.canvas_x = canvas_x;
            this.canvas_y = canvas_x;
        }
    }

    public String getRectangle(String []params) {
        int x1 = Integer.parseInt(params[1]);
        int y1 = Integer.parseInt(params[2]);
        int x2 = Integer.parseInt(params[3]);
        int y2 = Integer.parseInt(params[4]);
        draw(x1, y1, x2, y1, 'x');
        draw(x1, y1, x1, y2, 'x');
        draw(x2, y1, x2, y2, 'x');
        draw(x1, y2, x2, y2, 'x');
        return getShapeAsString();
    }

    public boolean validate(String[] params, int canvas_x, int canvas_y) {
        int x1 = Integer.parseInt(params[1]);
        int y1 = Integer.parseInt(params[2]);
        int x2 = Integer.parseInt(params[3]);
        int y2 = Integer.parseInt(params[4]);
        if (x1 >= 1 && y1 >= 1 && x2 >= 1 && y2 >= 1 && x1 < canvas_x
                && y1 < canvas_y && x2 < canvas_x && y2 < canvas_y && x1 <= x2
                && y1 <= y2) {
            return true;
        }else {
            System.out.println("Points are beyond the canvas borders or incorrect co-ordinates");
            return false;
        }
    }
}