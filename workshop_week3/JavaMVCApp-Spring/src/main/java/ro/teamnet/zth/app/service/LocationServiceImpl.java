package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.dao.DepartmentDao;
import ro.teamnet.zth.app.dao.LocationDao;
import ro.teamnet.zth.app.domain.Department;
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

    @Override
    public void deleteLocation(Integer id) {
        List<Department> departments= new DepartmentDao().getDepartmentsByLocationId(id);
        for(Department department:departments){
            department.setLocations(1000);
            new DepartmentDao().updateDepartment(department);
        }
        new LocationDao().deleteLocation(new LocationDao().getLocationById(id));
    }

    @Override
    public Location addLocation(Location location) {
        return new LocationDao().insertLocation(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return new LocationDao().updateLocation(location);
    }

}
