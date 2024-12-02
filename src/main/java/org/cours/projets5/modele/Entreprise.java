package org.cours.projets5.modele;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="entreprises")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Entreprise {

    @Id
    private String id;

    private String nom;
    private String raisonSociale;    // Raison sociale
    private String numeroPatente;    // Numéro de patente
    private String secteurActivite;  // Secteur d'activité
    private String formeJuridique;   // Forme juridique de l'entreprise


}
