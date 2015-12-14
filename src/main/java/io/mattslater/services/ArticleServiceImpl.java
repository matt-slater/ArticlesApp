package io.mattslater.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mattslater.model.Article;
import io.mattslater.model.Category;
import io.mattslater.repos.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	private ArticleRepository repo;
	
	@Autowired
	public void setArticleRepository(ArticleRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public Iterable<Article> listAllArticles() {
		return repo.findAll();
	}
	
	@Override
	public Iterable<Article> listArticlesByTime() {
		return repo.findAllByOrderByIdDesc();
	}

	@Override
	public Article getArticleById(long id) {
		return repo.findOne(id);
	}

	@Override
	public Article saveArticle(Article article) {
		return repo.save(article);
	}

	@Override
	public void deleteArticle(long id) {
		repo.delete(id);
		
	}

	@Override
	public Iterable<Article> getArticlesByCategory(Category category) {
		return repo.findByCategoryOrderByIdDesc(category);
	}

}
