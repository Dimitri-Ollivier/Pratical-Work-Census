package fr.epsi.b3.recensement.service;

import fr.epsi.b3.recensement.Region;
import fr.epsi.b3.recensement.MenuService;
import fr.epsi.b3.recensement.Recensement;
import fr.epsi.b3.recensement.Ville;

import java.util.ArrayList;
import java.util.Scanner;

public class RechercheTopRegion extends MenuService {
    public RechercheTopRegion(Recensement recensement, Scanner scanner) {
        super(recensement, scanner);
    }
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Voici les 10 premières régions les peuplées de France :");

        ArrayList<String> regionsValues = new ArrayList<>();
        ArrayList<Region> regions = new ArrayList<>();

        for (int i = 0; i <= recensement.GetListSize() - 1; i++) {
            Ville ville = recensement.listeVilles.get(i);

            Region region = new Region(ville.getCodeRegion(), ville.getNomRegion());

            if (!regionsValues.contains(region.getCodeRegion())) {
                regions.add(region);
                regionsValues.add(region.getCodeRegion());
            }
        }

        for (Region region: regions) {
            int nombreHabitants = 0;

            for (int i = 0; i <= recensement.GetListSize() - 1; i++) {
                Ville ville = recensement.listeVilles.get(i);

                if (ville.getCodeRegion().equals(region.getCodeRegion())) {
                    nombreHabitants += ville.getPopulation();
                }
            }

            region.setPopulationRegion(nombreHabitants);
        }

        Region[] classement = new Region[10];

        for (int i = 0; i <= classement.length - 1; i++) {
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

        for (int i = 0; i <= classement.length - 1; i++) {
            System.out.println("    - La région " + classement[i].getNomRegion() + " avec " + classement[i].getPopulationRegion() + " habitants.");
        }
    }
}
