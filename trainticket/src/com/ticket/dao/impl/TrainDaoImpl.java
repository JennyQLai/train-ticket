package com.ticket.dao.impl;

import com.ticket.dao.TrainDao;
import com.ticket.pojo.Train;

import java.util.List;

public class TrainDaoImpl extends BaseDao implements TrainDao {
    @Override
    public int addTrain(Train train) {
        String sql = "INSERT INTO t_train(`number`,`price`,`terminal`,`time`) values (?,?,?,?)";
        return update(sql, train.getNumber(), train.getPrice(), train.getTerminal(), train.getTime());
    }

    @Override
    public int deleteTrainById(Integer id) {
        String sql = "delete from t_train where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateTrain(Train train) {
        String sql = "update t_train set `number`=?,`price`=?,`terminal`=?,`time`=? where id=?";
        return update(sql, train.getNumber(), train.getPrice(), train.getTerminal(), train.getTime(),train.getId());
    }

    @Override
    public Train queryTrainById(Integer id) {
        String sql = "select `id`,`number`,`price`,`terminal`,`time` from t_train where id=?";
        return queryForOne(Train.class,sql,id);
    }

    @Override
    public List<Train> queryTrains() {
        String sql = "select `id`,`number`,`price`,`terminal`,`time` from t_train";
        return queryForList(Train.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_train";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Train> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`,`number`,`price`,`terminal`,`time` from t_train limit ?,?";
        return queryForList(Train.class,sql,begin,pageSize);
    }
}
