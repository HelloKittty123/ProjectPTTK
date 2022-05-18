package net.project.ProjectPTTK.Repository;

import net.project.ProjectPTTK.Entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
