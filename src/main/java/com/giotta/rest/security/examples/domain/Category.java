package com.giotta.rest.security.examples.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * @author John D Giotta
 * @since 6/1/16
 */

@Entity
public class Category {
    private Long id;
    private String name;
    private Set<Article> articles;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, mappedBy = "category")
    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
