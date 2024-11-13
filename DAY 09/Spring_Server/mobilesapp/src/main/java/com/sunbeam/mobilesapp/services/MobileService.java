package com.sunbeam.mobilesapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.mobilesapp.daos.MobileDao;
import com.sunbeam.mobilesapp.dtos.MobileForm;
import com.sunbeam.mobilesapp.entities.Mobile;

@Transactional
@Service
public class MobileService {
    @Autowired
    private MobileDao mobileDao;

    public Mobile saveMobile(MobileForm mf) {
        Mobile m = new Mobile(0, mf.getName(), mf.getRam(), mf.getStorage(), mf.getCompany(), mf.getPrice(), mf.getImageFile().getOriginalFilename());
        return mobileDao.save(m);
    }

    public Mobile findMobileById(int id) {
        Optional<Mobile> om = mobileDao.findById(id);
        return om.isPresent() ? om.get() : null;
    }

    public List<Mobile> findAllMobiles() {
        return mobileDao.findAll();
    }
}
