package models;

public class RacerModel {
    private String racerAbbreviation;
    private String racerName;
    private String racerTeam;

    public RacerModel() {
    }

    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }

    public String getRacerName() {
        return racerName;
    }

    public String getRacerTeam() {
        return racerTeam;
    }

    public void setRacerAbbreviation(String racerAbbreviation) {
        this.racerAbbreviation = racerAbbreviation;
    }

    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }

    public void setRacerTeam(String racerTeam) {
        this.racerTeam = racerTeam;
    }

    @Override
    public String toString() {
        return "RacerModel{" +
                "racerAbbreviation='" + racerAbbreviation + '\'' +
                ", racerName='" + racerName + '\'' +
                ", racerTeam='" + racerTeam + '\'' +
                '}';
    }
}