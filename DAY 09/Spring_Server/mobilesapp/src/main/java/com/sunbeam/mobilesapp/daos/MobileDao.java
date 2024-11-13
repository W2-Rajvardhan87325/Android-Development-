package com.sunbeam.mobilesapp.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.mobilesapp.entities.Mobile;

public interface MobileDao extends JpaRepository<Mobile,Integer> {

}
