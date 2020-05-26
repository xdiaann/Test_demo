package string;

import org.junit.Test;

import java.util.Date;
import java.util.Locale;

/**
 * @author MR.Z
 * @date 2020/1/15 15:28
 */
public class StringFormat {
    //显示不同转换符实现不同数据类型到字符串的转换
    @Test
    public void test01() {
        String str = null;
        str = String.format("Hi,%s", "王力");
        System.out.println(str);//Hi,王力
        str = String.format("Hi,%s:%s.%s", "王南", "王力", "王张");
        System.out.println(str);//Hi,王南:王力.王张
        System.out.printf("字母a的大写是：%c %n", 'A');    //字母a的大写是：A
        System.out.printf("3>7的结果是：%b %n", 3 > 7);     //3>7的结果是：false
        System.out.printf("100的一半是：%d %n", 100 / 2);   //100的一半是：50
        System.out.printf("100的16进制数是：%x %n", 100);     //100的16进制数是：64
        System.out.printf("100的8进制数是：%o %n", 100); //100的8进制数是：144
        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50 * 0.85);//50元的书打8.5折扣是：42.500000 元
        System.out.printf("上面价格的16进制数是：%a %n", 50 * 0.85);     //上面价格的16进制数是：0x1.54p5
        System.out.printf("上面价格的指数表示：%e %n", 50 * 0.85);//上面价格的指数表示：4.250000e+01
        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50 * 0.85);//上面价格的指数和浮点数结果的长度较短的是：42.5000
        System.out.printf("上面的折扣是%d%% %n", 85);//上面的折扣是85%
        System.out.printf("字母A的散列码是：%h %n", 'A');//字母A的散列码是：41
    }

    //搭配转换符的标志
    @Test
    public void test02() {
        String str = null;
        //$使用  %1代表第几个
        str = String.format("格式参数$的使用：%1$d,%2$s", 99, "abc");//格式参数$的使用：99,abc
        System.out.println(str);
        //+使用
        System.out.printf("显示正负数的符号：%+d与%d%n", 99, -99);   //显示正负数的符号：+99与-99
        //补O使用 %03表示是3位数? %04结果 0007
        System.out.printf("最牛的编号是：%03d%n", 7);   //最牛的编号是：007
        //空格使用
        System.out.printf("Tab键的效果是：% 8d%n", 7);        //Tab键的效果是：       7
        //.使用 %,
        System.out.printf("整数分组的效果是：%,d%n", 9989997);        //整数分组的效果是：9,989,997
        //空格和小数点后面个数
        System.out.printf("一本书的价格是：% 50.5f元%n", 49.8);//一本书的价格是：                                          49.80000元

    }

    //日期和事件字符串格式化
    @Test
    public void test03() {
        Date date = new Date();
        //c的使用
        System.out.printf("全部日期和时间信息：%tc%n", date);//全部日期和时间信息：星期三 一月 15 15:38:36 CST 2020
        //f的使用
        System.out.printf("年-月-日格式：%tF%n", date);//年-月-日格式：2020-01-15
        //d的使用
        System.out.printf("月/日/年格式：%tD%n", date);  //月/日/年格式：01/15/20
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n", date);   //HH:MM:SS PM格式（12时制）：03:38:36 下午
        //t的使用
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n", date);  //HH:MM:SS格式（24时制）：15:38:36
        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR", date); //HH:MM格式（24时制）：15:38
    }

    //定义日期格式的转换符可以使日期通过指定的转换符生成新字符串
    @Test
    public void test04() {

        Date date = new Date();
        //b的使用，月份简称
        String str = String.format(Locale.US, "英文月份简称：%tb", date); //英文月份简称：Jan
        System.out.println(str);
        System.out.printf("本地月份简称：%tb%n", date);//本地月份简称：一月
        //B的使用，月份全称
        str = String.format(Locale.US, "英文月份全称：%tB", date); //英文月份全称：January
        System.out.println(str);
        System.out.printf("本地月份全称：%tB%n", date);//本地月份全称：一月
        //a的使用，星期简称
        str = String.format(Locale.US, "英文星期的简称：%ta", date);//英文星期的简称：Wed
        System.out.println(str);
        //A的使用，星期全称
        System.out.printf("本地星期的简称：%tA%n", date);  //本地星期的简称：星期三
        //C的使用，年前两位
        System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n", date);   //年的前两位数字（不足两位前面补0）：20
        //y的使用，年后两位
        System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n", date);    //年的后两位数字（不足两位前面补0）：20
        //j的使用，一年的天数
        System.out.printf("一年中的天数（即年的第几天）：%tj%n", date);     //一年中的天数（即年的第几天）：015
        //m的使用，月份
        System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n", date); //两位数字的月份（不足两位前面补0）：01
        //d的使用，日（二位，不够补零）
        System.out.printf("两位数字的日（不足两位前面补0）：%td%n", date);  //两位数字的日（不足两位前面补0）：15
        //e的使用，日（一位不补零）
        System.out.printf("月份的日（前面不补0）：%te", date);   //月份的日（前面不补0）：15

    }

    //和日期格式转换符相比，时间格式的转换符要更多、更精确。它可以将时间格式化成时、分、秒甚至时毫秒等单位
    @Test
    public void test05() {
        Date date = new Date();
        //H的使用
        System.out.printf("2位数字24时制的小时（不足2位前面补0）:%tH%n", date);
        //I的使用
        System.out.printf("2位数字12时制的小时（不足2位前面补0）:%tI%n", date);
        //k的使用
        System.out.printf("2位数字24时制的小时（前面不补0）:%tk%n", date);
        //l的使用
        System.out.printf("2位数字12时制的小时（前面不补0）:%tl%n", date);
        //M的使用
        System.out.printf("2位数字的分钟（不足2位前面补0）:%tM%n", date);
        //S的使用
        System.out.printf("2位数字的秒（不足2位前面补0）:%tS%n", date);
        //L的使用
        System.out.printf("3位数字的毫秒（不足3位前面补0）:%tL%n", date);
        //N的使用
        System.out.printf("9位数字的毫秒数（不足9位前面补0）:%tN%n", date);
        //p的使用
        String str = String.format(Locale.US, "小写字母的上午或下午标记(英)：%tp", date);
        System.out.println(str);
        System.out.printf("小写字母的上午或下午标记（中）：%tp%n", date);
        //z的使用
        System.out.printf("相对于GMT的RFC822时区的偏移量:%tz%n", date);
        //Z的使用
        System.out.printf("时区缩写字符串:%tZ%n", date);
        //s的使用
        System.out.printf("1970-1-1 00:00:00 到现在所经过的秒数：%ts%n", date);
        //Q的使用
        System.out.printf("1970-1-1 00:00:00 到现在所经过的毫秒数：%tQ%n", date);
    }
}
