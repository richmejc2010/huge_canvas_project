package com.co.huge.steps;

import org.junit.Assert;
import org.junit.Test;

public class CreateLineTest {

    @Test
    public void createLine() {
        String[] params = {"L", "1", "2" , "6", "2"};
        CreateLine line1 = new CreateLine(params, 20, 4);
        CreateLine line2 = new CreateLine(params, 20, 4);
        Assert.assertEquals(line1.getLine(params), line1.getLine(params));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void createOutOfRangeLine() {
        String[] params = {"L", "-11", "2" , "6", "2"};
        CreateLine line1 = new CreateLine(params, 20, 4);
        CreateLine line2 = new CreateLine(params, 20, 4);
        Assert.assertEquals(line1.getLine(params), line2.getLine(params));
    }
}