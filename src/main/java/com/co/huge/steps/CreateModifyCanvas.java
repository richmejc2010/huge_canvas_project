package com.co.huge.steps;

import com.co.huge.utils.UtilsCanvas;

public class CreateModifyCanvas extends UtilsCanvas {
    int width;
    int height;

    public CreateModifyCanvas(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public String createModifyCanvas(int width, int height) {
        shape = new char[height + 2][width +2]; // borders x and y (bottom, above, right, left)
        // Draw upper border
        draw(0, 0, width - 1, 0, '-');
        // Draw left border
        draw(0, 1, 0, height + 1, '|');
        // Draw right border
        draw(width - 1, 1, width - 1, height + 1, '|');
        // Draw lower border
        draw(0, height + 1, width - 1, height + 1, '-');

        return getShapeAsString();
    }

    //to test
    public static void main(String[] args) {
        CreateModifyCanvas canvas = new CreateModifyCanvas(10, 10);
    }
}
