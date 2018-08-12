package repository;

import interfaces.IBrandRepository;
import repository.model.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandRepository implements IBrandRepository {

    // Keeps brands info in memory
    List<Brand> brands = new ArrayList<Brand>();

    @Override
    public Brand getByName(String name) {
        try{
            for(int i = 0; i < brands.size(); i++){
                if(brands.get(i).getName().equalsIgnoreCase(name)){
                    return brands.get(i);
                }
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Object getById(Integer id) {
        return null;
    }

    @Override
    public void create(Object element) {
        brands.add((Brand) element);
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public void update(Object element) {
    }
}
