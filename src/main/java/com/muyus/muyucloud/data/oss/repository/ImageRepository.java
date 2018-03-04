package com.muyus.muyucloud.data.oss.repository;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Image
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/12
 */
@Repository
public class ImageRepository {
    static String bucketName = "muyus";
    @Autowired
    OSSClient ossClient;

    public String upload(String name, byte[] bytes){
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bytes);

            Calendar calendar = Calendar.getInstance();
            String path = "image/article/" + calendar.get(Calendar.YEAR) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.DATE) + "/";

            PutObjectResult result = ossClient.putObject(bucketName, path+name, byteArrayInputStream);

            return "http://image.muyus.com/" + path + name;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
