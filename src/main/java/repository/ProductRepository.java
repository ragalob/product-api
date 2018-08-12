package repository;

import interfaces.IProductRepository;
import repository.model.Brand;
import repository.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    final private BrandRepository brandRepository = new BrandRepository();

    // Keeps products info in memory
    List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findProductByNameOrBrand(String text) {
        List<Product> foundProducts = new ArrayList<>();
        for(int i = 0; i < products.size(); i++){
            Product product = products.get(i);
            if(product.getName().toLowerCase().contains(text) ||
                    product.getBrand().getName().toLowerCase().contains(text)){
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    @Override
    public List getAll() {
        return products;
    }

    @Override
    public Object getById(Integer id) {
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getId() == id){
                return products.get(i);
            }
        }
        return null;
    }


    // Before creating product, it checks if the brand already exists. If not, creates it too.
    @Override
    public void create(Object element) {
        Product product = (Product) element;
        Brand brand = brandRepository.getByName(product.getBrand().getName());
        if(brand == null){
            Brand newBrand = new Brand(product.getBrand().getName());
            brandRepository.create(newBrand);
            product.setBrand(newBrand);
        }
        products.add(product);
    }

    @Override
    public void delete(Integer id) {
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getId() == id){
                products.remove(i);
            }
        }
    }

    @Override
    public void update(Object element) {
        Product product = (Product) element;
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getName().toLowerCase().equalsIgnoreCase(product.getName())){
                products.get(i).setBrand(product.getBrand());
                products.get(i).setCountry(product.getCountry());
                products.get(i).setDuration(product.getDuration());
                products.get(i).setName(product.getName());
                products.get(i).setPlatform(product.getPlatform());
                products.get(i).setValue(product.getValue());
            }
        }
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
