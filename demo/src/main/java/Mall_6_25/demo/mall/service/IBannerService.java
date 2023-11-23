package Mall_6_25.demo.mall.service;


import Mall_6_25.demo.mall.damain.ResponseResult;
import Mall_6_25.demo.mall.damain.entity.Banner;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WH
 * @since 2023-06-25
 */
public interface IBannerService extends IService<Banner> {


    ResponseResult getBannerList(Integer pageNum, Integer pageSize);

    ResponseResult getBanner(Integer id);

    ResponseResult insertBanner(Banner banner);

    ResponseResult updateBanner(Banner banner);

    ResponseResult delete(List<Integer> ids);
}
