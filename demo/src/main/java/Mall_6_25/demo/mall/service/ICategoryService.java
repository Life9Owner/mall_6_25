package Mall_6_25.demo.mall.service;

import Mall_6_25.demo.mall.damain.ResponseResult;
import Mall_6_25.demo.mall.damain.entity.Category;
import Mall_6_25.demo.mall.damain.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WH
 * @since 2023-06-25
 */
public interface ICategoryService extends IService<Category> {

    ResponseResult getCategoryList(Integer pageNum, Integer pageSize);

    ResponseResult getCategory(Integer id);

    ResponseResult insertCategory(Category category);

    ResponseResult delete(List<Integer> ids);

    ResponseResult updateCategory(Category category);
}
