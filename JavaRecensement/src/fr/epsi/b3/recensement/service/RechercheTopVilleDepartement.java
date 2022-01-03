package fr.epsi.b3.recensement.service;

import fr.epsi.b3.recensement.MenuService;
import fr.epsi.b3.recensement.Recensement;
import fr.epsi.b3.recensement.Ville;

import java.util.ArrayList;
import java.util.Scanner;

public class RechercheTopVilleDepartement extends MenuService {
    public static void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Veulliez saisir le numéro de département de votre choix :");

        String scan = scanner.next();
        Boolean validCity = false;

        Ville[] classement = new  Ville[10];
        ArrayList<Ville> villes = recensement.listeVilles;

        for (int i = 0; i <= classement.length - 1; i++) {
            int max = 0;

            for (int j = 0; j <= villes.size() - 1; j++) {
                if (villes.get(j).getCodeRegion().equals(scan)) {
                    if (villes.get(j).getPopulation() > max) {
                        max = villes.get(j).getPopulation();
                        classement[i] = villes.get(j);
                        validCity = true;
                    }
                }
            }

            for (int k = 0; k <= villes.size() - 1; k++) {
                if (villes.get(k).getPopulation() == max) {
                    villes.remove(k);
                }
            }
        }

        if (!validCity) {
            System.out.println("Le numéro de département saisie n'existe pas :(");
        }

        System.out.println("Voici les 10 premières villes les peuplées de France :");

        for (int i = 0; i <= classement.length - 1; i++) {
            System.out.println("    - " + classement[i].getNomCommune() + " dans le département numéro " + classement[i].getCodeDepartement() + " avec " + classement[i].getPopulation() + " habitants.");
        }
    }
}
