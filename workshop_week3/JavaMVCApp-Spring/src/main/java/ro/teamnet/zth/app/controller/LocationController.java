package ro.teamnet.zth.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.teamnet.zth.app.domain.Location;
import ro.teamnet.zth.app.service.LocationServiceImpl;

import java.util.List;

/**
 * Created by Taranu on 07/05/15.
 */
@Controller
@RequestMapping(value = "/locations")
public
@ResponseBody
class LocationController {

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Location> getAllLocations() {
        return new LocationServiceImpl().findAllLlocations();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{locationId}")
    public
    @ResponseBody
    Location getOneLocation(@PathVariable(value = "locationId") String id) {
        return new LocationServiceImpl().findOneLocation(Integer.parseInt(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{locationId}")
    public
    @ResponseBody
    String deleteLocation(@PathVariable(value = "locationId") String id) {
        new LocationServiceImpl().deleteLocation(Integer.parseInt(id));
        return "Locatia a fost stearsa";
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    Location saveLocation(@RequestBody Location location) {
        return new LocationServiceImpl().addLocation(location);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public
    @ResponseBody
    Location updateLocation(@RequestBody Location location) {
        return new LocationServiceImpl().updateLocation(location);
    }

}