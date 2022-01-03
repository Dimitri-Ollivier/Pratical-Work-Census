package fr.epsi.b3.recensement;

public class Departement {
    private final String codeDepartement;
    private int populationDepartement;

    public Departement (String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public void setPopulationDepartement(int populationDepartement) {
        this.populationDepartement = populationDepartement;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public int getPopulationDepartement() {
        return populationDepartement;
    }
}
