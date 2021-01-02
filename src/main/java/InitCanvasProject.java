import com.co.huge.constants.CanvasConstants;
import com.co.huge.steps.CreateBucketFill;
import com.co.huge.steps.CreateLine;
import com.co.huge.steps.CreateModifyCanvas;
import com.co.huge.steps.CreateRectangle;
import com.co.huge.utils.CanvasSingleton;
import com.co.huge.utils.UtilsCanvas;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

//avoid wild cards
import java.io.*;
import java.util.Properties;

public class InitCanvasProject {
    public static void main(String[] args) {
        final Logger log = LoggerFactory.getLogger(InitCanvasProject.class);
        try (InputStream input = InitCanvasProject.class.getClassLoader().getResourceAsStream(CanvasConstants.CONFIG_PROPERTIES)) {

            Properties configProperty = new Properties();
            configProperty.load(input);
            File file = new File("C:\\Users\\richardpaul.mejia\\z_Personal_stuff\\Huge\\code\\input.txt");
//            File file = new File(configProperty.getProperty(CanvasConstants.INPUT_FILE));

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            int canvas_x = 0, canvas_y = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] params = line.split(" ");
                String firstWord = params[0].toUpperCase();
                switch (firstWord) {
                    case "C":
                        try {
                            if (params.length == 2) {
                                System.out.println("Draw line expects 2 params");
                            } else {
                                canvas_x = Integer.parseInt(params[1]);
                                canvas_y = Integer.parseInt(params[2]);
                                CreateModifyCanvas canvas = new CreateModifyCanvas(canvas_x, canvas_y);
                                canvas.createModifyCanvas(canvas_x, canvas_y);
                                CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
                                canvasSingleton.setCanvas_x(canvas_x);
                                canvasSingleton.setCanvas_y(canvas_y);
                                canvasSingleton.setShape(canvas.shape);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Draw Canvas. params are not numbers: "+e.toString());
                        } catch (Exception e) {
                            System.out.println("Draw canvas Error: "+e.toString());
                        }
                        break;
                    case "L":
                        try {
                            if (params.length == 4) {
                                System.out.println("Draw line expects 4 params");
                            } else {
                                CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();

                                if (canvasSingleton.getCanvas_x() == -1) {
                                    System.out.println("Mandatory to create a canvas first");
                                }
                                CreateLine createLine = new CreateLine(params, canvasSingleton.getCanvas_x(), canvasSingleton.getCanvas_y());
                                if(createLine.validate(params, canvasSingleton.getCanvas_x(), canvasSingleton.getCanvas_y())){
                                    createLine.shape = canvasSingleton.getShape();
                                    createLine.getLine(params);
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Draw Line. params are not numbers: "+e.toString());
                        } catch (Exception e) {
                            System.out.println("Draw Line Error: "+e.toString());
                        }
                        break;
                    case "R":
                        try {
                            if (params.length == 4) {
                                System.out.println("Draw Rectangle expects 4 params");
                            } else {
                                CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();

                                if (canvasSingleton.getCanvas_x() == -1) {
                                    System.out.println("Mandatory to create a canvas first");
                                }
                                CreateRectangle createRectangle = new CreateRectangle(params, canvasSingleton.getCanvas_x(), canvasSingleton.getCanvas_y());
                                if(createRectangle.validate(params, canvasSingleton.getCanvas_x(), canvasSingleton.getCanvas_y())){
                                    createRectangle.shape = canvasSingleton.getShape();
                                    createRectangle.getRectangle(params);
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Draw Rectangle. params are not numbers: "+e.toString());
                        } catch (Exception e) {
                            System.out.println("Draw Rectangle Error: "+e.toString());
                        }
                        break;
                    case "B":
                        if (params.length == 3) {
                            System.out.println("Draw Bucket Fill expects 3 params");
                        } else {
                            CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();

                            if (canvasSingleton.getCanvas_x() == -1) {
                                System.out.println("Mandatory to create a canvas first");
                            }
                            CreateBucketFill createBucketFill = new CreateBucketFill(canvasSingleton.getCanvas_x(), canvasSingleton.getCanvas_y());
                            if(createBucketFill.validate(params)){
                                createBucketFill.shape = canvasSingleton.getShape();
                                createBucketFill.create(params);
                            }
                        }
                        break;
                    case "P":
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
                }
            }
        }catch(IOException io){
            log.debug(io.getMessage());
        }
    }
}
