package net.project.ProjectPTTK.Controller;

import net.project.ProjectPTTK.Entities.OrderUser;
import net.project.ProjectPTTK.Service.OrderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class OrderUserController {
    @Autowired
    private OrderUserService service;

    @GetMapping("/orderuser")
    public List<OrderUser> list() {
        return service.listAll();
    }

    @GetMapping("/orderuser/{id}")
    public ResponseEntity<OrderUser> get(@PathVariable Integer id) {
        try {
            OrderUser orderuser = service.get(id);
            return new ResponseEntity<OrderUser>(orderuser, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<OrderUser>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/orderuser/insert")
    public void add(@RequestBody OrderUser orderuser) {
        service.save((orderuser));
    }

    @PutMapping("/orderuser/update/{id}")
    public ResponseEntity<OrderUser> update(@RequestBody OrderUser orderuser, @PathVariable Integer id) {
        try {
            OrderUser existOrderUser = service.get(id);
            existOrderUser.setCount(orderuser.getCount());
            existOrderUser.setStatus(orderuser.getStatus());
            service.save(existOrderUser);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/orderuser/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
