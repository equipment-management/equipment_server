package com.dgsw.equipment.domain.upload.domain;

import com.dgsw.equipment.domain.equipment.domain.Equipment;
import com.dgsw.equipment.global.entity.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "tb_image")
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
public class Image extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    private String url;

    @ManyToOne
    @JoinColumn(name = "fk_equipment_id")
    private Equipment equipment;
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Builder
    public Image(String url) {
        this.url = url;
    }
}
