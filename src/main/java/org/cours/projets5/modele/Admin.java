package org.cours.projets5.modele;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admins")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Admin extends Utilisateur {




}
