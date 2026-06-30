package org.local;

import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) throws Exception {
        String imagePath = "exampleimage.png";
        int width = 64;
        int height = 32;
        char[] pallette = "@%#*+=-:.".toCharArray();
        boolean copy = false;


        AsciiImageGenerator generator = new AsciiImageGenerator();
        generator.setSilent(false);
        generator.setSimple(false);
        generator.changeSize(128, 48);
        generator.setPallette(" .:-=+*#%@", copy);
        generator.setImage("C:\\YTDLP\\wtf\\frame0093.png");
        generator.setFilterType(AsciiArtGeneratorFilterTypes.FilterTypes.AVERAGE_RGB);
        generator.generate(false);
        System.out.println(generator.getArt());
    }
}
