package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.domain.Location;

import java.util.List;

/**
 * Created by Taranu on 07/05/15.
 */
public interface LocationService {
    public List<Location> findAllLlocations();

    public Location findOneLocation(Integer id);

    public void deleteLocation(Integer id);

    public Location addLocation(Location location);

    public Location updateLocation(Location location);
}

