package com.chao.huaxin.dao;

import com.chao.huaxin.pojo.Sites;
import org.apache.ibatis.annotations.Mapper;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

@Mapper
public interface SitesMapper {
    List<Sites> getSites();

    List<Sites> getSitesAll();

    Integer saveSites(String sites);

    Integer enabledSite(Integer id);

    Integer disabledSite(Integer id);

    Integer deleteSite(Integer id);



}
