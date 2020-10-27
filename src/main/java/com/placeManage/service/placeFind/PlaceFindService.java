package com.placeManage.service.placeFind;


import com.placeManage.dto.Saloon;
import com.placeManage.model.OccupiedTable;
import com.placeManage.model.Visitors;
import com.placeManage.repository.VisitorsRepository;
import com.placeManage.service.tableOccupation.TableOccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class PlaceFindService implements InterfacePlaceFindService {
    @Autowired
    private VisitorsRepository visitorsRepository;
    @Autowired
    private TableOccupationService tableOccupationService;


    public Visitors addVisitors(Visitors visitors) {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Visitors> visitorsDTO = new HttpEntity<>(visitors);
        Saloon Response;

        OccupiedTable tempTable = new OccupiedTable();
        visitorsDTO.setOccupiedTableId(tempTable.getOccupiedTableId());
        Response = restTemplate.postForObject("https://localhost:8084/saloon", visitorsDTO, Saloon.class);
        if (response.getUniqueName()) {
            tempTable.setSaloonId(Response.getTableId());
            tempTable.setVisitorsId(visitorsSaved.getVisitorsId());
            tableOccupationService.addTable(tempTable);
            visitors.setOccupiedTableId(tempTable.getOccupiedTableId());
        }
        Visitors visitorsSaved = visitorsRepository.save(visitors);
       return visitorsSaved;
    }

    public List<Visitors> getAll() {
        return visitorsRepository.findAll();
    }

    public Visitors getById(UUID id) {
        return visitorsRepository.getOne(id);
    }

    public Visitors getByVisitorsNum(Integer visitorsNum) {
        return visitorsRepository.findByVisitorsNum(visitorsNum);
    }

}
