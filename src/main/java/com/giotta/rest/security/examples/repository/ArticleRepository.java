package com.giotta.rest.security.examples.repository;

import com.giotta.rest.security.examples.domain.Article;
import com.giotta.rest.security.examples.model.PublishableEntityRepository;

/**
 * @author John D Giotta
 * @since 6/1/16
 */
public interface ArticleRepository extends PublishableEntityRepository<Article, Long> {
}
