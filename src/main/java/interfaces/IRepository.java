package interfaces;

import java.util.List;

public interface IRepository <E>{

    List<E> getAll();
    E getById(Integer id);
    void create(E element);
    void delete(Integer id);
    void update(E element);

}
