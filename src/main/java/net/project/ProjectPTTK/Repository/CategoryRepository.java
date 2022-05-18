package net.project.ProjectPTTK.Repository;

import net.project.ProjectPTTK.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
