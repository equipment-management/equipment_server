package com.dgsw.equipment.domain.admin.presentation;

import com.dgsw.equipment.domain.admin.service.AdminService;
import com.dgsw.equipment.domain.equipment.presentation.dto.response.UserEquipmentListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Tag(name = "관리자 서버")
public class AdminController {

    private final AdminService adminService;

    @Operation(summary = "승인되지 않은 신청 리스트 조회")
    @GetMapping("")
    public UserEquipmentListResponse getUserEquipmentAllByApprove() {
        return adminService.getUserEquipmentAllByApprove();
    }

    @Operation(summary = "신청 기자재 거절")
    @DeleteMapping("/deny/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void denyUserEquipment(
            @PathVariable("id") Long userEquipmentId
    ) {
        adminService.denyUserEquipment(userEquipmentId);
    }

    @Operation(summary = "신청 기자재 승인")
    @PostMapping("/approve/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void approveUserEquipment(
            @PathVariable("id") Long userEquipmentId,
            @RequestParam("hash") String hashCode
    ) {
        adminService.approveEquipment(userEquipmentId, hashCode);
    }

    @Operation(summary = "기자재 반납")
    @DeleteMapping("/return/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void returnUserEquipment(
            @PathVariable("id") Long userEquipmentId,
            @RequestParam("hash") String hashCode
    ) {
        adminService.returnEquipment(userEquipmentId, hashCode);
    }

}
