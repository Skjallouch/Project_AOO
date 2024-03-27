package projetaoo.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableJpaRepositories(basePackages = {"projetaoo.repository"})
public class JpaConfig {
}
