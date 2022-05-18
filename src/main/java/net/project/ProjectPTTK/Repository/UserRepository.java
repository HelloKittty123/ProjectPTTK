package net.project.ProjectPTTK.Repository;

import net.project.ProjectPTTK.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
