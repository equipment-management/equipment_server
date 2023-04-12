package com.dgsw.equipment.domain.upload.presentation;

import com.dgsw.equipment.domain.upload.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/upload")
@RequiredArgsConstructor
public class UploadController {

    private final UploadService uploadService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Long uploadImage(
            @RequestParam("image") MultipartFile file
    ) {
        return uploadService.uploadImage(file);
    }

    @GetMapping("/{equipment-id}")
    public List<String> getImageUrlByEquipment(
            @PathVariable("equipment-id") Long equipmentId
    ) {
        return uploadService.getImageUrlByEquipment(equipmentId);
    }

}
