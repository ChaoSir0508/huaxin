package com.chao.huaxin.service;

import com.chao.huaxin.pojo.Times;

import java.util.List;

public interface TimesService {


    List<Times> getTimes();


    List<Times> getTimesAll();

    Integer saveTimes(String times);

    Integer enabledTimes(Integer time);

    Integer disabledTimes(Integer time);

    Integer deleteTimes(Integer id);

}
