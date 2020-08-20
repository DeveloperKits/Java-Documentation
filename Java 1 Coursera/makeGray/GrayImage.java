
/**
 * Write a description of GrayImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class GrayImage {
    public ImageResource ConvertGrayImage(ImageResource ir){
        ImageResource outImage = new ImageResource(ir.getWidth(), ir.getHeight());
        
        for(Pixel P : outImage.pixels()){
            Pixel image = ir.getPixel(P.getX(), P.getY());
            int average = (image.getRed() + image.getGreen() + image.getBlue())/3;
            P.setRed(average);
            P.setGreen(average);
            P.setBlue(average);
        }
        return outImage;
    }
    public void Call_Method(){
        ImageResource ir = new ImageResource();
        ImageResource gray = ConvertGrayImage(ir);
        gray.draw();
    }
}
