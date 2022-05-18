package net.project.ProjectPTTK.Repository;

import net.project.ProjectPTTK.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
