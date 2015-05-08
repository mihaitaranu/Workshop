package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.dao.LocationDao;
import ro.teamnet.zth.app.domain.Location;

import java.util.List;

/**
 * Created by Taranu on 07/05/15.
 */
public class LocationServiceImpl implements LocationService {

    @Override
    public List<Location> findAllLlocations() {
        return new LocationDao().getAllLocations();
    }

    @Override
    public Location findOneLocation(Integer id) {
        return new LocationDao().getLocationById(id);
    }
}
