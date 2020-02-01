package com.chao.huaxin.service;

import com.chao.huaxin.dao.TimesMapper;
import com.chao.huaxin.pojo.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimesServiceImpl implements TimesService {

    @Autowired
    private TimesMapper timesMapper;

    @Override
    public List<Times> getTimes() {
        return timesMapper.getTimes();
    }

    @Override
    public List<Times> getTimesAll() {
        return timesMapper.getTimesAll();
    }

    @Override
    public Integer saveTimes(String times) {
        return timesMapper.saveTimes(times);
    }

    @Override
    public Integer enabledTimes(Integer time) {
        return timesMapper.enabledTimes(time);
    }

    @Override
    public Integer disabledTimes(Integer time) {
        return timesMapper.disabledTimes(time);
    }

    @Override
    public Integer deleteTimes(Integer id) {
        return timesMapper.deleteTimes(id);
    }

}
