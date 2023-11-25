package Mall_6_25.demo.mall.controller;

import Mall_6_25.demo.mall.damain.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@RequestMapping("/common")
@Controller
public class UploadController {
    // 上传文件的保存路径
    private final static String FILE_UPLOAD_PATH = "C:\\Users\\13496\\Desktop\\";

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseResult.failResult("上传失败");
        }

        // 生成文件名，保存文件
        String filename = file.getOriginalFilename();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS_");
        String newFilename = LocalDateTime.now().format(formatter) + filename;
        try {
            file.transferTo(new File(FILE_UPLOAD_PATH + newFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileUrl = FILE_UPLOAD_PATH + newFilename;
        return ResponseResult.myokResult(fileUrl);

    }
}