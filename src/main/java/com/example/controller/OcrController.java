package com.example.controller;

import com.baidu.aip.ocr.AipOcr;
import com.example.utils.JsonChange;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yaoweixin
 * @date 2020/3/3-13:55
 */
@Controller
public class OcrController {
    //接口申请免费，请自行申请使用，如果学习使用可以用下
    public static final String APP_ID = "15742445";
    public static final String API_KEY = "LXrztEOzQxfef66DLIDQYpIG";
    public static final String SECRET_KEY = "gbDodnochc8jYjlAHADDgyyas9mrlmkF";
    @ResponseBody
    @PostMapping(value = "/ocr")
    public String ocr(@RequestParam(value="file") MultipartFile file) throws Exception {
        HashMap options = new HashMap();
        options.put("language_type", "CHN_ENG");
        //高精度识别一些参数在api文档可以参考
// options.put("detect_direction", "true");
// options.put("detect_language", "true");
// options.put("probability", "true");
        AipOcr client=new AipOcr(APP_ID,API_KEY,SECRET_KEY);
        byte [] bite=file.getBytes();
        System.out.println(file.getName());
        //System.out.println(file.getOriginalFilename() " " file.getResource());
        JSONObject jsonObject=client.basicGeneral(bite,options);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();

    }
}
