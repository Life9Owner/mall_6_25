package Mall_6_25.demo.mall.controller;

import Mall_6_25.demo.mall.damain.ResponseResult;
import Mall_6_25.demo.mall.damain.entity.Cart;
import Mall_6_25.demo.mall.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjh
 * @since 2023-11-16
 */
@Controller
@RequestMapping("/cart")
public class CartController {
//    @Autowired
//    ICartService cartService;
//    @GetMapping("/list")
//    public ResponseResult
//    getCartList(@RequestParam(required = false) String name,@RequestParam(required = false) Integer categoryId,
//                @RequestParam(defaultValue = "1") Integer pageNum,
//                  @RequestParam(defaultValue = "5") Integer pageSize)
//    {
//        return cartService.getCartList(name,categoryId,pageNum,pageSize);
//    }
//    @GetMapping("/admin/{id}")
//    public ResponseResult
//    getCartList(@PathVariable Integer id)
//    {
//        return cartService.getCart(id);
//    }
//    @PostMapping("/admin/insert")
//    public ResponseResult
//    insertCart(@RequestBody Cart cart)
//    {
//        return cartService.insertCart(cart);
//    }
//    @PostMapping("/admin/update")
//    public ResponseResult
//    updateCart(@RequestBody Cart cart)
//    {
//        return cartService.updateCart(cart);
//    }
//    @PostMapping("/admin/delete")
//    public ResponseResult
//    deleteCart(@RequestBody List<Integer> ids)
//    {
//        return cartService.delete(ids);
//    }
}
