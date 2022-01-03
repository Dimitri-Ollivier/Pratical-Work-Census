package fr.epsi.b3.recensement;

import java.util.ArrayList;

public class Recensement {
    public ArrayList<Ville> listeVilles = new ArrayList<>();

    public void AddCity (Ville city) {
        this.listeVilles.add(city);
    }

    public int GetListSize() {
        return listeVilles.size();
    }
}