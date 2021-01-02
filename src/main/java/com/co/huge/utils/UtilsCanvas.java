package com.co.huge.utils;

import java.util.Arrays;

public class UtilsCanvas {

    public char[][] shape;

    protected void draw(int x1, int y1, int x2, int y2, char drawChar) {
        for(int i=y1; i<=y2; i++) {
            for (int j = x1; j <= x2; j++) {
                shape[i][j] = drawChar;
            }
        }
    }

    public String getShapeAsString() {
        StringBuilder results = new StringBuilder();

        for (int i = 0; i < shape.length; ++i) {
            for (int j = 0; j < shape[i].length; j++) {
                results.append((shape[i][j]) == 0 ? " " : shape[i][j]);
            }
            results.append(System.getProperty("line.separator"));
        }
        System.out.print(results.toString());
        return results.toString();
    }

    public char[][] getShape() {
        return shape;
    }

    public void setShape(char[][] shape) {
        this.shape = shape;
    }
}
