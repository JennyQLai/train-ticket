package com.ticket.service;

import com.ticket.pojo.Train;
import com.ticket.pojo.Page;

import java.util.List;

public interface TrainService {
    public void addTrain(Train train);
    public void deleteTrainById(Integer id);
    public void updateTrain(Train train);
    public Train queryTrainById(Integer id);
    public List<Train> queryTrains();
    public Page<Train> page(int pageNo, int pageSize);
}
