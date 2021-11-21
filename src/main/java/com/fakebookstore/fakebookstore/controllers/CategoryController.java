package com.fakebookstore.fakebookstore.controllers;

import com.fakebookstore.fakebookstore.models.Category;
import com.fakebookstore.fakebookstore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bookstore/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Object> makeCategory(@Valid @RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping
    public ResponseEntity<Object> retrieveAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> retrieveACategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> retrieveByBookName(@RequestParam("name") String name) {
        return categoryService.search(name);
    }

    @GetMapping("/{id}/book")
    public ResponseEntity<Object> findCategoryById(@PathVariable Long id) {
        return categoryService.findCategoryById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editCategory(@PathVariable Long id, @Valid @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeCategory(@PathVariable Long id) {
        return categoryService.deleteCategory(id);
    }



}
