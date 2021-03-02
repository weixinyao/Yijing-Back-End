package com.example.service;

//import com.example.dao.FeedBackMapper;
//import com.example.model.FeedBack;
import com.example.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/2/4-21:47
 */
public class FeedbackService {

}
/*
@Repository
public class FeedbackService{
    static int number=0;
    @Value("${absoluteImgPath}")
    String absoluteImgPath;
    @Value("${sonImgPath}")
    String sonImgPath;
    @Resource
    private FeedBackMapper feedBackMapper;
    public Map<String, String> uploadImg(MultipartFile[] file,Boolean update, FeedBack feedBack) {
        Map<String,String> map = new HashMap<>();
        String path="";
        for (int i = 0; i < file.length; i++) {
            if (file[i].isEmpty()) {
                map.put("code", "500");
                map.put("msg", "图片不能为空");
                System.out.println("图片不能为空");
                return map;
            }

            String originalFilename = file[i].getOriginalFilename();
            //随机生成文件名
            String fileName = RandomUtils.random() + originalFilename;
            File dest = new File(absoluteImgPath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            String feedPicture = sonImgPath + fileName;
            try {
                file[i].transferTo(dest);
                path+=feedPicture+",";
            } catch (Exception e) {
                map.put("ERROR", e.getMessage());
                return  map;
            }
        }

        try {
            feedBack.setFeedPicture(path);
            map.put("OK", "200");
            System.out.println(update);
            if(update == false) {
                feedBackMapper.insert(feedBack);
                System.out.println(feedBack.getFeedPicture());
            }else {



            }
            return map;
        }
        catch (Exception e){
            map.put("ERROR",  e.getMessage());
            return map;
        }
    }
}
*/
