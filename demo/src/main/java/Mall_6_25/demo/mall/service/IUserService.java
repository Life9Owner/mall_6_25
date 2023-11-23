package Mall_6_25.demo.mall.service;

import Mall_6_25.demo.mall.damain.ResponseResult;
import Mall_6_25.demo.mall.damain.entity.User;
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
public interface IUserService extends IService<User> {

    User login(String phone, String password);

    Boolean UserExist(String phone);
    int Register(String phone,String password);


    ResponseResult GetUserList(Integer pageNum, Integer pageSize);
    ResponseResult updateUser(User user);

    ResponseResult getUser(Integer id);

    ResponseResult deleteUser(List<Integer> ids);
}
