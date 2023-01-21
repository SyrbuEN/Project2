package dao;

import models.HumanModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class DAO {
    //ЗАДАНИЕ 1 - ПРЕОБРАЗУЕМ каждую строку файла в модель человека
    //1. нужно получить каждую строку из файла построчно
    //2. нужно понять что в файле описан каждый человек со своим именем, аббревиатурой, названием его команды
    //3. нужно создать модель этого человека с полями в классе именем, абр, командой
    //4. нужно разделить каждую строку на эти данные - имя, абр, команда
    //5. и положить имя, абр, команду в модели. Получится модель каждого человека

    public static List<HumanModel> method() { //рациональнее назвать его теперь getListOfHumans
        ClassLoader classLoader = DAO.class.getClassLoader();

        List<HumanModel> humanModels; //а что если мне надо этого хьюмана использовать еще где-то ниже по коду?
        try
                (InputStream inputStream = classLoader.getResourceAsStream("abbreviations.txt")) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // bufferedReader.readLine();
            //у BufferedReader есть метод, который может читать все строки из файла как поток.
            humanModels =
                    bufferedReader.lines() //здесь мы получили каждую строку из файла
                            .map(line -> line.split("_"))//здесь получаем разделение каждой строки по _,массив строк с подстроками
                            .map(str -> {   //если нужно произвести несколько действий над str то это пишем в {}
                                HumanModel humanModel = new HumanModel();
                                //[ [DRR] [Daniel Ricciardo] [RED BULL RACING TAG HEUER]
                                //[SVF] [Sebastian Vettel] [FERRARI] ]
                                //как получить у строки первую подстроку?
                                humanModel.setHumanAbbreviation(str[0]);
                                humanModel.setHumanName(str[1]);
                                humanModel.setHumanCar(str[2]);
                                System.out.println(humanModel);//ВНИМАНИЕ здесь распечатаются объекты по адресам в памяти.
                                // ибо не переопределен метод toString
                                return humanModel;
                            }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return humanModels;
    }

    //2. ЗАДАНИЕ 2 - Есть второй файл, где даны аббревиатуры те же и время.
    //НУЖНО ПО аббревиатуре из первого и второго файла вытащить время. (Т.е.найти человека из второго файла по аббревиатуре
    //из первого файла и вытащить время этого человека)
    //сформировать итоговый список с аббревиатурой, именем и временем.

    // получить из файла time.txt данные
    // распарсить эти данные в модель TimeInfo
    // сделать результирующую модель в которую будем заталкивать все резалт данные
//    public static List<TimeInfoModel> getTimeInfo() {
//        ClassLoader classLoader = Dao.class.getClassLoader();
//
//        List<TimeInfoModel> listOfTimesInfo;
//        try
//                (InputStream inputStream = classLoader.getResourceAsStream("time.txt")) {
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            listOfTimesInfo =
//                    bufferedReader.lines()
//                            .map(line -> line.split("_"))
//                            .map(str -> {
//                                TimeInfoModel timeInfoModel = new TimeInfoModel();
//                                timeInfoModel.setAbr(str[0]);
//                                timeInfoModel.setTime(str[1]);
//                                return timeInfoModel;
//                            }).collect(Collectors.toList());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return listOfTimesInfo;
//    }
}
