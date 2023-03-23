package com.dgsw.equipment.domain.equipment.presentation;

import com.dgsw.equipment.domain.equipment.domain.enums.EquipmentType;
import com.dgsw.equipment.domain.equipment.presentation.dto.request.CreateEquipment;
import com.dgsw.equipment.domain.equipment.presentation.dto.request.EquipmentRequest;
import com.dgsw.equipment.domain.equipment.presentation.dto.response.EquipmentListResponse;
import com.dgsw.equipment.domain.equipment.presentation.dto.response.UserEquipmentListResponse;
import com.dgsw.equipment.domain.equipment.service.EquipmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipment")
@RequiredArgsConstructor
@Tag(name = "기자재 서버")
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Operation(summary = "기자재 등록")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEquipment(
            @RequestBody CreateEquipment equipment
    ) {
        equipmentService.createEquipment(equipment);
    }

    @Operation(summary = "기자재 신청")
    @PostMapping("/request/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void requestEquipment(
            @PathVariable("id") Long equipmentId,
            @RequestBody EquipmentRequest request
    ) {
        equipmentService.requestEquipment(equipmentId, request);
    }

    @Operation(summary = "기자재 반납")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void returnEquipment(
        @PathVariable("id") Long equipmentId
    ) {
        equipmentService.returnEquipment(equipmentId);
    }

    @Operation(summary = "현재 로그인한 유저의 기자재 목록 조회")
    @GetMapping("/user/list")
    public UserEquipmentListResponse getEquipmentAllByUser() {
        return equipmentService.getEquipmentAllByUser();
    }

    @Operation(summary = "카테고리로 기자재 목록 조회")
    @GetMapping("/list")
    public EquipmentListResponse getEquipmentAllByType(
            @RequestParam("type") EquipmentType type
    ) {
        return equipmentService.getEquipmentAllByType(type);
    }

}
