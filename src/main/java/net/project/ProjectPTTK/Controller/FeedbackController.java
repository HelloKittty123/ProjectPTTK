package net.project.ProjectPTTK.Controller;

import net.project.ProjectPTTK.Entities.Category;
import net.project.ProjectPTTK.Entities.Feedback;
import net.project.ProjectPTTK.Service.CategoryService;
import net.project.ProjectPTTK.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class FeedbackController {
    @Autowired
    private FeedbackService service;

    @GetMapping("/feedback")
    public List<Feedback> list() {
        return service.listAll();
    }

    @GetMapping("/feedback/{id}")
    public ResponseEntity<Feedback> get(@PathVariable Integer id) {
        try {
            Feedback feedback = service.get(id);
            return new ResponseEntity<Feedback>(feedback, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Feedback>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/feedback/insert")
    public void add(@RequestBody Feedback feedback) {
        service.save((feedback));
    }

    @PutMapping("/feedback/update/{id}")
    public ResponseEntity<Feedback> update(@RequestBody Feedback feedback, @PathVariable Integer id) {
        try {
            Feedback existFeedback = service.get(id);
            existFeedback.setEmail(feedback.getEmail());
            existFeedback.setFullName(feedback.getFullName());
            existFeedback.setNote(feedback.getNote());
            existFeedback.setPhoneNumber(feedback.getPhoneNumber());
            existFeedback.setCreatedAt(feedback.getCreatedAt());
            service.save(existFeedback);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/feedback/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
