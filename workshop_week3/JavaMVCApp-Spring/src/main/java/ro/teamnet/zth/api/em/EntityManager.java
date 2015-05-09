package ro.teamnet.zth.api.em;

import ro.teamnet.zth.app.domain.Department;
import ro.teamnet.zth.app.domain.Employee;
import ro.teamnet.zth.app.domain.Job;
import ro.teamnet.zth.app.domain.Location;

import java.util.List;
import java.util.Map;

/**
 * EntityManager interface
 */
public interface EntityManager {

    /**
     * @param entity
     * @return
     */
    <T> Object insert(T entity);

    /**
     * @param entity
     * @param <T>
     * @return
     */
    <T> T update(T entity);

    /**
     * @param entity
     */
    void delete(Object entity);

    /**
     * @param entityClass
     * @param id
     * @param <T>
     * @return
     */
    <T> T findById(Class<T> entityClass, Integer id);


    /**
     * @param entityClass
     * @param <T>
     * @return
     */
    <T> List<T> findAll(Class<T> entityClass);

    <T> List<T> findAllByforeignId(Class<T> entityClass1, Class<?> entityClass2, Integer id);

    /**
     * @param params
     * @return
     */
    <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params);


}
