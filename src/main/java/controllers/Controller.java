package controllers;

import dao.DAO;
import services.Service;

import models.RacerModel;
import models.ResultModel;
import models.TimeEndModel;
import models.TimeStartModel;

import java.util.List;

public class Controller {

    public static void main(String[] args) {

        DAO dao = new DAO();
        List<RacerModel> racerModelList = dao.getListOfRacers();
        List<TimeStartModel> timeStartModelList = dao.getListOfStartTimes();
        List<TimeEndModel> timeEndModelList = dao.getListOfEndTimes();

        List<ResultModel> resultModelList = Service.getResultModel(racerModelList, timeStartModelList, timeEndModelList);
        System.out.println(resultModelList);
    }
}
