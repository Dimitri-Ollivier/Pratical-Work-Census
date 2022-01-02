/* Executable */

package fr.epsi.b3.recensement;

import java.util.Scanner;

public class Application {
    private static Scanner sc = new Scanner(System.in);
    public MenuService menuService = new MenuService;

    public static void main(String[] args) {
        menuService.traiter(recencement, sc)
    }
}
