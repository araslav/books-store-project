package book.store.service;

import book.store.dto.category.CategoryDto;
import book.store.dto.category.CreateCategoryRequest;

public interface CategoryService {
    CategoryDto createCategory(CreateCategoryRequest request);
}
