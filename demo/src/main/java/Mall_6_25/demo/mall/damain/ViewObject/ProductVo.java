package Mall_6_25.demo.mall.damain.ViewObject;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductVo {

        private Integer id;

        /**
         * 商品编码，不可重复
         */
        private String code;

        /**
         * 商品标题
         */
        private String title;

        /**
         * 商品分类id
         */
        private Integer categoryId;

        private String  categoryName;


        /**
         * 商品图片
         */
        private String img;

        /**
         * 商品价格
         */
        private BigDecimal price;

        /**
         * 商品库存
         */
        private Integer stocks;

        /**
         * 商品描述
         */
        private String description;
}
