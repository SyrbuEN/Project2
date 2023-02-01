package controllers;

import dao.Dao;
import models.RacerModel;
import models.ResultModel;
import models.TimeEndModel;
import models.TimeStartModel;
import services.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Controller {

    public static void main(String[] args) {

        Dao dao = new Dao();
        List<RacerModel> racerModelList = dao.getListOfRacers();
        List<TimeStartModel> timeStartModelList = dao.getListOfStartTimes();
        List<TimeEndModel> timeEndModelList = dao.getListOfEndTimes();

        Service service = new Service();
        List<ResultModel> resultModelList = service.getResultModel(racerModelList, timeStartModelList, timeEndModelList);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\resources\\file.txt"))) {
            resultModelList.stream()
                    .peek(h -> {
                        System.out.println(h);
                        try {
                            bufferedWriter.write(h.toString() + "\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        if (h.getNum() == 15) {
                            System.out.println("---------------------------------------------------------------------");
                            try {
                                bufferedWriter.write("---------------------------------------------------------------------" + "\n");
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    })
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
