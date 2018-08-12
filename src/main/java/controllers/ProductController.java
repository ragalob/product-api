package controllers;

import business.ProductService;
import repository.model.Brand;
import repository.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    final private ProductService productService = new ProductService();
    private int productIdCounter = 1;

    @RequestMapping("/product")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping("/product/{productId}")
    public Product getProduct(@PathVariable Integer productId) {
        return productService.getProductById(productId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createProduct(@RequestParam(value="name") String name,
                                @RequestParam(value="value") String value,
                                @RequestParam(value="duration") String duration,
                                @RequestParam(value="platform") String platform,
                                @RequestParam(value="country") String country,
                                @RequestParam(value="brand") String brandName) {

        try{
            final Product newProduct = new Product(productIdCounter, name, value, duration, platform,
                    country, new Brand( brandName));
            productIdCounter++;

            productService.createProduct(newProduct);
            return "{code:200, message: Product created!}";
        }catch(Exception e){
            return "{code:500, message: Internal server error}";
        }

    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updateProduct(@RequestParam(value="name") String name,
                                @RequestParam(value="value") String value,
                                @RequestParam(value="duration") String duration,
                                @RequestParam(value="platform") String platform,
                                @RequestParam(value="country") String country,
                                @RequestParam(value="brand") String brandName) {

        try{
            final Product newProduct = new Product(-1, name, value, duration, platform,
                    country, new Brand( brandName));

            productService.updateProduct(newProduct);
            return "{code:200, message: Product updated!}";
        }catch(Exception e){
            return "{code:500, message: Internal server error}";
        }

    }

    @RequestMapping("/product/search/{text}")
    public List<Product> getProductByName(@PathVariable String text) {
        return productService.getProductByName(text.toLowerCase());
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteProduct( @RequestParam(value="id") Integer id) {
        try{
            productService.deleteProduct(id);
            return "{code:200, message: Product deleted!}";
        }catch(Exception e){
            return "{code:500, message: Internal server error}";
        }
    }

}
