package com.ticket.test;

import com.ticket.dao.TrainDao;
import com.ticket.dao.impl.TrainDaoImpl;
import com.ticket.pojo.Page;
import com.ticket.pojo.Train;
import org.junit.Test;

import java.math.BigDecimal;

public class TrainDaoTest {
    private TrainDao trainDao=new TrainDaoImpl();

    @Test
    public void addTrain() {
        trainDao.addTrain(new Train(null,"G7319",new BigDecimal(272.5),"北京南-枣庄","6月9日12:00-20:45"));
    }

    @Test
    public void deleteTrainById() {
        trainDao.deleteTrainById(7);
    }

    @Test
    public void updateTrain() {
        trainDao.updateTrain(new Train(9,"G7319",new BigDecimal(278.5),"北京南-徐州东","6月9日12:00-20:45"));
    }

    @Test
    public void queryTrainById() {
        System.out.println(trainDao.queryTrainById(2));
    }

    @Test
    public void queryTrains() {
        for(Train queryTrain:trainDao.queryTrains()){
            System.out.println(queryTrain);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println( trainDao.queryForPageTotalCount() );
    }

    @Test
    public void queryForPageItems() {
        for (Train book : trainDao.queryForPageItems(0, Page.PAGE_SIZE)) {
            System.out.println(book);
            /*System.out.println("???????");*/
        }
    }
}