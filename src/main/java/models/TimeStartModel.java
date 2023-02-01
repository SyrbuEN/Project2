package models;

public class TimeStartModel {
    private String racerAbbreviation;
    private String dateStart;
    private String timeStart;

    public TimeStartModel() {
    }

    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setRacerAbbreviation(String racerAbbreviation) {
        this.racerAbbreviation = racerAbbreviation;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    @Override
    public String toString() {
        return "TimeStartModel{" +
                "racerAbbreviation='" + racerAbbreviation + '\'' +
                ", dateStart='" + dateStart + '\'' +
                ", timeStart='" + timeStart + '\'' +
                '}';
    }
}
