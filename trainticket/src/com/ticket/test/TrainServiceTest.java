package com.ticket.test;

import com.ticket.pojo.Train;
import com.ticket.pojo.Page;
import com.ticket.service.TrainService;
import com.ticket.service.impl.TrainServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class TrainServiceTest {

    private TrainService trainService=new TrainServiceImpl();

    @Test
    public void addTrain() {
        trainService.addTrain(new Train(null,"G7386",new BigDecimal(194.5),"沈阳-周口","6月18日12:00-20:45"));
    }

    @Test
    public void deleteTrainById() {
        trainService.deleteTrainById(8);
    }

    @Test
    public void updateTrain() {
        trainService.updateTrain(new Train(10,"G7594",new BigDecimal(234.5),"西安-重庆","6月18日11:00-18:45"));
    }

    @Test
    public void queryTrainById() {
        System.out.println(trainService.queryTrainById(2));
    }

    @Test
    public void queryTrains() {
        for (Train queryTrain : trainService.queryTrains()) {
            System.out.println(queryTrain);
        }
    }

    @Test
    public void page(){
        System.out.println(trainService.page(0, Page.PAGE_SIZE ));
    }

   /* @Test
    public void pageByPrice(){
        System.out.println(trainService.pageByPrice(1, Page.PAGE_SIZE,10,50 ));
    }*/
}