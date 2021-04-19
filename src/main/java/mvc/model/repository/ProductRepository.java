package mvc.model.repository;

import mvc.model.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ProductRepository {
    List<Product> getAll();
    Product getById(int id);
    void save(Product product);
}
