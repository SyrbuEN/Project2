package services;

import models.RacerModel;
import models.ResultModel;
import models.TimeEndModel;
import models.TimeStartModel;

import java.util.List;

public class Service {

    public String getDateStart(ResultModel racerResult, List<TimeStartModel> timeStartModelList){
        return timeStartModelList.stream().filter(t -> t.getRacerAbbreviation().equals(racerResult.getRacerAbbreviation()))
                .findAny().orElse(null).getDateStart();
    }

    public String getTimeStart(ResultModel racerResult, List<TimeStartModel> timeStartModelList){
        return timeStartModelList.stream().filter(t -> t.getRacerAbbreviation().equals(racerResult.getRacerAbbreviation()))
                .findAny().orElse(null).getTimeStart();
    }

    public String getDateEnd(ResultModel racerResult, List<TimeEndModel> timeEndModelList){
        return timeEndModelList.stream().filter(t -> t.getRacerAbbreviation().equals(racerResult.getRacerAbbreviation()))
                .findAny().orElse(null).getDateEnd();
    }

    public String getTimeEnd(ResultModel racerResult, List<TimeEndModel> timeEndModelList){
        return timeEndModelList.stream().filter(t -> t.getRacerAbbreviation().equals(racerResult.getRacerAbbreviation()))
                .findAny().orElse(null).getTimeEnd();
    }

    public List<ResultModel> getResultModel(List<RacerModel> racerModelList, List<TimeStartModel> timeStartModelList, List<TimeEndModel> timeEndModelList){
        List<ResultModel> resultModels = racerModelList.stream().map(h ->
                {
                    ResultModel resultModel = new ResultModel();
                    resultModel.setRacerAbbreviation(h.getRacerAbbreviation());
                    resultModel.setRacerName(h.getRacerName());
                    resultModel.setRacerTeam(h.getRacerTeam());

                    return resultModel;
                })
                .peek(h-> {
                    String dateStart = getDateStart(h, timeStartModelList);
                    String timeStart = getTimeStart(h, timeStartModelList);
                    h.setTimeStartResult(dateStart, timeStart);

                    String dateEnd = getDateEnd(h, timeEndModelList);
                    String timeEnd = getTimeEnd(h, timeEndModelList);
                    h.setTimeEndResult(dateEnd, timeEnd);

                    h.setTime();
                })
                .sorted((o1, o2)->o1.getTime().compareTo(o2.getTime()))
                .toList();

        return resultModels;
    }
}
