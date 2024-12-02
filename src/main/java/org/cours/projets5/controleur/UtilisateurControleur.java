package org.cours.projets5.controleur;


import org.cours.projets5.modele.Utilisateur;
import org.cours.projets5.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurControleur {

    @Autowired
    private UtilisateurService service;

    @PostMapping("/ajouter")
    @ResponseStatus(HttpStatus.CREATED)
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {
        return service.ajouterUtilisateur(utilisateur);
    }

    @GetMapping("/")
    public List<Utilisateur> ListerUtilisateurs() {
        return service.ListerUtilisateurs();
    }

    @GetMapping("/{utilisateurId}")
    public Utilisateur afficherUtilisateurParId(@PathVariable String utilisateurId) {
        return service.afficherUtilisateurParId(utilisateurId);
    }

    @PatchMapping("/{utilisateurId}")
    public Utilisateur modifierUtilisateur(@PathVariable String utilisateurId,@RequestBody Utilisateur utilisateur) {
        utilisateur.setId(utilisateurId);
        return service.modifierUtilisateur(utilisateur);
    }

    @DeleteMapping("/{utilisateurId}")
    public String supprimerUtilisateur(@PathVariable String utilisateurId) {
        return service.supprimerUtilisateur(utilisateurId);
    }







}
