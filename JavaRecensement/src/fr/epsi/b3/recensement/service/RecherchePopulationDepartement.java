package fr.epsi.b3.recensement.service;

import fr.epsi.b3.recensement.MenuService;
import fr.epsi.b3.recensement.Recensement;
import fr.epsi.b3.recensement.Ville;

import java.util.Scanner;

public class RecherchePopulationDepartement extends MenuService {
    public static void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Veulliez saisir le numéro du département de votre choix :");

        String scan = scanner.next();
        boolean validCity = false;
        int nombreHabitants = 0;

        for (int i = 0; i <= recensement.GetListSize() - 1; i++) {
            Ville ville = recensement.listeVilles.get(i);

            if (ville.getCodeDepartement().equals(scan)) {
                nombreHabitants += ville.getPopulation();
                validCity = true;
            }
        }

        if (!validCity) {
            System.out.println("La département saisie n'existe pas :(");
        } else {
            System.out.println("Il y a "+ nombreHabitants + " dans le département numéro " + scan + ".");
        }
    }
}
