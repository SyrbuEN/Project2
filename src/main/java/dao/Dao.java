package dao;

import models.RacerModel;
import models.TimeEndModel;
import models.TimeStartModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class Dao {

    public InputStream readFiles(String nameFile) {
        ClassLoader classLoader = Dao.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(nameFile);
        return inputStream;
    }

    public List<RacerModel> getListOfRacers() {
        try (InputStream inputStream = readFiles("abbreviations.txt")) {
            return (new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines()
                    .map(line -> line.split("_"))
                    .map(str -> {
                        RacerModel racerModel = new RacerModel();
                        racerModel.setRacerAbbreviation(str[0]);
                        racerModel.setRacerName(str[1]);
                        racerModel.setRacerTeam(str[2]);
                        return racerModel;
                    }).collect(Collectors.toList()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TimeStartModel> getListOfStartTimes() {
        try (InputStream inputStream = readFiles("start.log")) {
            return (new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines()
                    .map(line -> line.split("_"))
                    .map(str -> {
                        TimeStartModel timeStartModel = new TimeStartModel();
                        timeStartModel.setRacerAbbreviation(str[0].substring(0, 3));
                        timeStartModel.setDateStart(str[0].substring(3));
                        timeStartModel.setTimeStart(str[1]);
                        return timeStartModel;
                    }).collect(Collectors.toList()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TimeEndModel> getListOfEndTimes() {
        try (InputStream inputStream = readFiles("end.log")) {
            return (new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines()
                    .map(line -> line.split("_"))
                    .map(str -> {
                        TimeEndModel timeEndModel = new TimeEndModel();
                        timeEndModel.setRacerAbbreviation(str[0].substring(0, 3));
                        timeEndModel.setDateEnd(str[0].substring(3));
                        timeEndModel.setTimeEnd(str[1]);
                        return timeEndModel;
                    }).collect(Collectors.toList()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
