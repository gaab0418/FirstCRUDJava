package DAO;

import java.util.List;

public interface IDAO<T> {
    List<T> getAll();
    T getById(int id);
    void save(T obj);
    void delete(int id);

}
