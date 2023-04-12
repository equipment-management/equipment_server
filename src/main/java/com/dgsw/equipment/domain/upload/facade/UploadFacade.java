package com.dgsw.equipment.domain.upload.facade;

import com.dgsw.equipment.domain.equipment.domain.Equipment;
import com.dgsw.equipment.domain.upload.domain.Image;
import com.dgsw.equipment.domain.upload.domain.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UploadFacade {

    private final ImageRepository imageRepository;

    @Transactional(readOnly = true)
    public List<Image> findAllByEquipment(Equipment equipment) {
        return imageRepository.findAllByEquipment(equipment);
    }

}
