package fr.epsi.b3.recensement.service;

import fr.epsi.b3.recensement.Departement;
import fr.epsi.b3.recensement.MenuService;
import fr.epsi.b3.recensement.Recensement;
import fr.epsi.b3.recensement.Ville;

import java.util.ArrayList;
import java.util.Scanner;

public class RechercheTopDepartement extends MenuService {
    public static void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Voici les 10 premiers départements les peuplés de France :");

        ArrayList<String> departementsValues = new ArrayList<>();
        ArrayList<Departement> departements = new ArrayList<>();

        for (int i = 0; i <= recensement.GetListSize() - 1; i++) {
            Ville ville = recensement.listeVilles.get(i);

            Departement departement = new Departement(ville.getCodeDepartement());

            if (!departementsValues.contains(departement.getCodeDepartement())) {
                departements.add(departement);
                departementsValues.add(departement.getCodeDepartement());
            }
        }

        for (Departement departement: departements) {
            int nombreHabitants = 0;

            for (int i = 0; i <= recensement.GetListSize() - 1; i++) {
                Ville ville = recensement.listeVilles.get(i);

                if (ville.getCodeDepartement().equals(departement.getCodeDepartement())) {
                    nombreHabitants += ville.getPopulation();
                }
            }

            departement.setPopulationDepartement(nombreHabitants);
        }

        Departement[] classement = new Departement[10];

        for (int i = 0; i <= classement.length - 1; i++) {
            int max = 0;

            for (int j = 0; j <= departements.size() - 1; j++) {
                int population = departements.get(j).getPopulationDepartement();
                if (population > max) {
                    max = departements.get(j).getPopulationDepartement();
                    classement[i] = departements.get(j);
                }
            }

            for (int k = 0; k <= departements.size() - 1; k++) {
                if (departements.get(k).getPopulationDepartement() == max) {
                    departements.remove(k);
                }
            }
        }

        for (int i = 0; i <= classement.length - 1; i++) {
            System.out.println("    - Le département numéro " + classement[i].getCodeDepartement()+ " avec " + classement[i].getPopulationDepartement() + " habitants.");
        }
    }
}
