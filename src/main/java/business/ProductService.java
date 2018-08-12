package business;

import repository.model.Product;
import repository.ProductRepository;

import java.util.List;

public class ProductService {

    final private ProductRepository productRepository = new ProductRepository();

    public void createProduct(Product product){
        productRepository.create(product);
    }

    public void updateProduct(Product product){
        productRepository.update(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.getAll();
    }

    public Product getProductById(Integer id){
        return (Product) productRepository.getById(id);
    }

    public List<Product> getProductByName(String text){
        return productRepository.findProductByNameOrBrand(text);
    }

    public void deleteProduct(Integer id){
        productRepository.delete(id);
    }
}
