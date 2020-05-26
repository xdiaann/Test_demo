package 秒杀;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import 秒杀.service.StockService;

import javax.annotation.Resource;

/**
 * (Stock)表控制层
 *
 * @author makejava
 * @since 2020-05-06 17:46:53
 */
@RestController
@RequestMapping("stock")
public class StockController {
    /**
     * 服务对象
     */
    @Resource
    private StockService stockService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Stock selectOne(Object id) {
        return this.stockService.queryById(id);
    }

}
