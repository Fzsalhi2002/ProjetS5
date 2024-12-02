package org.cours.projets5.modele;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "fournisseurs")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder


public class Fournisseur extends Utilisateur{

    private Entreprise entreprise;

    private Date dateCreation;
    private Date dateDerniereModification;

}
