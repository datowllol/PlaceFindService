package com.placeManage.service.tableOccupation;

import com.placeManage.model.OccupiedTable;
import com.placeManage.repository.OccupiedTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TableOccupationService implements InterfaceTableOccupationService {
    @Autowired
    OccupiedTableRepository tableRepository;

    public OccupiedTable addTable(OccupiedTable table) {
        OccupiedTable savedTable = tableRepository.save(table);
        return savedTable;
    }

    public List<OccupiedTable> getAll() {
        return tableRepository.findAll();
    }

    public OccupiedTable getById(UUID id) {
        return tableRepository.getOne(id);
    }

    public void deleteById(UUID id) {
        tableRepository.deleteById(id);
    }
}
