package net.project.ProjectPTTK.Service;

import net.project.ProjectPTTK.Entities.Product;
import net.project.ProjectPTTK.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> listAll() { return repo.findAll(); }

    public void save(Product product) { repo.save(product); }

    public Product get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) { repo.deleteById(id); }
}
