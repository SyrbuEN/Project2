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

public class DAO {

    public BufferedReader readFiles(String nameFile){
        ClassLoader classLoader = DAO.class.getClassLoader();

        try
                (InputStream inputStream = classLoader.getResourceAsStream(nameFile)) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            return bufferedReader;

        } catch (IOException e) {
            throw new RuntimeException(e);
    }

    }
    public List<RacerModel> getListOfRacers() {
//        BufferedReader bufferedReader = readFiles("abbreviations.txt");

        List<RacerModel> racerModels;

        ClassLoader classLoader = DAO.class.getClassLoader();
        try
                (InputStream inputStream = classLoader.getResourceAsStream("abbreviations.txt")) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            racerModels = bufferedReader.lines()
                    .map(line -> line.split("_"))
                    .map(str -> {
                        RacerModel racerModel = new RacerModel();
                        racerModel.setRacerAbbreviation(str[0]);
                        racerModel.setRacerName(str[1]);
                        racerModel.setRacerTeam(str[2]);
                        return racerModel;
                    }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return racerModels;
    }

    public List<TimeStartModel> getListOfStartTimes() {
        List<TimeStartModel> timeStartModels;

        ClassLoader classLoader = DAO.class.getClassLoader();
        try
                (InputStream inputStream = classLoader.getResourceAsStream("start.log")) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            timeStartModels = bufferedReader.lines()
                    .map(line -> line.split("_"))
                    .map(str -> {
                        TimeStartModel timeStartModel = new TimeStartModel();
                        timeStartModel.setRacerAbbreviation(str[0].substring(0,3));
                        timeStartModel.setDateStart(str[0].substring(3));
                        timeStartModel.setTimeStart(str[1]);
                        return timeStartModel;
                    }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return timeStartModels;
    }

    public List<TimeEndModel> getListOfEndTimes() {
        ClassLoader classLoader = DAO.class.getClassLoader();

        List<TimeEndModel> timeEndModels;
        try
                (InputStream inputStream = classLoader.getResourceAsStream("end.log")) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            timeEndModels = bufferedReader.lines()
                    .map(line -> line.split("_"))
                    .map(str -> {
                        TimeEndModel timeEndModel = new TimeEndModel();
                        timeEndModel.setRacerAbbreviation(str[0].substring(0,3));
                        timeEndModel.setDateEnd(str[0].substring(3));
                        timeEndModel.setTimeEnd(str[1]);
                        return timeEndModel;
                    }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return timeEndModels;
    }
}
