package org.cours.projets5.service;

import org.cours.projets5.modele.Utilisateur;
import org.cours.projets5.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service

public class UtilisateurService {
    @Autowired

    private UtilisateurRepository repository;


    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        if (repository.existsByEmail(utilisateur.getEmail())){
            throw new IllegalArgumentException("Un compte existe déjà avec cet email. ");
        }
        return repository.save(utilisateur);
    }


    public List<Utilisateur> ListerUtilisateurs(){
        return repository.findAll();
    }

    public Utilisateur afficherUtilisateurParId(String utilisateurId){
        return repository.findById(utilisateurId).get();
    }

    public Utilisateur modifierUtilisateur(Utilisateur utilisateur){
        Utilisateur ancienUtilisateur = repository.findById(utilisateur.getId()).orElse(null);
        if (ancienUtilisateur != null){
            ancienUtilisateur.setNom(utilisateur.getNom());
            ancienUtilisateur.setPrenom(utilisateur.getPrenom());
            ancienUtilisateur.setAdresse(utilisateur.getAdresse());
            ancienUtilisateur.setTelephone(utilisateur.getTelephone());
            ancienUtilisateur.setEmail(utilisateur.getEmail());
            ancienUtilisateur.setMotDePasse(utilisateur.getMotDePasse());
            ancienUtilisateur.setRole(utilisateur.getRole());
        }
        return repository.save(ancienUtilisateur);
    }


    public String supprimerUtilisateur(String utilisateurId) {
        repository.deleteById(utilisateurId);
        return utilisateurId + " est supprimé de la base de données.";
    }




    public List<Utilisateur> trouverUtilisateurs(){
        return repository.findAll();
    }


    public Utilisateur trouverUtilisateurParId(String utilisateurId) {
        return repository.findById(utilisateurId).get();
    }


}
