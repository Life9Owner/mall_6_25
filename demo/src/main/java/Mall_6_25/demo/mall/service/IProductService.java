package Mall_6_25.demo.mall.service;


import Mall_6_25.demo.mall.damain.ResponseResult;
import Mall_6_25.demo.mall.damain.entity.Product;
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
public interface IProductService extends IService<Product> {

    ResponseResult getProductList(String name, Integer categoryId, Integer pageNum, Integer pageSize);
    ResponseResult getProduct(Integer id);

    ResponseResult insertProduct(Product banner);

    ResponseResult updateProduct(Product banner);

    ResponseResult delete(List<Integer> ids);


}
