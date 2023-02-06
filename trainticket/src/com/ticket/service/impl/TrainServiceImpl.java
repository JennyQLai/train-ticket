package com.ticket.service.impl;

import com.ticket.dao.TrainDao;
import com.ticket.dao.impl.TrainDaoImpl;
import com.ticket.pojo.Page;
import com.ticket.pojo.Train;
import com.ticket.service.TrainService;

import java.util.List;

public class TrainServiceImpl implements TrainService {

    private TrainDao trainDao=new TrainDaoImpl();

    @Override
    public void addTrain(Train train) {
        trainDao.addTrain(train);
    }

    @Override
    public void deleteTrainById(Integer id) {
        trainDao.deleteTrainById(id);
    }

    @Override
    public void updateTrain(Train train) {
        trainDao.updateTrain(train);
    }

    @Override
    public Train queryTrainById(Integer id) {
        return trainDao.queryTrainById(id);
    }

    @Override
    public List<Train> queryTrains() {
        return trainDao.queryTrains();
    }

    @Override
    public Page<Train> page(int pageNo, int pageSize) {
        Page<Train> page = new Page<Train>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = trainDao.queryForPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Train> items = trainDao.queryForPageItems(begin,pageSize);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }
}
