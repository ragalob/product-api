package interfaces;

import repository.model.Product;

import java.util.List;

public interface IProductRepository extends IRepository{

    // This method looks for the passed string in the product name and also the brand name
    List<Product> findProductByNameOrBrand(String text);
}
