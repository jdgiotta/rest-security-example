package com.giotta.rest.security.examples.domain;

import com.giotta.rest.security.examples.model.PublishableEntity;

import javax.persistence.*;

/**
 * @author John D Giotta
 * @since 6/1/16
 */
@Entity
public class Article extends PublishableEntity {
    private Long id;
    private String title;
    private Category category;

    protected Article() {}

    public Article(String title, Category category) {
        this.title = title;
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @ManyToOne
    public Category getCategory() { return category; }

    public void setCategory(Category category) {
        this.category = category;
    }
}
