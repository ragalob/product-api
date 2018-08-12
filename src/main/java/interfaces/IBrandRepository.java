package interfaces;

import repository.model.Brand;

public interface IBrandRepository extends IRepository{

    Brand getByName(String name);
}
