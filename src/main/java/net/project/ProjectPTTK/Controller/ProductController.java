package net.project.ProjectPTTK.Controller;

import net.project.ProjectPTTK.Entities.Product;
import net.project.ProjectPTTK.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/product")
    public List<Product> list() {
        return service.listAll();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = service.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product/insert")
    public void add(@RequestBody Product product) {
        service.save((product));
    }

    @PutMapping("/product/update/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Integer id) {
        try {
            Product existProduct = service.get(id);
            existProduct.setDescription(product.getDescription());
            existProduct.setPrice(product.getPrice());
            existProduct.setThumbnail(product.getThumbnail());
            existProduct.setTitle(product.getTitle());
            service.save(existProduct);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/product/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
