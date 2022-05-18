package net.project.ProjectPTTK.Controller;

import net.project.ProjectPTTK.Entities.Feedback;
import net.project.ProjectPTTK.Entities.User;
import net.project.ProjectPTTK.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/user")
    public List<User> list() {
        return service.listAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
            User user = service.get(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user/insert")
    public void add(@RequestBody User feedback) {
        service.save((feedback));
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Integer id) {
        try {
            User existUser = service.get(id);
            existUser.setFullName(user.getFullName());
            existUser.setEmail(user.getEmail());
            existUser.setAddress(user.getAddress());
            existUser.setPhoneNumber(user.getPhoneNumber());
            existUser.setPassword(user.getPassword());
            existUser.setCreatedAt(user.getCreatedAt());
            existUser.setUpdatedAt(user.getUpdatedAt());
            service.save(existUser);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
