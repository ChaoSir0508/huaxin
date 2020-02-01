package com.chao.huaxin.service;

import com.chao.huaxin.dao.SitesMapper;
import com.chao.huaxin.pojo.Sites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SitesServiceImpl implements SitesService {

    @Autowired
    private SitesMapper sitesMapper;


    @Override
    public List<Sites> getSites() {
        return sitesMapper.getSites();
    }

    @Override
    public List<Sites> getSitesAll() {
        return sitesMapper.getSitesAll();
    }

    @Override
    public Integer saveSites(String sites) {
        return sitesMapper.saveSites(sites);
    }

    @Override
    public Integer enabledSite(Integer id) {
        return sitesMapper.enabledSite(id);
    }

    @Override
    public Integer disabledSite(Integer id) {
        return sitesMapper.disabledSite(id);
    }

    @Override
    public Integer deleteSite(Integer id) {
        return sitesMapper.deleteSite(id);
    }
}
