package models;

import java.time.Duration;
import java.time.Instant;

public class ResultModel {
    private String racerAbbreviation;
    private String racerName;
    private String racerTeam;
    private Duration time;

    public ResultModel() {
    }

    public ResultModel(String racerAbbreviation, String racerName, String racerTeam, Duration time) {
        this.racerAbbreviation = racerAbbreviation;
        this.racerName = racerName;
        this.racerTeam = racerTeam;
        this.time = time;
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

    public Duration getTime() {
        return time;
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

    public void setTime(Instant start, Instant end) {
        this.time = Duration.between(start, end);
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "racerName='" + racerName + '\'' +
                ", racerTeam='" + racerTeam + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
