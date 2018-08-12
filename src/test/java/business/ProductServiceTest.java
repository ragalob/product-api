package business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringRunner;
import repository.ProductRepository;
import repository.model.Brand;
import repository.model.Product;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ProductServiceTest {

    private ProductRepository productRepository = new ProductRepository();

    @Test
    public void findProductByNameOrBrandNoProductFound() throws Exception {

        productRepository.setProducts(getMockData());

        List<Product> foundProducts = productRepository.findProductByNameOrBrand("text");
        assertThat(foundProducts.size()).isEqualTo(0);

    }

    @Test
    public void findProductByNameOrBrandOneProductFoundByName() throws Exception {

        productRepository.setProducts(getMockData());

        List<Product> foundProducts = productRepository.findProductByNameOrBrand("name1");
        assertThat(foundProducts.size()).isEqualTo(1);

    }

    @Test
    public void findProductByNameOrBrandOneProductFoundByBrand() throws Exception {

        productRepository.setProducts(getMockData());

        List<Product> foundProducts = productRepository.findProductByNameOrBrand("brand1");
        assertThat(foundProducts.size()).isEqualTo(1);

    }

    @Test
    public void findProductByNameOrBrandTwoProductsFound() throws Exception {

        productRepository.setProducts(getMockData());

        List<Product> foundProducts = productRepository.findProductByNameOrBrand("name");
        assertThat(foundProducts.size()).isEqualTo(2);

    }

    private List<Product> getMockData(){
        Product product1 = new Product(1, "name1", "value1", "1", "platform1",
                "country1", new Brand("brand1"));
        Product product2 = new Product(2, "name2", "value2", "2", "platform2",
                "country2", new Brand("brand2"));

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        return products;
    }

}
