package io.mattslater.controllers;

import io.mattslater.model.Article;
import io.mattslater.model.Category;
import io.mattslater.model.CurrentUser;
import io.mattslater.model.User;
import io.mattslater.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArticleController {
	
	private ArticleService articleService;
	
	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@RequestMapping(value="articles", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("articles", articleService.getArticlesByCategory(Category.FEATURE));
		model.addAttribute("opEd", articleService.getArticlesByCategory(Category.OPED));
		model.addAttribute("arts", articleService.getArticlesByCategory(Category.ARTS));
		return "articles";
	}
	
	@RequestMapping("article/new")
	public String newWidget(Model model) {
		model.addAttribute("article", new Article());
		return "articleform";
	}
	
	@RequestMapping(value="article", method = RequestMethod.POST)
	public String saveArticle(@CurrentUser User currentUser, Article article) {
		article.setAuthor(currentUser);
		articleService.saveArticle(article);
		return "redirect:/articles"; 
	}
	
	@RequestMapping("article/{id}")
	public String showArticle(@PathVariable Integer id, Model model) {
		model.addAttribute("article", articleService.getArticleById(id));
		return "articleview";
	}
	
	

}
