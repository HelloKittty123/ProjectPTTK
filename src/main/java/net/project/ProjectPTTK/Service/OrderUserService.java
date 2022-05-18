package net.project.ProjectPTTK.Service;

import net.project.ProjectPTTK.Entities.OrderUser;
import net.project.ProjectPTTK.Repository.OrderUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderUserService {
    @Autowired
    private OrderUserRepository repo;

    public List<OrderUser> listAll() { return repo.findAll(); }

    public void save(OrderUser orderUser) { repo.save(orderUser); }

    public OrderUser get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) { repo.deleteById(id); }
}
