package Mall_6_25.demo.mall.service.impl;

import Mall_6_25.demo.mall.damain.ResponseResult;
import Mall_6_25.demo.mall.damain.ViewObject.CategoryVo;
import Mall_6_25.demo.mall.damain.entity.Category;
import Mall_6_25.demo.mall.damain.entity.Category;
import Mall_6_25.demo.mall.dao.CategoryMapper;
import Mall_6_25.demo.mall.dao.CategoryMapper;
import Mall_6_25.demo.mall.service.ICategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public ResponseResult getCategoryList(Integer pageNum, Integer pageSize) {
        Page<Category> categoryPage =new Page<>(pageNum,pageSize);
        List<Category> categorys = categoryMapper.selectPage(categoryPage, null).getRecords();
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categorys, CategoryVo.class);
        return ResponseResult.okResult(categoryVos);
    }

    @Override
    public ResponseResult getCategory(Integer id) {
        Category category = categoryMapper.selectById(id);
        if(category!=null)
        {
            CategoryVo categoryVo = BeanCopyUtils.copyBean(category, CategoryVo.class);
            return ResponseResult.okResult(categoryVo);
        }
        else {
            return ResponseResult.failResult("Can't find the id");
        }
    }

    @Override
    public ResponseResult insertCategory(Category category) {
        int res=categoryMapper.insert(category);
        if(res==1)
        {
            return ResponseResult.okResult("succeed to insert.");
        }
        else{
            return ResponseResult.okResult("fail to insert!");
        }
    }

    @Override
    public ResponseResult updateCategory(Category category) {
        int update = categoryMapper.updateById(category);
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
        int delete = categoryMapper.deleteBatchIds(ids);
        if(delete==ids.size())
        {
            return ResponseResult.okResult("succeed to delete.");
        }
        else{
            return ResponseResult.okResult("fail to delete!");
        }
    }
}
