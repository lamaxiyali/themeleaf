package com.example.themeleaf.service.impl;

import com.example.themeleaf.dao.FabricMapper;
import com.example.themeleaf.entity.Car;
import com.example.themeleaf.entity.Fabric;
import com.example.themeleaf.service.FabricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FabricServiceImpl implements FabricService {
    @Autowired
    FabricMapper fabricMapper;
    @Override
    public void insertall(List<Car> carList) {
        for (Fabric fabric:change(carList)
             ) {
            fabricMapper.insert(fabric);
        }
    }
    public List<Fabric> change(List<Car> carList) {
        List<Fabric> fabricList = new ArrayList<>();
        Fabric fabric = null;
        for (Car car:carList
             ) {
            fabric = new Fabric(null,car.getKey(),car.getRecord().getMake(),car.getRecord().getColour(),car.getRecord().getModel(),car.getRecord().getOwner());
            fabricList.add(fabric);
        }
        return fabricList;
    }
}
