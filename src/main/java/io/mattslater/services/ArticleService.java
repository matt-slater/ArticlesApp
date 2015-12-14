package io.mattslater.services;

import io.mattslater.model.Article;
import io.mattslater.model.Category;

public interface ArticleService {
	
	Iterable<Article> listAllArticles();
	
	Article getArticleById(long id);
	
	Article saveArticle(Article article);
	
	void deleteArticle(long id);
	
	Iterable<Article> listArticlesByTime();
	
	Iterable<Article> getArticlesByCategory(Category category);

}
