package com.ticket.dao;

import com.ticket.pojo.Train;

import java.util.List;

public interface TrainDao {
    public int addTrain(Train train);
    public int deleteTrainById(Integer id);
    public int updateTrain(Train train);
    public Train queryTrainById(Integer id);
    public List<Train> queryTrains();
    Integer queryForPageTotalCount();
    List<Train> queryForPageItems(int begin, int pageSize);
}
