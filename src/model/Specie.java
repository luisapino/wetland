package model;

public class Specie {
    
    private String nameSpecie;
    private String scientificName;
    private boolean migratorySpecies;
    private SpecieType type;
    private boolean isFlora;


    //métodos

    public Specie(String nameSpecie, String scientificName, boolean migratorySpecies, SpecieType type, boolean isFlora){
        this.nameSpecie = nameSpecie;
        this.scientificName = scientificName;
        this.migratorySpecies = migratorySpecies;
        this.type = type;
        this.isFlora = isFlora;
    }

    public String getNameSpecie() {
        return nameSpecie;
    }
    public void setNameSpecie(String nameSpecie) {
        this.nameSpecie = nameSpecie;
    }
    public String getScientificName() {
        return scientificName;
    }
    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }
    public boolean getMigratorySpecies() {
        return migratorySpecies;
    }
    public void setMigratorySpecies(boolean migratorySpecies) {
        this.migratorySpecies = migratorySpecies;
    }
    public boolean getIsFlora() {
        return isFlora;
    }
    public void setIsFlora(boolean isFlora) {
        this.isFlora = isFlora;
    }
    public SpecieType getType() {
        return type;
    }
    public void setType(SpecieType type) {
        this.type = type;
    }
    
}
