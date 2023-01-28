package controllers;

import dao.DAO;
import services.Service;

import models.RacerModel;
import models.ResultModel;
import models.TimeEndModel;
import models.TimeStartModel;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    public static void main(String[] args) {

        DAO dao = new DAO();
        List<RacerModel> racerModelList = dao.getListOfRacers();
        List<TimeStartModel> timeStartModelList = dao.getListOfStartTimes();
        List<TimeEndModel> timeEndModelList = dao.getListOfEndTimes();

        Service service = new Service();
        List<ResultModel> resultModelList = service.getResultModel(racerModelList, timeStartModelList, timeEndModelList);

        int num = 0;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\resources\\file.txt"))) {
            for (ResultModel element : resultModelList) {
                System.out.println(++num + ". " + element);
                bufferedWriter.write(num + ". " + element + "\n");
                if (num == 15){
                    System.out.println("---------------------------------------------------------------------");
                    bufferedWriter.write("---------------------------------------------------------------------" + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
