package net.project.ProjectPTTK.Controller;

import net.project.ProjectPTTK.Entities.Orders;
import net.project.ProjectPTTK.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class OrdersController {
    @Autowired
    private OrdersService service;

    @GetMapping("/orders")
    public List<Orders> list() {
        return service.listAll();
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Orders> get(@PathVariable Integer id) {
        try {
            Orders orders = service.get(id);
            return new ResponseEntity<Orders>(orders, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/orders/insert")
    public void add(@RequestBody Orders orders) {
        service.save((orders));
    }

    @PutMapping("/orders/update/{id}")
    public ResponseEntity<Orders> update(@RequestBody Orders orders, @PathVariable Integer id) {
        try {
            Orders existOrders = service.get(id);
            existOrders.setEmail(orders.getEmail());
            existOrders.setFullName(orders.getFullName());
            existOrders.setNote(orders.getNote());
            existOrders.setPhoneNumber(orders.getPhoneNumber());
            existOrders.setAddress(orders.getAddress());
            existOrders.setCreateTime(orders.getCreateTime());
            existOrders.setTotal(orders.getTotal());
            service.save(existOrders);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/orders/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
