package net.project.ProjectPTTK.Service;

import net.project.ProjectPTTK.Entities.Feedback;
import net.project.ProjectPTTK.Repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository repo;

    public List<Feedback> listAll() { return repo.findAll(); }

    public void save(Feedback feedback) { repo.save(feedback); }

    public Feedback get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) { repo.deleteById(id); }
}
