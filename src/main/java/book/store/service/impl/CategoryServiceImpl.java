package book.store.service.impl;

import book.store.dto.category.CategoryDto;
import book.store.dto.category.CreateCategoryRequest;
import book.store.mapper.CategoryMapper;
import book.store.repository.category.CategoryRepository;
import book.store.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDto createCategory(CreateCategoryRequest request) {
        return categoryMapper.toDto(
                categoryRepository.save(
                        categoryMapper.toModel(request)));
    }
}
