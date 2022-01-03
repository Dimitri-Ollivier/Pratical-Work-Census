package fr.epsi.b3.recensement;

import fr.epsi.b3.recensement.service.*;

import java.util.Scanner;

public abstract class MenuService {
    public static void traiter(Recensement recensement, Scanner scanner) {
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
        int nb = scanner.nextInt();

        switch (nb) {
            case 1:
                RecherchePopulationVille recherchePopulationVille = new RecherchePopulationVille();
                recherchePopulationVille.traiter(recensement, scanner);
                break;
            case 2:
                RecherchePopulationDepartement recherchePopulationDepartement = new RecherchePopulationDepartement();
                recherchePopulationDepartement.traiter(recensement, scanner);
                break;
            case 3:
                RecherchePopulationRegion recherchePopulationRegion = new RecherchePopulationRegion();
                recherchePopulationRegion.traiter(recensement, scanner);
                break;
            case 4:
                RechercheTopRegion rechercheTopRegion = new RechercheTopRegion();
                rechercheTopRegion.traiter(recensement, scanner);
                break;
            case 5:
                RechercheTopDepartement rechercheTopDepartement = new RechercheTopDepartement();
                rechercheTopDepartement.traiter(recensement, scanner);
                break;
            case 6:
                RechercheTopVilleDepartement rechercheTopVilleDepartement = new RechercheTopVilleDepartement();
                rechercheTopVilleDepartement.traiter(recensement, scanner);
                break;
            case 7:
                RechercheTopVilleRegion rechercheTopVilleRegion = new RechercheTopVilleRegion();
                rechercheTopVilleRegion.traiter(recensement, scanner);
                break;
            case 8:
                RechercheTopVilleFrance rechercheTopVilleFrance = new RechercheTopVilleFrance();
                rechercheTopVilleFrance.traiter(recensement, scanner);
                break;
            case 9:
                System.exit(0);
                break;
            default:
                System.out.println("le choix saisi n'est pas valide");
        }
    }
}