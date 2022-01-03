package fr.epsi.b3.recensement;

import fr.epsi.b3.recensement.service.*;

import java.util.Scanner;

public abstract class MenuService {
    static Recensement recensement;
    static Scanner scanner;

    public MenuService(Recensement recensement, Scanner scanner) {
        this.recensement = recensement;
        this.scanner = scanner;
    }

    public abstract void traiter(Recensement recensement, Scanner scanner);

    public static void startMenu() {

    }
}