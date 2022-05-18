package net.project.ProjectPTTK.Controller;

import net.project.ProjectPTTK.Entities.Role;
import net.project.ProjectPTTK.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class RoleController {
    @Autowired
    private RoleService service;

    @GetMapping("/role")
    public List<Role> list() {
        return service.listAll();
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<Role> get(@PathVariable Integer id) {
        try {
            Role role = service.get(id);
            return new ResponseEntity<Role>(role, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/role/insert")
    public void add(@RequestBody Role role) {
        service.save((role));
    }

    @PutMapping("/role/update/{id}")
    public ResponseEntity<Role> update(@RequestBody Role role, @PathVariable Integer id) {
        try {
            Role existRole = service.get(id);
            existRole.setName(role.getName());
            service.save(existRole);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/role/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
