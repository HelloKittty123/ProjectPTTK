package net.project.ProjectPTTK.Controller;

import net.project.ProjectPTTK.Entities.Category;
import net.project.ProjectPTTK.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/category")
    public List<Category> list() {
        return service.listAll();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> get(@PathVariable Integer id) {
        try {
            Category category = service.get(id);
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/category/insert")
    public void add(@RequestBody Category category) {
        service.save((category));
    }

    @PutMapping("/category/update/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable Integer id) {
        try {
            Category existCategory = service.get(id);
            existCategory.setName(category.getName());
            existCategory.setH4_content(category.getH4_content());
            existCategory.setH5_content(category.getH5_content());
            service.save(existCategory);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/category/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
