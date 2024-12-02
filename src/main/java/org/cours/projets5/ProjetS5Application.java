package org.cours.projets5;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class ProjetS5Application {

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ProjetS5Application.class, args);
    }

    @Bean
    public CommandLineRunner testMongoConnection() {
        return args -> {
            try {
                // Essayer d'interroger une collection pour vérifier la connexion
                long count = mongoTemplate.getCollection("yourCollectionName").countDocuments();
                System.out.println("Connection réussie à MongoDB, documents trouvés : " + count);
            } catch (Exception e) {
                System.err.println("Erreur de connexion à MongoDB: " + e.getMessage());
            }
        };
    }
}
