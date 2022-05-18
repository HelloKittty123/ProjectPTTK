package net.project.ProjectPTTK.Service;

import net.project.ProjectPTTK.Entities.Category;
import net.project.ProjectPTTK.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repo;

    public List<Category> listAll() { return repo.findAll(); }

    public void save(Category category) { repo.save(category); }

    public Category get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) { repo.deleteById(id); }
}
