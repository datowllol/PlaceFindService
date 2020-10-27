package com.placeManage.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
public final class FreeTable {

    private UUID freeTableId;
    private UUID saloonId;

    public FreeTable(){
        freeTableId = UUID.randomUUID();
    }
}