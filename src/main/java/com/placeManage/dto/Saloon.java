package com.placeManage.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;

import java.util.UUID;

@Data
@AllArgsConstructor
public final class Saloon {
    private UUID tableId;

    private int placeNum;

    private String uniqueName;

    private UUID occupiedTableId;

    private UUID freeTableId;

    public Saloon() {
        tableId = UUID.randomUUID();
    }

    public Saloon(String uniqueName, int placeNum) {
        tableId = UUID.randomUUID();
        this.placeNum=placeNum;
        this.uniqueName=uniqueName;
    }
}
