package Mall_6_25.demo.mall.controller;
import Mall_6_25.demo.mall.damain.ResponseResult;
import Mall_6_25.demo.mall.damain.ViewObject.UserVo;
import Mall_6_25.demo.mall.damain.entity.User;
import Mall_6_25.demo.mall.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjh
 * @since 2023-11-20
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @PostMapping("/login")
    public ResponseResult login(String phone, String password, String VerifyCode, HttpSession session)
    {
        if(phone.isEmpty()||password.isEmpty()){
            return ResponseResult.failResult("手机号或密码没有输入");
        }


        if(VerifyCode.isEmpty()){
            return ResponseResult.failResult("验证码不能为空");
        }

        if(!phone.matches("^\\d{11}$")){
            return ResponseResult.failResult("手机号格式错误错误");
        }

        String captchaCode=session.getAttribute("verifyCode").toString();
        if(!VerifyCode.toLowerCase().equals(captchaCode)){
            return ResponseResult.failResult("验证码错误");
        }

        User user=userService.login(phone,password);
        if(user!=null)
        {
            session.setAttribute("userId",user.getId());
            UserVo userVo =new UserVo();
            BeanUtils.copyProperties(user,userVo);
            return ResponseResult.okResult(userVo);
        }
        else {
            return ResponseResult.failResult("登录失败");
        }

    }
    @PostMapping("/register")
    public ResponseResult register(String phone,String password,String Ack_password,String verifyCode,HttpSession session)
    {
        if(phone.isEmpty()||password.isEmpty()){
            return ResponseResult.failResult("手机号或密码没有输入");
        }


        if(verifyCode.isEmpty()){
            return ResponseResult.failResult("验证码不能为空");
        }

        if(!phone.matches("\\d{11}$")){
            return ResponseResult.failResult("手机号格式错误错误");
        }
        if(!password.equals(Ack_password))
        {
            return ResponseResult.failResult("两次输入的密码不一样");
        }
        String captcha=session.getAttribute("verifyCode").toString();
        if(!captcha.toLowerCase().equals(captcha)){
            return ResponseResult.failResult("验证码错误");
        }

        //judge if the phone is registered
        if(userService.UserExist(phone))
        {
            return ResponseResult.failResult("当前手机号已被注册");
        }
        int res=userService.Register(phone,password);
        if(res==1)
        return ResponseResult.okResult();
        else return ResponseResult.failResult("注册失败");
    }
    @GetMapping("logout")
     public ResponseResult logout(HttpSession session)
    {
        session.removeAttribute("userId");
        return ResponseResult.okResult();
    }
    @GetMapping("isLogin")
    public ResponseResult IsLogin(HttpSession session)
    {
        Object userId=session.getAttribute("userId");
        if(userId==null)
            return ResponseResult.failResult("未登录");
        else {
            return this.getUser(Integer.valueOf(userId.toString()));
        }

    }
    @GetMapping("admin/list")
    public ResponseResult getUserList(@RequestParam(defaultValue="1") Integer pageNum,
                                      @RequestParam(defaultValue="10") Integer pageSize)
    {
        return userService.GetUserList(pageNum,pageSize);
    }
    //
    @GetMapping("{id}")
    public ResponseResult getUser(@PathVariable("id") Integer id)
    {
        return userService.getUser(id);
    }
    @PostMapping("/admin/update")
    public ResponseResult updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }
    @PostMapping("admin/delete")
    public ResponseResult deleteUser(@RequestBody List<Integer> ids)
    {
        return userService.deleteUser(ids);
    }
}
