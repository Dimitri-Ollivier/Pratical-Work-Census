package fr.epsi.b3.recensement;

public class Ville {
    private final String codeRegion;
    private final String nomRegion;
    private final String codeDepartement;
    private final String codeCommmune;
    private final String nomCommune;
    private final int population;

    public Ville (String codeRegion, String nomRegion, String codeDepartement, String codeCommmune, String nomCommune, int population) {
        this.codeRegion = codeRegion;
        this.nomRegion = nomRegion;
        this.codeDepartement = codeDepartement;
        this.codeCommmune = codeCommmune;
        this.nomCommune = nomCommune;
        this.population = population;
    }

    public String getCodeRegion() {
        return codeRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public String getCodeCommmune() {
        return codeCommmune;
    }

    public String getNomCommune() {
        return nomCommune;
    }

    public int getPopulation() {
        return population;
    }
}
