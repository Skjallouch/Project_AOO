package projetaoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        logger.info("Application démarrée avec succès");

        // Ajouter un hook de fermeture
        Runtime.getRuntime().addShutdownHook(new Thread(() -> logger.info("Arrêt de l'application...")));

    }
}