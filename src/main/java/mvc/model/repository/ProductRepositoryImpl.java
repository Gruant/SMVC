package mvc.model.repository;

import mvc.model.entity.Product;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository{

    private final List<Product> products = new LinkedList<>();

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id){
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void save(Product product){
        products.add(product);
    }
}
