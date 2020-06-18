package com.xiaozhoubg;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class WeixinZhifuApplicationTests {

    @Test
    void contextLoads() throws WriterException, IOException {
        //1.需要json生成二维码啊
        //2.定义一个json格式的字符串，使用fastjson
        //3.创建一个json对象
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("wangzhan","http://120.26.177.198:4396/");
        jsonObject.put("author","wanghhh");
        jsonObject.put("wanghao","河北省秦皇岛市");
        System.out.println("json!!!"+jsonObject);

        String content = jsonObject.toString();

        System.out.println("jsontoString!!!"+content);

        //4.1二维码的尺寸宽高 px单位
        int width = 200;
        int hight = 200;

        //4.2创建一个map集合指定字符集编码
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
                    hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
        //        4.创建一个矩阵对象，用来生成矩阵数据
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,hight,hints);

        //5.生成的路径和name
        String filePath = "C:\\Users\\lenovo\\Desktop\\weixin_zhifu\\src\\main\\resources\\static\\img";
        String fileName = "QRCode.jpg";

        //6.创建一个路径对象
        Path path = FileSystems.getDefault().getPath(filePath,fileName);
        //7.将矩阵对象生成一个图片
        MatrixToImageWriter.writeToPath(bitMatrix,"jpg",path);


        System.out.println("成功生成二维码图片");
    }

}
