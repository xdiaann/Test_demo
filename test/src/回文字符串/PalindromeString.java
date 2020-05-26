package 回文字符串;

/**
 * @author MR.Z
 * @date 2020/5/15 16:40
 */
public class PalindromeString {
    //回文串是指aba、abba、cccbccc、aaaa这种左右对称的字符串。每个字符串都可以通过向中间添加一些字符，使之变为回文字符串。
    //例如：abbc 添加2个字符可以变为 acbbca，也可以添加3个变为 abbcbba。方案1只需要添加2个字符，是所有方案中添加字符数量最少的。
    //现在，给定一个字符串，求能够使其变为回文串最少要添加几个字符？
    public static void main(String[] args) {
        isPalindrome("asdad");
        isPalindrome("abfg");
        isPalindrome("aba");

    }

    private static void isPalindrome(String a) {
        boolean b = true;  //表示是回文字符串
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            //依次看两端的字符是否相等。例如:ABCBA，第一个字符与最后一个字符相等，第二个字符与倒数第二个字符相等
            if (chars[i] != chars[chars.length - i - 1]) {
                b = false;
                break;
            }
        }
        if (b) {
            System.out.println(a + " 是回文字符串。");
        } else {
            System.out.println(a + " 不是回文字符串。");
        }
    }
}
