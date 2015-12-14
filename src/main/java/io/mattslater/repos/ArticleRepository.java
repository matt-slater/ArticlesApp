package io.mattslater.repos;

import org.springframework.data.repository.CrudRepository;

import io.mattslater.model.Article;
import io.mattslater.model.Category;

public interface ArticleRepository extends CrudRepository<Article, Long> {
	
	Iterable<Article> findAllByOrderByIdDesc();
	Iterable<Article> findByCategoryOrderByIdDesc(Category category);
	
}
