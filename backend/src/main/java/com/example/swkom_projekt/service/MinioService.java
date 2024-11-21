package com.example.swkom_projekt.service;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;

@Service
public class MinioService {
    @Autowired
    private MinioClient minioClient;

    public void uploadFile(String bucketName, String objectName, String filePath) throws Exception {
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .stream(new FileInputStream(filePath), new File(filePath).length(), -1)
                        .build()
        );
        System.out.println("File uploaded to MinIO: " + objectName);
    }

    public void ensureBucketExists(String bucketName) throws Exception {
        boolean isBucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!isBucketExists) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            System.out.println("Bucket created: " + bucketName);
        }
    }
}

