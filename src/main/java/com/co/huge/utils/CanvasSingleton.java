package com.co.huge.utils;

public final class CanvasSingleton  extends UtilsCanvas{

    private static CanvasSingleton INSTANCE;
    private int canvas_x = -1;
    private int canvas_y = -1;

    private CanvasSingleton() {
    }

    public static CanvasSingleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new CanvasSingleton();
        }

        return INSTANCE;
    }

    public int getCanvas_x() {
        return canvas_x;
    }

    public void setCanvas_x(int canvas_x) {
        this.canvas_x = canvas_x;
    }

    public int getCanvas_y() {
        return canvas_y;
    }

    public void setCanvas_y(int canvas_y) {
        this.canvas_y = canvas_y;
    }
}