package ro.teamnet.zth.app.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.api.annotations.MyRequestParam;
import ro.teamnet.zth.app.domain.Location;
import ro.teamnet.zth.app.service.LocationServiceImpl;

import java.util.List;

/**
 * Created by Taranu on 07/05/15.
 */
@MyController(urlPath = "/locations")
public class LocationController {

    @MyRequestMethod(methodType ="GET" , urlPath = "/all")
    public List<Location> getAllLocations(){
        return new LocationServiceImpl().findAllLlocations();
    }
    @MyRequestMethod(methodType = "GET", urlPath = "/one")
    public Location getOneLocation(@MyRequestParam(paramName = "idLocation"
    )String id){
        return new LocationServiceImpl().findOneLocation(Integer.parseInt(id));
    }
}