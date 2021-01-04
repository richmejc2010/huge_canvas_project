package com.co.huge.steps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateBucketFillTest {

    CreateModifyCanvas canvas;
    int x, y;

    @Before
    public void setup(){
        x = 20;
        y = 4;
        canvas = new CreateModifyCanvas(x, y);
        canvas.createModifyCanvas(x, y);
    }

    @Test
    public void createRectangle() {
        String[] params = {"B", "10", "3", "T"};
        CreateBucketFill bucketFill = new CreateBucketFill(x, y);
        bucketFill.shape = canvas.shape;
        bucketFill.create(params);
        Assert.assertEquals(bucketFill.canvas_x, 20);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void createOutOfRangeBucketFill(){
        String[] params = {"B", "-1", "2", "T"};
        CreateBucketFill bucketFill = new CreateBucketFill(x, y);
        bucketFill.shape = new char[x][y];
        bucketFill.create(params);
    }
}