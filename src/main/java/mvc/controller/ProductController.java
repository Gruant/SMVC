package mvc.controller;

import mvc.model.entity.Product;
import mvc.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showAllProducts(Model uiModel){
        List<Product> products = productRepository.getAll();
        uiModel.addAttribute("products", products);
        return "products";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showById(Model uiModel, @PathVariable(value = "id") int id){
        Product product = productRepository.getById(id);
        uiModel.addAttribute("id", product.getId());
        uiModel.addAttribute("title", product.getTitle());
        uiModel.addAttribute("cost", product.getCost());
        return "product";
    }

    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String getForm(Model uiModel){
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "form";
    }

    @RequestMapping(params = "form", method = RequestMethod.POST)
    public String create(Product product) {
        productRepository.save(product);
        return "products";
    }

}
