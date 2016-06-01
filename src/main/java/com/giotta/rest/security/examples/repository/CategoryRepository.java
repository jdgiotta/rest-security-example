package com.giotta.rest.security.examples.repository;

import com.giotta.rest.security.examples.domain.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author John D Giotta
 * @since 6/1/16
 */
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
