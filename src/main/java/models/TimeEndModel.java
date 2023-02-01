package models;

public class TimeEndModel {
    private String racerAbbreviation;
    private String dateEnd;
    private String timeEnd;

    public TimeEndModel() {
    }

    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setRacerAbbreviation(String racerAbbreviation) {
        this.racerAbbreviation = racerAbbreviation;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "TimeEndModel{" +
                "racerAbbreviation='" + racerAbbreviation + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                '}';
    }
}
