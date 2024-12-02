package org.cours.projets5.modele;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.util.Date;

@Document (collection = "utilisateurs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utilisateur {

    @Id
    private String id;
    private String nom;
    private String prenom;

    @Indexed(unique = true)  // Assurer que l'email est unique dans la base de données
    private String email;
    private String motDePasse;
    private String role;  //  "admin", "fournisseur", "client
    private String telephone;
    private String adresse;

}
