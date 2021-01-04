package com.co.huge.steps;

import org.junit.Assert;
import org.junit.Test;

public class CreateModifyCanvasTest {

    @Test
    public void createCanvas() {
        CreateModifyCanvas canvas = new CreateModifyCanvas(20, 4);
        Assert.assertEquals(canvas.width, 20);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void createOutOfRangeCanvas(){
        CreateModifyCanvas canvas = new CreateModifyCanvas(-20, 4);
        canvas.createModifyCanvas(-20, 4);
    }
}