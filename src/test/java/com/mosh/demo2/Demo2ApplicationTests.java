package com.mosh.demo2;

import com.huaweicloud.sdk.core.auth.BasicCredentials;
import com.huaweicloud.sdk.core.auth.ICredential;
import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.image.v2.ImageClient;
import com.huaweicloud.sdk.image.v2.model.ImageTaggingReq;
import com.huaweicloud.sdk.image.v2.model.RunImageTaggingRequest;
import com.huaweicloud.sdk.image.v2.model.RunImageTaggingResponse;
import com.huaweicloud.sdk.image.v2.region.ImageRegion;
import com.mosh.demo2.entity.User;
import com.mosh.demo2.service.UserService;
import com.obs.services.ObsClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.Base64;

@SpringBootTest
class Demo2ApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        User user = userService.queryById(1);
        System.out.println(user);
    }
    
    @Test
    void transferBase64() throws IOException {
        File file = new File("D:/WorkSpace/IdeaProjects/demo2/src/main/resources/static/1.jpg");
        FileInputStream in = null;

        try {
            in = new FileInputStream(file);
            byte[] bytes = new byte[in.available()];
            int len = in.read(bytes);
            byte[] base64Str = Base64.getEncoder().encode(bytes);
            System.out.println(new String(base64Str));
        } catch (IOException e) {
            e.printStackTrace();
            if (in != null) {
                in.close();
            }
        }
    }

    @Test
    void upload(){
        String endPoint = "https://obs.cn-north-1.myhuaweicloud.com";
        String ak = "PGCFS3TGOBBOVRCRPRND";
        String sk = "G1T1oDlVTSpasTeDYyLLtmHgEnRVchbKSRtkKWXL";
        // 创建ObsClient实例
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);

        obsClient.putObject("my-demo4", "1.jpg", new File("D:/WorkSpace/IdeaProjects/demo2/src/main/resources/static/1.jpg")); // localfile为待上传的本地文件路径，需要指定到具体的文件名
    }

    @Test
    void saveBucket() throws IOException {
        User user = userService.queryById(1);
        System.out.println(user);

    }

    @Test
    void image() throws IOException {
        String ak = "PGCFS3TGOBBOVRCRPRND";
        String sk = "G1T1oDlVTSpasTeDYyLLtmHgEnRVchbKSRtkKWXL";

        ICredential auth = new BasicCredentials()
                .withAk(ak)
                .withSk(sk);

        ImageClient client = ImageClient.newBuilder()
                .withCredential(auth)
                .withRegion(ImageRegion.valueOf("cn-north-4"))
                .build();

        RunImageTaggingRequest request = new RunImageTaggingRequest();

        ImageTaggingReq req = new ImageTaggingReq();

        File file = new File("C:/Users/22057/Downloads/1.jpg");

        FileInputStream fileIn = new FileInputStream(file);

        byte[] bytes = new byte[fileIn.available()];

        int read = fileIn.read(bytes);

        byte[] encode = Base64.getEncoder().encode(bytes);

        String strBase64 = new String(encode);

        req.setImage(strBase64);
        req.setLanguage("zh");
        req.setLimit(50);
        req.setThreshold((float)60);

        request.setBody(req);

        try {
            RunImageTaggingResponse response = client.runImageTagging(request);
            System.out.println(response.toString());
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (RequestTimeoutException e) {
            e.printStackTrace();
        } catch (ServiceResponseException e) {
            e.printStackTrace();
            System.out.println(e.getHttpStatusCode());
            System.out.println(e.getErrorCode());
            System.out.println(e.getErrorMsg());
        }
    }

}
