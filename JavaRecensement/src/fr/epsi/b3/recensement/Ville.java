package fr.epsi.b3.recensement;

public class Ville {
    private String codeRegion;
    private String nomRegion;
    private String codeDepartement;
    private String codeCommmune;
    private String nomCommune;
    private int population;

    public Ville (String codeRegion, String nomRegion, String codeDepartement, String codeCommmune, String nomCommune, int population) {
        this.codeRegion = codeRegion;
        this.nomRegion = nomRegion;
        this.codeDepartement = codeDepartement;
        this.codeCommmune = codeCommmune;
        this.nomCommune = nomCommune;
        this.population = population;
    }
}
