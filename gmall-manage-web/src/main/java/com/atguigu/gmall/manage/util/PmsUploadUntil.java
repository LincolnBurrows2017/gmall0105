package com.atguigu.gmall.manage.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class PmsUploadUntil {
    public static String uploadImage(MultipartFile multipartFile) {




        String imgUrl="http://192.168.216.128";

        String s = PmsUploadUntil.class.getResource("/tracker.conf").getPath();
        try {
            ClientGlobal.init(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StorageClient storageClient = new StorageClient(trackerServer,null);

        try {
            byte[] bytes = multipartFile.getBytes();//获得上传的二进制对象
            //获得文件后缀名
            String originalFilename = multipartFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf('.')+1);

            String[] uploadInfos = storageClient.upload_file(bytes, extName, null);
            //String url="http://192.168.216.128";

            for (String uploadInfo : uploadInfos) {
                imgUrl+="/"+uploadInfo;
                //System.out.println(uploadInfo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return imgUrl;
    }
}
