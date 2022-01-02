package fr.epsi.b3.recensement;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static final Scanner sc = new Scanner(System.in);
    protected static Path path = Paths.get("D:\\Documents\\EPSI\\Cours\\Java\\Recensement\\JavaRecensement\\recensement_2016.csv");

    public static void main(String[] args) {
        Recensement recensement = new Recensement();

        if (Files.exists(path) && Files.isRegularFile(path) && Files.isReadable(path)) {
            List<String> lines = null;

            try {
                lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.exit(-1);
            }

            for (String ligne: lines) {
                String[] morceaux = ligne.split(";");
                String codeRegion = morceaux[0];
                String nomRegion = morceaux[1];
                String codeDepartement = morceaux[2];
                String codeCommune = morceaux[5];
                String nomCommune = morceaux[6];
                String population = morceaux[7];

                int populationTotale = Integer.parseInt(population.replace(" ", "").trim());

                Ville ville = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, populationTotale);

                recensement.AddCity(ville);
            }
        } else {
            System.out.println("Erreur lors de la lecture du fichier, veulliez vérifier le répertoire saisie en paramètre et les autorisations du fichier.");
        }

        MenuService.traiter(recensement, sc);
    }
}
