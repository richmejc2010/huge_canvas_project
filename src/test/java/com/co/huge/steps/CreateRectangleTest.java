package com.co.huge.steps;

import org.junit.Assert;
import org.junit.Test;
public class CreateRectangleTest {

    @Test
    public void createRectangle() {
        String[] params = {"R", "16", "1" , "19", "3"};
        CreateRectangle rectangle1 = new CreateRectangle(params, 20, 4);
        CreateRectangle rectangle2 = new CreateRectangle(params, 20, 4);
        Assert.assertEquals(rectangle1.getRectangle(params), rectangle2.getRectangle(params));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void createOutOfRangeRectangle() {
        String[] params = {"R", "22", "2" , "6", "2"};
        CreateRectangle rectangle1 = new CreateRectangle(params, 20, 4);
        CreateRectangle rectangle2 = new CreateRectangle(params, 20, 4);
        Assert.assertEquals(rectangle1.getRectangle(params), rectangle2.getRectangle(params));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void createOutOfRangeRectangle2() {
        String[] params = {"R", "-16", "2" , "6", "2"};
        CreateRectangle rectangle1 = new CreateRectangle(params, 20, 4);
        CreateRectangle rectangle2 = new CreateRectangle(params, 20, 4);
        Assert.assertEquals(rectangle1.getRectangle(params), rectangle2.getRectangle(params));
    }
}