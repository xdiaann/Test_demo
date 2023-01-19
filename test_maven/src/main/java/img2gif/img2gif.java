package img2gif;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.img.gif.AnimatedGifEncoder;
import cn.hutool.core.img.gif.GifDecoder;
import cn.hutool.core.io.FileUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
//有问题  待研究
public class img2gif {
    public static void main(String[] args) {


        File file = FileUtil.file("e:/1.PNG", "e:/2.PNG", "e:/3.PNG");
        ImgUtil.convert(file, FileUtil.file("e:/test2Convert.gif"));
    }
}