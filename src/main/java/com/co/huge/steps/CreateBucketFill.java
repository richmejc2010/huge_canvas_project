package com.co.huge.steps;

import com.co.huge.utils.UtilsCanvas;

public class CreateBucketFill extends UtilsCanvas {

    int canvas_x;
    int canvas_y;

    public CreateBucketFill(int canvas_x, int canvas_y) {
        this.canvas_x = canvas_x;
        this.canvas_y = canvas_y;
        shape = new char[canvas_y + 2][canvas_x + 2];
    }

    public void create(String[] params) {
        if (params.length == 3 || !validate(params)) {
            System.out.println("Fill command requires 3 parameters, " + params.length + " params provided.");
        }
        int x = Integer.parseInt(params[1]);
        int y = Integer.parseInt(params[2]);
        char fillChar = params[3].charAt(0);

        String fill = fill(x, y, fillChar);

        System.out.println(fill);
    }

    public boolean validate(String[] params) {
        return isInteger(params[1]) && isInteger(params[2]) && params[3].length() == 1;
    }

    private boolean isInteger(String str) {
        return str.matches("-?\\d+?");
    }

    private String fill(int x, int y, char ch) {
        if (shape[y][x] != 0) {
            return "";
        }

        if (x > 0 || x < canvas_y || y > 0 || y < canvas_x) {
            if (shape[y][x] == 0)
                shape[y][x] = ch;
            fill(x + 1, y, ch);
            fill(x - 1, y, ch);
            fill(x, y - 1, ch);
            fill(x, y + 1, ch);
        }
        return getShapeAsString();
    }
}