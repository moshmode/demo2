package com.mosh.demo2.controller;


import com.mosh.demo2.entity.UserBucket;
import com.mosh.demo2.service.UserBucketService;
import com.mosh.demo2.service.UserService;
import com.obs.services.ObsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;


/**
 * Description
 *
 * @author mosh
 * @date 2021/8/27 18:05
 */
@RestController
public class ImageController {

    String endPoint = "https://obs.cn-north-1.myhuaweicloud.com";
    String ak = "PGCFS3TGOBBOVRCRPRND";
    String sk = "G1T1oDlVTSpasTeDYyLLtmHgEnRVchbKSRtkKWXL";

    @Autowired
    UserBucketService userBucketService;

    @Autowired
    UserService userService;

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("userId") Integer userId,
                              @RequestParam("fileName") String fileName,
                              @RequestParam("saveType") String saveType,
                              @RequestPart("file") MultipartFile multipartFile) throws IOException {

        UserBucket userBucket = userBucketService.queryById(userId);

        InputStream in = multipartFile.getInputStream();

        // 创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);

        if ("0".equals(saveType)) {
            obsClient.putObject(userBucket.getPrivateBucket(), fileName, in);
        } else if ("1".equals(saveType) && userBucket.getGroupBucket() != null) {
            obsClient.putObject(userBucket.getGroupBucket(), fileName, in);
        } else {
            obsClient.putObject("public", fileName, in);
        }

        obsClient.close();

        return "hello";

    }


    @GetMapping("/str")
    public BufferedImage getString() throws IOException {
        File file = new File("C:/Users/22057/Downloads/2.jpg");

        return ImageIO.read(new FileInputStream(file));
    }


}
