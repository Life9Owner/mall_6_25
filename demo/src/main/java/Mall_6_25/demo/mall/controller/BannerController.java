package Mall_6_25.demo.mall.controller;

import Mall_6_25.demo.mall.damain.ResponseResult;
import Mall_6_25.demo.mall.damain.entity.Banner;
import Mall_6_25.demo.mall.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 邹嘉豪
 * @since 2023-11-18
 */
@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    IBannerService bannerService;
    @GetMapping("/list")
    public ResponseResult
    getBannerList(@RequestParam(defaultValue = "1") Integer pageNum,
                  @RequestParam(defaultValue = "5") Integer pageSize)
    {
        return bannerService.getBannerList(pageNum,pageSize);
    }
    @GetMapping("/admin/{id}")
    public ResponseResult
    getBannerList(@PathVariable Integer id)
    {
        return bannerService.getBanner(id);
    }
    @PostMapping("/admin/insert")
    public ResponseResult
    insertBanner(@RequestBody Banner banner)
    {
        return bannerService.insertBanner(banner);
    }
    @PostMapping("/admin/update")
    public ResponseResult
    updateBanner(@RequestBody Banner banner)
    {
        return bannerService.updateBanner(banner);
    }
    @PostMapping("/admin/delete")
    public ResponseResult
    deleteBanner(@RequestBody List<Integer> ids)
    {
        return bannerService.delete(ids);
    }
}

