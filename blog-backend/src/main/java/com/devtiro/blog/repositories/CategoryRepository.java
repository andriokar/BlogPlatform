package com.devtiro.blog.repositories;

import com.devtiro.blog.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Query("SELECT category FROM Category category LEFT JOIN FETCH category.posts")
    List<Category> findAllWithPostCount();

    Boolean existsByNameIgnoreCase(String name);
}
