package com.placeManage.service.placeFind;

import com.placeManage.model.Visitors;


import java.util.List;
import java.util.UUID;

public interface InterfacePlaceFindService {
    Visitors addVisitors(Visitors visitors);

    List<Visitors> getAll();

    Visitors getById(UUID id);

    Visitors getByVisitorsNum(Integer visitorsNum);
}
