package com.sunbeam.mobilesapp.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.mobilesapp.entities.Mobile;
import com.sunbeam.mobilesapp.entities.Order;

public interface OrderDao extends JpaRepository<Order,Integer> {
    @Query("SELECT m FROM User u JOIN u.orderList o JOIN o.mobile m WHERE u.id = ?1")
    List<Mobile> findOrderedMobiles(int userId);
}
