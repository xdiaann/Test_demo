package 缓存击穿;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.*;

/**
 * @Description:
 * @Author MR.Z
 * @Date 2019/11/1 1:22
 */
public class bloomTest {
    public static void main(String[] args) {
        final int num = 100000;
        //初始化一个存储string数据的bloom过滤器，初始化大小10w
        BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), num, 0.001);//0.001千分之一 误判率
        Set<String> sets = new HashSet<>(num);
        List<String> lists = new ArrayList<String>(num);
        //向3个容器初始化10w随机唯一字符串
        for (int i = 0; i < num; i++) {
            String uuid = UUID.randomUUID().toString();
            bf.put(uuid);
            sets.add(uuid);
            lists.add(uuid);
        }
        int wrong = 0;
        int right = 0;
        for (int i = 0; i < 10000; i++) {
            String test = i % 100 == 0 ? lists.get(i / 100) : UUID.randomUUID().toString();
            if (bf.mightContain(test)) {
                if (sets.contains(test)) {
                    right++;
                } else {
                    wrong++;
                }
            }
        }
        System.out.println("=============right================" + right);
        System.out.println("=============wrong================" + wrong);
    }


}
