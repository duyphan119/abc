package com.api.shoesshop.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "category_alias")
    private String alias;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "parent_id")
    private Long parentId;

    // @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    // @JoinColumn(name = "parent_id", insertable = false, updatable = false)
    // private Category parent;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Set<Category> subCategories;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Set<Category> getSubCategories() {
        return this.subCategories;
    }

    public void setSubCategories(Set<Category> subCategories) {
        this.subCategories = subCategories;
    }

}
