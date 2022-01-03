package fr.epsi.b3.recensement;

public class Region {
    private final String codeRegion;
    private final String nomRegion;
    private int populationRegion;

    public Region(String codeRegion, String nomRegion) {
        this.codeRegion = codeRegion;
        this.nomRegion = nomRegion;
    }

    public void setPopulationRegion(int populationRegion) {
        this.populationRegion = populationRegion;
    }

    public String getCodeRegion() {
        return codeRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public int getPopulationRegion() {
        return populationRegion;
    }
}
