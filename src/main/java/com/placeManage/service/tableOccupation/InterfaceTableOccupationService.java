package com.placeManage.service.tableOccupation;


import com.placeManage.model.OccupiedTable;

import java.util.List;
import java.util.UUID;

public interface InterfaceTableOccupationService {
    OccupiedTable addTable(OccupiedTable table);
    List<OccupiedTable> getAll();
    OccupiedTable getById(UUID id);
    void deleteById(UUID id);
}
