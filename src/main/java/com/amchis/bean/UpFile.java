package com.amchis.bean;


import com.amchis.bean.base.BaseDomain;
import lombok.Data;

/**
 * 上传文件记录表
 *
 * @author wh
 */
@Data
public class UpFile extends BaseDomain {

    //文件类型(根据常量定义来：1头像，2项目附件,3供应商,4甲方,5分包，6公司logo,7图片,16项目施工报量,17项目施工报量文件附件)
    private int type;
    /**
     * 文件名
     */
    private String name;
    /**
     * 文件大小
     */
    private int size;
    /**
     * URL
     */
    private String url;


}