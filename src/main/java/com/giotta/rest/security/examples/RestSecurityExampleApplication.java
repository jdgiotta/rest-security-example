package com.giotta.rest.security.examples;

import com.giotta.rest.security.examples.domain.Article;
import com.giotta.rest.security.examples.domain.Category;
import com.giotta.rest.security.examples.repository.ArticleRepository;
import com.giotta.rest.security.examples.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestSecurityExampleApplication {

    private static final Logger log = LoggerFactory.getLogger(RestSecurityExampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestSecurityExampleApplication.class, args);
	}

	@Bean
    public CommandLineRunner bootStrap (CategoryRepository categoryRepository, ArticleRepository articleRepository) {
        return (args) -> {
            Category category1 = new Category("World News");
            Category category2 = new Category("Opinion");

            log.info("Saving categories...");
            categoryRepository.save(category1);
            categoryRepository.save(category2);

            Article article1 = new Article("Prime Minister Resigns After Sriracha Embarrassment", category1);
            Article article2 = new Article("Should We All Own a Plumbus?", category2);

            log.info("Saving articles...");
            articleRepository.save(article1);
            articleRepository.save(article2);
        };

    }
}
