package ro.teamnet.zth.app.controller;

import ro.teamnet.zth.app.domain.Location;
import ro.teamnet.zth.app.service.LocationServiceImpl;

import java.util.List;

/**
 * Created by Taranu on 07/05/15.
 */
public class LocationController {

    public List<Location> getAllLocations(){
        return new LocationServiceImpl().findAllLlocations();
    }
    public Location getOneLocation(String id){
        return new LocationServiceImpl().findOneLocation(Integer.parseInt(id));
    }
}