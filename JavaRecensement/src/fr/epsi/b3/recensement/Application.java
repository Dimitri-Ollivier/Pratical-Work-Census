package fr.epsi.b3.recensement;

import fr.epsi.b3.recensement.service.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Application {
    // Instanciation du scanner
    private static final Scanner sc = new Scanner(System.in);
    // Récupération du fichier à traiter
    protected static Path path = Paths.get("D:\\Documents\\EPSI\\Cours\\Java\\Recensement\\JavaRecensement\\src\\recensement_2016.csv");

    public static void main(String[] args) {
        // Contrôle du fichier
        if (Files.exists(path) && Files.isRegularFile(path) && Files.isReadable(path)) {
            // Instanciation de la liste de villes
            Recensement recensement = new Recensement();

            List<String> lines = null;

            // Lecture du fichier
            try {
                lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.exit(-1);
            }

            for (String ligne: lines) {
                // Récupération des données
                String[] morceaux = ligne.split(";");
                String codeRegion = morceaux[0];
                String nomRegion = morceaux[1];
                String codeDepartement = morceaux[2];
                String codeCommune = morceaux[5];
                String nomCommune = morceaux[6];
                String population = morceaux[9];
                int populationTotale = Integer.parseInt(population.replace(" ", "").trim());

                // Création d'une instance pour chaque ville
                Ville ville = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, populationTotale);

                // Ajout de chaque ville dans l'instance recensement
                recensement.AddCity(ville);
            }

            // Lancement du menu de l'application
            System.out.println("1 : Population d’une ville donnée");
            System.out.println("2 : Population d’un département donné");
            System.out.println("3 : Population d’une région donnée");
            System.out.println("4 : Afficher les 10 régions les plus peuplées");
            System.out.println("5 : Afficher les 10 départements les plus peuplés");
            System.out.println("6 : Afficher les 10 villes les plus peuplées d’un département");
            System.out.println("7 : Afficher les 10 villes les plus peuplées d’une région");
            System.out.println("8 : Afficher les 10 villes les plus peuplées de France");
            System.out.println("9 : Sortir");
            System.out.println("Veulliez choisir une action à exécuter : ");
            int nb = sc.nextInt();

            // Traitement de la donnée saisie
            switch (nb) {
                case 1:
                    RecherchePopulationVille recherchePopulationVille = new RecherchePopulationVille(recensement, sc);
                    recherchePopulationVille.traiter(recensement, sc);
                    break;
                case 2:
                    RecherchePopulationDepartement recherchePopulationDepartement = new RecherchePopulationDepartement(recensement, sc);
                    recherchePopulationDepartement.traiter(recensement, sc);
                    break;
                case 3:
                    RecherchePopulationRegion recherchePopulationRegion = new RecherchePopulationRegion(recensement, sc);
                    recherchePopulationRegion.traiter(recensement, sc);
                    break;
                case 4:
                    RechercheTopRegion rechercheTopRegion = new RechercheTopRegion(recensement, sc);
                    rechercheTopRegion.traiter(recensement, sc);
                    break;
                case 5:
                    RechercheTopDepartement rechercheTopDepartement = new RechercheTopDepartement(recensement, sc);
                    rechercheTopDepartement.traiter(recensement, sc);
                    break;
                case 6:
                    RechercheTopVilleDepartement rechercheTopVilleDepartement = new RechercheTopVilleDepartement(recensement, sc);
                    rechercheTopVilleDepartement.traiter(recensement, sc);
                    break;
                case 7:
                    RechercheTopVilleRegion rechercheTopVilleRegion = new RechercheTopVilleRegion(recensement, sc);
                    rechercheTopVilleRegion.traiter(recensement, sc);
                    break;
                case 8:
                    RechercheTopVilleFrance rechercheTopVilleFrance = new RechercheTopVilleFrance(recensement, sc);
                    rechercheTopVilleFrance.traiter(recensement, sc);
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("le choix saisi n'est pas valide");
            }

        } else {
            System.out.println("Erreur lors de la lecture du fichier, veulliez vérifier le répertoire saisie en paramètre et les autorisations du fichier.");
        }
    }
}
