package com.sunbeam.mobilesapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.mobilesapp.daos.MobileDao;
import com.sunbeam.mobilesapp.daos.OrderDao;
import com.sunbeam.mobilesapp.daos.UserDao;
import com.sunbeam.mobilesapp.entities.Mobile;
import com.sunbeam.mobilesapp.entities.Order;
import com.sunbeam.mobilesapp.entities.User;

@Transactional
@Service
public class OrderService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private MobileDao mobileDao;

    public Order placeOrder(int userId, int mobileId) {
        Optional<User> ou = userDao.findById(userId);
        Optional<Mobile> om = mobileDao.findById(mobileId);
        User u = ou.get();
        Mobile m = om.get();
        Order o = new Order(0, u, m);
        Order dbo = orderDao.save(o);
        return dbo;
    }

    /*
    public List<Mobile> getOrderedMobiles(int userId) {
        List<Mobile> list = new ArrayList<>();
        Optional<User> ou = userDao.findById(userId);
        if(ou.isPresent()) {
            User u = ou.get();
            List<Order> orderList = u.getOrderList();
            for (Order order : orderList)
                list.add(order.getMobile());
        }
        return list;
    }
    */
    public List<Mobile> getOrderedMobiles(int userId) {
        List<Mobile> list = orderDao.findOrderedMobiles(userId);
        return list;
    }
}
