package com.giotta.rest.security.examples.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;

import java.io.Serializable;
import java.util.List;

/**
 * @author John D Giotta
 * @since 6/1/16
 */
@NoRepositoryBean
public interface PublishableEntityRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {
    @PostFilter("hasPermission(filterObject, 'read')")
    List<T> findAll();

    @PostAuthorize("hasPermission(returnObject, 'read')")
    T findOne(ID id);

    @Query("select o from #{#entityName} o where o.status = 'PUBLISHED' " +
            "or 1 = ?#{security.hasRole('ROLE_ADMIN') ? 1 : 0}")
    Page<T> findAll(Pageable var1);
}
