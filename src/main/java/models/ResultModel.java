package models;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResultModel {
    private String racerAbbreviation;
    private String racerName;
    private String racerTeam;

    private LocalDateTime timeStartResult;

    private LocalDateTime timeEndResult;
    private Duration time;
    private String timeStr;
    private Integer num;

    public ResultModel() {
    }

    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }

    public Duration getTime() {
        return time;
    }

    public Integer getNum() {
        return num;
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

    public void setTimeStartResult(String dataStart, String timeStart) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSS");
        String data = dataStart + " " + timeStart;
        this.timeStartResult = LocalDateTime.parse(data, formatter);
    }

    public void setTimeEndResult(String dataEnd, String timeEnd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSS");
        String data = dataEnd + " " + timeEnd;
        this.timeEndResult = LocalDateTime.parse(data, formatter);
    }

    public void setTime() {
        this.time = Duration.between(this.timeStartResult, this.timeEndResult);
        long min = time.toMinutes();
        String sec = new DecimalFormat("00").format(time.getSeconds() % 60);
        String nano = new DecimalFormat("000").format(time.getNano() / 1000000);
        this.timeStr = min + ":" + sec + "." + nano;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return num + ". " + String.format("%-25s", racerName, 35) + '|' + String.format("%-30s", racerTeam, 35) + '|' + timeStr;
    }
}
