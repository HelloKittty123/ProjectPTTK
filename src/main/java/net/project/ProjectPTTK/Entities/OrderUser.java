package net.project.ProjectPTTK.Entities;

import javax.persistence.*;

@Entity
@Table(name = "order_user")
public class OrderUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  Integer user_id;

    private Integer product_id;

    private Integer count;

    private Integer status;

    public OrderUser() {
    }

    public OrderUser(Integer id, Integer user_id, Integer product_id, Integer count, Integer status) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.count = count;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderUser{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                ", count=" + count +
                ", status=" + status +
                '}';
    }
}
