package 游戏.牛牛;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：luoxiang
 * @description：
 * @date ：2020/5/18 14:44
 */
@RestController
@RequestMapping("/app/game/login")
@Api(value = "欢乐牛牛", description = "欢乐牛牛")
public class NiuNiuGame {

    private Lock lock = new ReentrantLock();


    @ApiOperation("用户就位")
    @GetMapping("/loginNiuNiu")
    public ResultEntity loginNiuNiu() {
        Integer ready = NiuNiu.ready();
            lock.lock();
            List<String> poker = null;
            try {
                poker = NiuNiu.getPoker();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();

        for (String pok : poker) {
            Integer index = Integer.valueOf(pok.split(",")[1]);
            String sss = pok.split(",")[0];
            integers.add(index);
            strings.add(sss);
        }

        Integer integer = BlueGame._is_Blue(integers, 10, 1);
//        Integer show = BlueGame.show(integers);
        Niu niu = new Niu();
            niu.setList(strings);
            if (integer==0){
                niu.setNiu("没牛");
            }else {
                niu.setNiu("牛"+integer);
            }


            return new ResultEntity(200,"成功",niu);

    }
}
