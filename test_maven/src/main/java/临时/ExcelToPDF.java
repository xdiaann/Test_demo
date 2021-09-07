package 临时;

import com.spire.doc.*;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelToPDF {
    public static void main(String[] args) {
        //加载Excel文档
//        Workbook wb = new Workbook();
//        wb.loadFromFile("test.doc");
//
//        //调用方法保存为PDF格式
//        wb.saveToFile("ToPDF.pdf",FileFormat.PDF);

        Document document = new Document();
        document.loadFromFile("test.doc");

        //保存结果文档
        document.saveToFile("toPDF.pdf", FileFormat.PDF);

        String a = "c91ef325-51ee-486e-92f2-14f135c0b627.doc";
        String s = a.substring(0, a.lastIndexOf(".")) + ".pdf";
        System.out.println(s);

    }
}