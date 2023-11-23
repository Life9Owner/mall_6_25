package Mall_6_25.demo.mall.service.impl;

import Mall_6_25.demo.mall.damain.ResponseResult;
import Mall_6_25.demo.mall.damain.ViewObject.BannerVo;
import Mall_6_25.demo.mall.damain.entity.Banner;
import Mall_6_25.demo.mall.dao.BannerMapper;
import Mall_6_25.demo.mall.service.IBannerService;
import Mall_6_25.demo.mall.util.BeanCopyUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WH
 * @since 2023-06-25
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Override
    public ResponseResult getBannerList(Integer pageNum, Integer pageSize) {
        Page<Banner> bannerPage =new Page<>(pageNum,pageSize);
        List<Banner> banners = bannerMapper.selectPage(bannerPage, null).getRecords();
        List<BannerVo> bannerVos = BeanCopyUtils.copyBeanList(banners, BannerVo.class);
        return ResponseResult.okResult(bannerVos);
    }

    @Override
    public ResponseResult getBanner(Integer id) {
        Banner banner = bannerMapper.selectById(id);
        if(banner!=null)
        {
            BannerVo bannerVo = BeanCopyUtils.copyBean(banner, BannerVo.class);
            return ResponseResult.okResult(bannerVo);
        }
        else {
            return ResponseResult.failResult("Can't find the id");
        }
    }

    @Override
    public ResponseResult insertBanner(Banner banner) {
        int res=bannerMapper.insert(banner);
        if(res==1)
        {
            return ResponseResult.okResult("succeed to insert.");
        }
        else{
            return ResponseResult.okResult("fail to insert!");
        }
    }

    @Override
    public ResponseResult updateBanner(Banner banner) {
        int update = bannerMapper.updateById(banner);
        if(update==1)
        {
            return ResponseResult.okResult("succeed to update.");
        }
        else{
            return ResponseResult.okResult("fail to update!");
        }
    }

    @Override
    public ResponseResult delete(List<Integer> ids) {
        int delete = bannerMapper.deleteBatchIds(ids);
        if(delete==ids.size())
        {
            return ResponseResult.okResult("succeed to delete.");
        }
        else{
            return ResponseResult.okResult("fail to delete!");
        }
    }
}
