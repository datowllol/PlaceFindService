package com.placeManage.service.placeFree;


import com.placeManage.dto.FreeTable;
import com.placeManage.dto.Saloon;
import com.placeManage.model.Visitors;
import com.placeManage.repository.VisitorsRepository;
import com.placeManage.service.placeFind.PlaceFindService;
import com.placeManage.service.tableOccupation.TableOccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class PlaceFreeService implements InterfacePlaceFreeService {
    @Autowired
    private VisitorsRepository visitorsRepository;
    @Autowired
    private PlaceFindService placeFindService;
    @Autowired
    private TableOccupationService tableOccupationService;



    public Visitors visitorsLeavePub(UUID id) {


        FreeTable table = new FreeTable();
        table.setSaloonId(tableOccupationService(placeFindService.getById(id).getOccupiedTableId()).getSaloonId());
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<FreeTable> freeTableDto = new HttpEntity<>(table);
        FreeTable Response;
        Response = restTemplate.postForObject("https://localhost:8084/saloon", freeTableDto, FreeTable.class);
        tableOccupationService.deleteById(placeFindService.getById(id).getOccupiedTable().getOccupiedTableId());
        return placeFindService.getById(id);
    }
}
