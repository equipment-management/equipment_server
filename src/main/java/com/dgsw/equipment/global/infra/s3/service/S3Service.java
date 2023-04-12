package com.dgsw.equipment.global.infra.s3.service;

import com.amazonaws.services.s3.model.*;
import com.dgsw.equipment.global.infra.s3.config.AWSConfiguration;
import com.dgsw.equipment.global.infra.s3.config.AWSProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final AWSConfiguration aws;
    private final AWSProperties awsProperties;

    public String s3UploadFile(MultipartFile file) {
        String originName = "equipment";
        String fileName = createFileName(originName);
        try {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            objectMetadata.setContentLength(file.getSize());

            aws.amazonS3Client().putObject(
                    new PutObjectRequest(awsProperties.getBucket(), fileName, file.getInputStream(), objectMetadata)
                            .withCannedAcl(CannedAccessControlList.PublicRead)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileName;
    }

    private String createFileName(String originalName) {
        return "image/" + UUID.randomUUID() + "_" + originalName;
    }

    public String getImageUrl(String fileName) {
        try (S3Object s3Object = aws.amazonS3Client().getObject(awsProperties.getBucket(), "image/" + fileName)) {
            return awsProperties.getUrl() + s3Object.getKey();
        } catch (AmazonS3Exception | IOException e) {
            return null;
        }
    }

}
