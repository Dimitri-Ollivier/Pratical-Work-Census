package fr.epsi.b3.recensement.service;

import fr.epsi.b3.recensement.MenuService;
import fr.epsi.b3.recensement.Recensement;
import fr.epsi.b3.recensement.Region;
import fr.epsi.b3.recensement.Ville;

import java.util.ArrayList;
import java.util.Scanner;

public class RechercheTopVilleFrance extends MenuService {
    public static void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Voici les 10 premières villes les peuplées de France :");

        ArrayList<String> villesValues = new ArrayList<>();
        Ville[] classement = new  Ville[10];
        ArrayList<Ville> villes = recensement.listeVilles;

        for (int i = 0; i <= classement.length - 1; i++) {
            for (int j = 0; j <= villes.size() - 1; j++) {
                int max = 0;

                for (int j = 0; j <= regions.size() - 1; j++) {
                    int population = regions.get(j).getPopulationRegion();
                    if (population > max) {
                        max = regions.get(j).getPopulationRegion();
                        classement[i] = regions.get(j);
                    }
                }

                for (int k = 0; k <= regions.size() - 1; k++) {
                    if (regions.get(k).getPopulationRegion() == max) {
                        regions.remove(k);
                    }
                }
            }
        }

        for (int i = 0; i <= classement.length - 1; i++) {
            System.out.println("La région " + classement[i].getNomRegion() + " avec " + classement[i].getPopulation() + " habitants.");
        }
    }
}
