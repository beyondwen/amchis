package com.amchis.mapper;

import com.amchis.bean.UpFile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UpFileMapper {
    int deleteByPrimaryKey(String fileId);

    int insert(UpFile record);

    int insertSelective(UpFile record);

    UpFile selectByPrimaryKey(String fileId);
   /**
    * 根据sheetId得到文件信息 
    * @param fileSheetId
    * @return
    */
    UpFile selectBySheetId(String fileSheetId);
    
    int updateByPrimaryKeySelective(UpFile record);

    int updateByPrimaryKey(UpFile record);
    
    List<UpFile> selectFileBySheetId(Map<String, Object> conditionMap);


    List<UpFile> selectFileBySheetIdNotPage(Map<String, Object> conditionMap);

    UpFile selectByPrimaryKeyNotSheetId(String fileid);
    
    UpFile selectFileNameIsExist(Map<String, Object> conditionMap);

    UpFile getFileBySheetId(String id);
    
    UpFile getFileBySheetIdAndType(Map<String, Object> conditionMap);

    int deleteByFileSheetId(String fileSheetId);
}