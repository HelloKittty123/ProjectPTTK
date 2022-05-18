package net.project.ProjectPTTK.Entities;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "h4_content", nullable = false)
    private String h4_content;

    @Column(name = "h5_content", nullable = false)
    private String h5_content;

    public Category() {
    }

    public Category(Integer id, String name, String h4_content, String h5_content) {
        this.id = id;
        this.name = name;
        this.h4_content = h4_content;
        this.h5_content = h5_content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getH4_content() {
        return h4_content;
    }

    public void setH4_content(String h4_content) {
        this.h4_content = h4_content;
    }

    public String getH5_content() {
        return h5_content;
    }

    public void setH5_content(String h5_content) {
        this.h5_content = h5_content;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", h4_content='" + h4_content + '\'' +
                ", h5_content='" + h5_content + '\'' +
                '}';
    }
}

