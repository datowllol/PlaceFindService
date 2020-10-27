package com.placeManage.api;

import com.placeManage.model.Visitors;
import com.placeManage.service.placeFind.PlaceFindService;
import com.placeManage.service.placeFree.PlaceFreeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/visitors")
@AllArgsConstructor
@NoArgsConstructor
public class PlaceManageController {

    @Autowired
    PlaceFreeService placeFreeService;

    @Autowired
    PlaceFindService placeFindService;

    @PostMapping()
    public Visitors addVisitors(@RequestBody Visitors visitors) {
        return placeFindService.addVisitors(visitors);
    }

    @GetMapping()
    public List<Visitors> getAll() {
        return placeFindService.getAll();
    }

    @GetMapping("/{visitorId}")
    public Visitors getById(@PathVariable(value = "visitorId") UUID id) {
        return placeFindService.getById(id);
    }


    @DeleteMapping("/{visitorId}")
    public Visitors visitorsLeavePub(@PathVariable(value = "visitorId") UUID id) {
       return placeFreeService.visitorsLeavePub(id);
    }
}
