package com.devtiro.blog.controllers;

import com.devtiro.blog.domain.dtos.CategoryDto;
import com.devtiro.blog.domain.entities.Category;
import com.devtiro.blog.mappers.CategoryMapper;
import com.devtiro.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories() {
        return ResponseEntity.ok(
                categoryService.listCategories()
                        .stream()
                        .map(categoryMapper::categoryToCategoryDto)
                        .toList()
        );
    }
}
