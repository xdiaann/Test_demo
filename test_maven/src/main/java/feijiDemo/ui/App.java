package feijiDemo.ui;

import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App {

    public static BufferedImage getImg(String path)  {

        try {
            ClassPathResource classPathResource = new ClassPathResource(path);
            BufferedImage read = ImageIO.read(classPathResource.getFile());
            return read;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
