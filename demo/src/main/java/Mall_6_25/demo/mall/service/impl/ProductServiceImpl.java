package Mall_6_25.demo.mall.service.impl;


import Mall_6_25.demo.mall.damain.ResponseResult;
import Mall_6_25.demo.mall.damain.ViewObject.CategoryVo;
import Mall_6_25.demo.mall.damain.ViewObject.ProductVo;
import Mall_6_25.demo.mall.damain.entity.Product;
import Mall_6_25.demo.mall.dao.CategoryMapper;
import Mall_6_25.demo.mall.dao.ProductMapper;
import Mall_6_25.demo.mall.service.IProductService;
import Mall_6_25.demo.mall.util.BeanCopyUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.dsig.keyinfo.PGPData;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjh
 * @since 2023-11-20
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public ResponseResult getProductList(String name, Integer categoryId, Integer pageNum, Integer pageSize) {
        Page<Product> productPage=new Page<>(pageNum,pageSize);
        LambdaQueryWrapper<Product> productLambdaQueryWrapper = new LambdaQueryWrapper<>();
        productLambdaQueryWrapper.like(name!=null,Product::getTitle,name).
                eq(categoryId!=null,Product::getCategoryId,categoryId);
        List<Product> products=productMapper.selectPage(productPage,productLambdaQueryWrapper).getRecords();
        List<ProductVo> productVos=BeanCopyUtils.copyBeanList(products,ProductVo.class);
        for(ProductVo productVo: productVos)
        {
            productVo.setCategoryName(categoryMapper.selectById(productVo.getCategoryId()).getName());
        }
        return ResponseResult.okResult(productVos);
    }
    @Override
    public ResponseResult getProduct(Integer id) {
        Product product = productMapper.selectById(id);
        if(product!=null)
        {
            ProductVo productVo = BeanCopyUtils.copyBean(product, ProductVo.class);
            productVo.setCategoryName(categoryMapper.selectById(productVo.getCategoryId()).getName());
            return ResponseResult.okResult(productVo);
        }
        else {
            return ResponseResult.failResult("Can't find the id");
        }
    }

    @Override
    public ResponseResult insertProduct(Product product) {
        if(product.getCode()==null)
        {
            return ResponseResult.failResult("商品编码不能为空!");
        }
        Product prod = productMapper.selectOne
                (new LambdaQueryWrapper<Product>().eq(Product::getCode, product.getCode()));
        if(prod==null)
        {
            int res=productMapper.insert(product);
            if(res==1)
            {
                return ResponseResult.okResult("succeed to insert.");
            }
            else{
                return ResponseResult.okResult("fail to insert!");
            }
        }
        else{
            return ResponseResult.failResult(501,"商品编码已存在，新增失败!");
        }


    }

    @Override
    public ResponseResult updateProduct(Product product) {
        int update = productMapper.updateById(product);
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
        int delete = productMapper.deleteBatchIds(ids);
        if(delete==ids.size())
        {
            return ResponseResult.okResult("succeed to delete.");
        }
        else{
            return ResponseResult.okResult("fail to delete!");
        }
    }


}
