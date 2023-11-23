package Mall_6_25.demo.mall.service.impl;
import Mall_6_25.demo.mall.damain.ResponseResult;
import Mall_6_25.demo.mall.damain.ViewObject.UserVo;
import Mall_6_25.demo.mall.damain.entity.User;
import Mall_6_25.demo.mall.dao.UserMapper;
import Mall_6_25.demo.mall.service.IUserService;
import Mall_6_25.demo.mall.util.MD5Util;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
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
public class UserServiceImpl extends  ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User login(String phone, String password)
    {
        //encode
        String passwordMD5= MD5Util.MD5Encode(password,"UTF-8" );



//        QueryWrapper<User> wrapper=new QueryWrapper<>();
//        wrapper.eq("phone",phone).eq("password",password);
        LambdaQueryWrapper<User> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(User::getPhone,phone).eq(User::getPassword,passwordMD5);

        User user=userMapper.selectOne(wrapper);

        return user;
    }



    @Override
    public Boolean UserExist(String phone)
    {
        LambdaQueryWrapper<User> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(User::getPhone,phone);
        return userMapper.exists(wrapper);
    }
    @Override
    public int Register(String phone,String password)
    {
//        LambdaInsertWrapper<User> wrapper =new LambdaQueryWrapper<>();

//        return res;
        User user=new User();
        user.setPhone(phone);
        user.setPassword(MD5Util.MD5Encode(password,"UTF-8"));
        user.setNickName("User"+phone);

        return userMapper.insert(user);
    }
    @Override
    public ResponseResult GetUserList(Integer pageNum, Integer pageSize)
    {
        Page<User> page=new Page<>(pageNum,pageSize);
        List<User> UserList=userMapper.selectPage(page,null).getRecords();
        return ResponseResult.okResult(UserList);

    }
    @Override
    public ResponseResult updateUser(User user)
    {

        int result=userMapper.updateById(user);
        if(result==1)
        return  ResponseResult.okResult();
        else{
            return  ResponseResult.failResult();
        }
    }
    @Override
    public ResponseResult getUser(Integer id)
    {
        User user=userMapper.selectById(id);
        if(user==null)
            return ResponseResult.failResult("没找到");
        else
        {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user,userVo);
            return ResponseResult.okResult(userVo);
        }
          
    }
    @Override
    public ResponseResult deleteUser(List<Integer> ids)
    {
        int res=userMapper.deleteBatchIds(ids);
        if(res==1)
        {
            return ResponseResult.okResult();
        }
        else
        {
            return ResponseResult.failResult("删除失败");
        }
    }



}