package fr.epsi.b3.recensement.service;

import fr.epsi.b3.recensement.MenuService;
import fr.epsi.b3.recensement.Recensement;
import fr.epsi.b3.recensement.Ville;

import java.util.Scanner;

public class RecherchePopulationVille extends MenuService {
    public static void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Veulliez saisir le nom de la ville de votre choix :");

        String scan = scanner.next();
        Boolean validCity = false;

        for (int i = 0; i <= recensement.GetListSize() - 1; i++) {
            Ville ville = recensement.listeVilles.get(i);

            if (ville.getNomCommune().equals(scan)) {
                System.out.println("Il y a " + ville.getPopulation() + " habitants à " + ville.getNomCommune() + " (" + ville.getCodeDepartement() + " " + ville.getCodeCommmune() + ")" + " dans la région " + ville.getNomRegion() + ".");
                validCity = true;
            }
        }

        if (!validCity) {
            System.out.println("La ville saisie n'existe pas :(");
        }
    }
}
