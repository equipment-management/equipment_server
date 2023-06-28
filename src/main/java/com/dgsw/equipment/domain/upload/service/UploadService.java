package com.dgsw.equipment.domain.upload.service;

import com.dgsw.equipment.domain.equipment.domain.Equipment;
import com.dgsw.equipment.domain.equipment.facade.EquipmentFacade;
import com.dgsw.equipment.domain.upload.domain.Image;
import com.dgsw.equipment.domain.upload.domain.repository.ImageRepository;
import com.dgsw.equipment.domain.upload.facade.UploadFacade;
import com.dgsw.equipment.global.infra.s3.exception.FailedToSaveException;
import com.dgsw.equipment.global.infra.s3.exception.ImageSizeMismatchException;
import com.dgsw.equipment.global.infra.s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UploadService {

    private final UploadFacade uploadFacade;
    private final EquipmentFacade equipmentFacade;
    private final ImageRepository imageRepository;
    private final S3Service s3Service;

    @Transactional
    public Long uploadImage(MultipartFile file) {
        String url = s3Service.s3UploadFile(file);
        Image image = new Image(url);

        return imageRepository.save(image).getImageId();
    }

    @Transactional(readOnly = true)
    public List<String> getImageUrlByEquipment(Long equipmentId) {
        Equipment equipment = equipmentFacade.findEquipmentById(equipmentId);
        List<Image> images = uploadFacade.findAllByEquipment(equipment);

        return images.stream().map(Image::getUrl).collect(Collectors.toList());
    }

}
