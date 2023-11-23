package Mall_6_25.demo.mall.controller;

import Mall_6_25.demo.mall.damain.ResponseResult;
import Mall_6_25.demo.mall.damain.entity.Category;
import Mall_6_25.demo.mall.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
@RestController
@RequestMapping("/category")
public class CategoryController {
        @Autowired
        ICategoryService categoryService;
        @GetMapping("/list")
        public ResponseResult
        getCategoryList(@RequestParam(defaultValue = "1") Integer pageNum,
                      @RequestParam(defaultValue = "5") Integer pageSize)
        {
            return categoryService.getCategoryList(pageNum,pageSize);
        }
        @GetMapping("/admin/{id}")
        public ResponseResult
        getCategoryList(@PathVariable Integer id)
        {
            return categoryService.getCategory(id);
        }
        @PostMapping("/admin/insert")
        public ResponseResult
        insertCategory(@RequestBody Category category)
        {
            return categoryService.insertCategory(category);
        }
        @PostMapping("/admin/update")
        public ResponseResult
        updateCategory(@RequestBody Category category)
        {
            return categoryService.updateCategory(category);
        }
        @PostMapping("/admin/delete")
        public ResponseResult
        deleteCategory(@RequestBody List<Integer> ids)
        {
            return categoryService.delete(ids);
        }
}

