package Mall_6_25.demo.mall.damain.ViewObject;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
public class UserVo {

        private Integer id;
        private String phone;
        private String nickName;
}
