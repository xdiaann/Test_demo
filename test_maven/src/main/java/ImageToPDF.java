import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author MR.Z
 * @描述:
 * @date 2019/12/3 16:18
 */
public class ImageToPDF {
    private static String FILEPATH = "D:\\Download\\";

    /**
     *
     * @param fileName
     *            生成pdf文件
     * @param imagesPath
     *            需要转换的图片路径的数组
     */
    public static void imagesToPdf(String fileName, String[] imagesPath) {
        try {
            fileName = FILEPATH + fileName + ".pdf";
            File file = new File(fileName);
            // 第一步：创建一个document对象。
            Document document = new Document();
            document.setMargins(0, 0, 0, 0);
            // 第二步：
            // 创建一个PdfWriter实例，
            PdfWriter.getInstance(document, new FileOutputStream(file));
            // 第三步：打开文档。
            document.open();
            // 第四步：在文档中增加图片。
//            File files = new File(imagesPath);
//            String[] images = files.list();
//            int len = imagesPath.length;
            for (int i = 0; i < imagesPath.length; i++) {
                if (imagesPath[i].toLowerCase().endsWith(".bmp")
                        || imagesPath[i].toLowerCase().endsWith(".jpg")
                        || imagesPath[i].toLowerCase().endsWith(".jpeg")
                        || imagesPath[i].toLowerCase().endsWith(".gif")
                        || imagesPath[i].toLowerCase().endsWith(".png")) {
                    String temp =  imagesPath[i];
                    Image img = Image.getInstance(temp);
                    img.setAlignment(Image.ALIGN_CENTER);
                    // 根据图片大小设置页面，一定要先设置页面，再newPage（），否则无效
                    document.setPageSize(new Rectangle(img.getWidth(), img.getHeight()));
                    document.newPage();
                    document.add(img);
                }
//            for (int i = 0; i < len; i++)
//            {
//                if (images[i].toLowerCase().endsWith(".bmp")
//                        || images[i].toLowerCase().endsWith(".jpg")
//                        || images[i].toLowerCase().endsWith(".jpeg")
//                        || images[i].toLowerCase().endsWith(".gif")
//                        || images[i].toLowerCase().endsWith(".png")) {
//                    String temp = imagesPath + "\\" + images[i];
//                    Image img = Image.getInstance(temp);
//                    img.setAlignment(Image.ALIGN_CENTER);
//                    // 根据图片大小设置页面，一定要先设置页面，再newPage（），否则无效
//                    document.setPageSize(new Rectangle(img.getWidth(), img.getHeight()));
//                    document.newPage();
//                    document.add(img);
//                }
//            }
                // 第五步：关闭文档。
//                document.close();
            }
            document.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String name = "20001543";
        String[] imagesPath = {"C:\\Users\\25016\\Desktop\\ceshi\\测试11123qw.png","C:\\Users\\25016\\Desktop\\ceshi\\微信图片_20191111102415.png"};
        imagesToPdf(name, imagesPath);
    }
}
