package projetaoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetaoo.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    // Méthodes spécifiques aux articles
}
