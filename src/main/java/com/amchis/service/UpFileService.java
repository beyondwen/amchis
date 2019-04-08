package com.amchis.service;

import com.amchis.bean.UpFile;
import com.amchis.bean.base.BaseApiService;
import com.amchis.bean.base.BaseResponse;
import com.amchis.common.*;
import com.amchis.mapper.UpFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * The type Up file service.
 */
@Service
public class UpFileService extends BaseApiService<UpFile> {


    @Autowired
    private UpFileMapper upFileMapper;


    // 图片上传
    public BaseResponse<UpFile> uploadImg(@RequestParam("file") MultipartFile file) {
        UpFile upFile = new UpFile();
        if (!file.isEmpty()) {
            //获得服务器根路径
            String rootPath = ConfigTool.getString("upload_project_img_path");
            //创建的文件夹名称
            String path = "/";
            File dir = new File(rootPath + path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // 写文件到服务器
            try {
                String fileName = file.getOriginalFilename();
                // 写入服务器路径
                String fileId = UUIDUtils.getUUID();
                String serverFileUrlName = UUIDUtils.getUUID();
                String serverPath = dir.getAbsolutePath() + "/" + serverFileUrlName + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
                File serverFile = new File(serverPath);
                file.transferTo(serverFile);
                Long longsize = file.getSize();
                int size = longsize.intValue();
                upFile.setSize(PrintSizeUtil.getPrintSize(size));
                upFile.setUrl("/image/downloadimg?imgUrl=" + serverFileUrlName + "." + fileName.substring(fileName.lastIndexOf(".") + 1));
                upFile.setValid(1);
                upFile.setType(1);
                //upFile.setCreateUser(UserUtils.getCurrentUser().getUsername());
                //upFile.setCreateUserId(UserUtils.getCurrentUser().getId() + "");
                upFile.setCreateTime(DateUtils.getTime());
                upFile.setName(fileName);
                upFile.setId(fileId);
                upFileMapper.insert(upFile);
                return setResultSuccess(upFile);
            } catch (Exception e) {
                return setResultError("上传失败");
            }
        }
        return setResultError("文件为空");
    }


}
