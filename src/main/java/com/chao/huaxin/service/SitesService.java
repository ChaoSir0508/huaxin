package com.chao.huaxin.service;

import com.chao.huaxin.pojo.Sites;

import java.util.List;

public interface SitesService {

    List<Sites> getSites();

    List<Sites> getSitesAll();

    Integer saveSites(String sites);

    Integer enabledSite(Integer id);

    Integer disabledSite(Integer id);

    Integer deleteSite(Integer id);

}
