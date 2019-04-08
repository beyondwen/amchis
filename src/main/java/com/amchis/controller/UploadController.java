package com.amchis.controller;

import com.amchis.bean.UpFile;
import com.amchis.bean.base.BaseApiService;
import com.amchis.bean.base.BaseResponse;
import com.amchis.common.ConfigTool;
import com.amchis.service.UpFileService;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

@RestController
@RequestMapping("/image")
public class UploadController extends BaseApiService<UpFile> {


    @Resource
    private UpFileService upFileService;


    // 文件上传和保存
    @PostMapping(value = "/upload")
    public BaseResponse<UpFile> uploadFileHandler(@RequestParam("file") MultipartFile file) {
        BaseResponse<UpFile> upFileBaseResponse = upFileService.uploadImg(file);
        return upFileBaseResponse;
    }

    //下载(展示项目页面上的图片)
    @RequestMapping("/downloadimg")
    public ResponseEntity<byte[]> downloadImg(String imgUrl) {
        try {
            HttpHeaders headers = new HttpHeaders();
            File file = new File(ConfigTool.getString("upload_project_img_path") + imgUrl);
            //headers.setAccept();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", imgUrl);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
