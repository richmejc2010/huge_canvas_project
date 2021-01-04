package com.co.huge.steps;

import com.co.huge.utils.CanvasSingleton;
import com.co.huge.utils.UtilsCanvas;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintCanvas {
    public PrintCanvas() {
        print();
    }

    private void print (){
        try {
            File outputFile = new File("C:\\Users\\richardpaul.mejia\\z_Personal_stuff\\Huge\\code\\output.txt");
    //                        File outputFile = new File(configProperty.getProperty(CanvasConstants.OUTPUT_FILE));
            if(outputFile.delete()){
                outputFile.createNewFile();
            }
            UtilsCanvas utilsCanvas = new UtilsCanvas();
            CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
            utilsCanvas.shape = canvasSingleton.getShape();
            PrintWriter writer = new PrintWriter(outputFile);
            writer.print(utilsCanvas.getShapeAsString());
            writer.close();
        } catch ( IOException io) {
            System.out.println("Error IO creating file "+io.toString());
        } catch ( Exception e) {
            System.out.println("Error creating file "+e.toString());
        }
    }
}
