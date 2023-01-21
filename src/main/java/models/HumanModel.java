package models;

public class HumanModel {
    private String humanAbbreviation;
    private String humanName;
    private String humanCar;

    public HumanModel() {
    }

    public HumanModel(String racerAbbreviation, String racerName, String racerTeam) {
        this.humanAbbreviation = racerAbbreviation;
        this.humanName = racerName;
        this.humanCar = racerTeam;
    }

    public String getHumanAbbreviation() {
        return humanAbbreviation;
    }

    public String getHumanName() {
        return humanName;
    }

    public String getHumanCar() {
        return humanCar;
    }

    public void setHumanAbbreviation(String humanAbbreviation) {
        this.humanAbbreviation = humanAbbreviation;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    public void setHumanCar(String humanCar) {
        this.humanCar = humanCar;
    }

    @Override
    public String toString() {
        return "HumanModel{" +
                "humanAbbreviation='" + humanAbbreviation + '\'' +
                ", humanName='" + humanName + '\'' +
                ", humanCar='" + humanCar + '\'' +
                '}';
    }
}
