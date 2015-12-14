package io.mattslater.bootstrap;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import io.mattslater.model.Article;
import io.mattslater.model.Category;
import io.mattslater.repos.ArticleRepository;

@Component
public class ArticleLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	private ArticleRepository articleRepository;
	private Logger log = Logger.getLogger(ArticleRepository.class);
	
	@Autowired
	public void setArticleRepository(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Article a = new Article();
		a.setTitle("Lorem ipsum dolor sit amet, sodales sequi lacus, urna non.");
		a.setCategory(Category.FEATURE);
		a.setTeaser("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		a.setContent("Curabitur sodales ligula in libero. Sed dignissim lacinia nunc. "
				+ "Curabitur tortor. Pellentesque nibh. Aenean quam. "
				+ "In scelerisque sem at dolor. Maecenas mattis. Sed convallis tristique sem. "
				+ "Proin ut ligula vel nunc egestas porttitor. Morbi lectus risus, iaculis vel, "
				+ "suscipit quis, luctus non, massa. Fusce ac turpis quis ligula lacinia aliquet."
				+ " Mauris ipsum. Nulla metus metus, ullamcorper vel, tincidunt sed, euismod in,"
				+ " nibh. Quisque volutpat condimentum velit. Class aptent taciti sociosqu ad "
				+ "litora torquent per conubia nostra, per inceptos himenaeos. Nam nec ante. "
				+ "Sed lacinia, urna non tincidunt mattis, tortor neque adipiscing diam, a "
				+ "cursus ipsum ante quis turpis. Nulla facilisi. Ut fringilla. Suspendisse potenti."
				+ " Nunc feugiat mi a tellus consequat imperdiet. Vestibulum sapien. Proin quam. "
				+ "Etiam ultrices. Suspendisse in justo eu magna luctus suscipit. Sed lectus. "
				+ "Integer euismod lacus luctus magna. Quisque cursus, metus vitae pharetra auctor,"
				+ " sem massa mattis sem, at interdum magna augue eget diam. Vestibulum ante "
				+ "ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Morbi "
				+ "lacinia molestie dui. Praesent blandit dolor. Sed non quam. In vel mi sit amet"
				+ " augue congue elementum. Morbi in ipsum sit amet pede facilisis laoreet. Donec "
				+ "lacus nunc, viverra nec.");
		articleRepository.save(a);
		
		Article b = new Article();
		b.setTitle("Maecenas mattis.");
		b.setTeaser("Nulla metus metus, ullamcorper vel, tincidunt sed");
		b.setContent("asd");
		b.setCategory(Category.OPED);
		articleRepository.save(b);
		
		Article c = new Article();
		c.setTitle("Nulla facilisi. Ut fringilla. Suspendisse potenti.");
		c.setTeaser("Praesent blandit dolor. Sed non quam.");
		c.setContent("fds");
		c.setCategory(Category.FEATURE);
		articleRepository.save(c);
		
		Article d = new Article();
		d.setTitle("Suspendisse in justo eu magna luctus suscipit.");
		d.setTeaser("Vestibulum sapien. Proin quam.");
		d.setContent("fewjfbewfhejfsd dsdff dfds fds fds fds fds fd sf "
				+ " fds fd sf ds"
				+ "fd sf f df df ds fd fds f dsfs dfd s");
		d.setCategory(Category.ARTS);
		articleRepository.save(d);
		log.info("YESSSSSSSSSSS");
		
	}

}
