package org.cours.projets5.repository;

import org.cours.projets5.modele.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UtilisateurRepository extends MongoRepository <Utilisateur,String>{

    boolean existsByEmail(String email);

}


