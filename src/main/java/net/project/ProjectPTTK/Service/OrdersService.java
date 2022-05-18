package net.project.ProjectPTTK.Service;

import net.project.ProjectPTTK.Entities.Orders;
import net.project.ProjectPTTK.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository repo;

    public List<Orders> listAll() { return repo.findAll(); }

    public void save(Orders orders) { repo.save(orders); }

    public Orders get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) { repo.deleteById(id); }
}
