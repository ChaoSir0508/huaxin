package com.chao.huaxin.dao;

import com.chao.huaxin.pojo.Times;
import org.apache.ibatis.annotations.Mapper;

import java.security.SecureRandom;
import java.sql.Time;
import java.util.List;

@Mapper
public interface TimesMapper {

    List<Times> getTimes();


    List<Times> getTimesAll();

    Integer saveTimes(String  times);

    Integer enabledTimes(Integer time);

    Integer disabledTimes(Integer time);

    Integer deleteTimes(Integer id);

}
