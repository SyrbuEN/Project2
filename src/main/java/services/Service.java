package services;

import models.RacerModel;
import models.ResultModel;
import models.TimeEndModel;
import models.TimeStartModel;

import java.time.Instant;
import java.util.List;

public class Service {

//    public static String getDateStart(ResultModel racerResult){
//        return timeStartModelList.stream().filter(t -> t.getRacerAbbreviation().equals(racerResult.getRacerAbbreviation()))
//                .findAny().orElse(null).getDateStart();
//    }
//
//    public static String getTimeStart(ResultModel racerResult){
//        return timeStartModelList.stream().filter(t -> t.getRacerAbbreviation().equals(racerResult.getRacerAbbreviation()))
//                .findAny().orElse(null).getTimeStart();
//    }
//
//    public static String getDateEnd(ResultModel racerResult){
//        return timeEndModelList.stream().filter(t -> t.getRacerAbbreviation().equals(racerResult.getRacerAbbreviation()))
//                .findAny().orElse(null).getDateEnd();
//    }
//
//    public static String getTimeEnd(ResultModel racerResult){
//        return timeEndModelList.stream().filter(t -> t.getRacerAbbreviation().equals(racerResult.getRacerAbbreviation()))
//                .findAny().orElse(null).getTimeEnd();
//    }

    public static List<ResultModel> getResultModel(List<RacerModel> racerModelList, List<TimeStartModel> timeStartModelList, List<TimeEndModel> timeEndModelList){
        List<ResultModel> resultModels = racerModelList.stream().map(h ->
                {
                    ResultModel resultModel = new ResultModel();
                    resultModel.setRacerAbbreviation(h.getRacerAbbreviation());
                    resultModel.setRacerName(h.getRacerName());
                    resultModel.setRacerTeam(h.getRacerTeam());

                    String dateStart = timeStartModelList.stream().filter(t -> t.getRacerAbbreviation().equals(h.getRacerAbbreviation())).findAny().orElse(null).getDateStart();
                    String timeStart = timeStartModelList.stream().filter(t -> t.getRacerAbbreviation().equals(h.getRacerAbbreviation())).findAny().orElse(null).getTimeStart();
                    Instant start = Instant.parse(dateStart + "T" + timeStart + "Z");

                    String dateEnd = timeEndModelList.stream().filter(t -> t.getRacerAbbreviation().equals(h.getRacerAbbreviation())).findAny().orElse(null).getDateEnd();
                    String timeEnd = timeEndModelList.stream().filter(t -> t.getRacerAbbreviation().equals(h.getRacerAbbreviation())).findAny().orElse(null).getTimeEnd();
                    Instant end = Instant.parse(dateEnd + "T" +  timeEnd + "Z");

                    resultModel.setTime(start, end);
                    return resultModel;
                })
                .sorted((o1, o2)->o1.getTime().compareTo(o2.getTime()))
//                .peek(System.out::println)
                .toList();

        return resultModels;
    }
}
