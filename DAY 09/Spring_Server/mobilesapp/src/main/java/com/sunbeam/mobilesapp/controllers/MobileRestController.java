package com.sunbeam.mobilesapp.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.mobilesapp.dtos.MobileForm;
import com.sunbeam.mobilesapp.dtos.NewOrder;
import com.sunbeam.mobilesapp.dtos.ShopResult;
import com.sunbeam.mobilesapp.entities.Mobile;
import com.sunbeam.mobilesapp.entities.Order;
import com.sunbeam.mobilesapp.services.MobileService;
import com.sunbeam.mobilesapp.services.OrderService;

@RestController
public class MobileRestController {
    @Value("${images.dirPath}")
    private String imagesDirPath = "/tmp/";
    @Autowired
    private MobileService mobileService;
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/mobiles", consumes = "multipart/form-data")
    public ShopResult<?> postMobile(@ModelAttribute MobileForm mf) throws IOException {
        File destFile = new File(imagesDirPath + mf.getImageFile().getOriginalFilename());
        mf.getImageFile().transferTo(destFile);
        Mobile m = mobileService.saveMobile(mf);
        return ShopResult.success(m);
    }

    @GetMapping("/images/{image}")
    public void getMobileImage(@PathVariable("image") String imageName, HttpServletResponse resp) throws IOException {
        resp.setContentType("image/jpeg");
        try (InputStream in = new FileInputStream(imagesDirPath + imageName)) {
            FileCopyUtils.copy(in, resp.getOutputStream());
        }
    }

    @GetMapping("/mobiles/{id}")
    public ShopResult<?> getMobileById(@PathVariable("id") int mobileId) {
        Mobile m = mobileService.findMobileById(mobileId);
        return ShopResult.success(m);
    }

    @GetMapping("/mobiles")
    public ShopResult<?> getAllMobiles() {
        List<Mobile> list = mobileService.findAllMobiles();
        return ShopResult.success(list);
    }

    @PostMapping("/orders")
    public ShopResult<?> postNewOrder(@RequestBody NewOrder order) {
        Order dbOrder = orderService.placeOrder(order.getUserId(), order.getMobileId());
        return ShopResult.success(dbOrder);
    }

    @GetMapping("/orders/user/{id}")
    public ShopResult<?> getUserOrderedMobiles(@PathVariable("id") int userId) {
        List<Mobile> list = orderService.getOrderedMobiles(userId);
        return ShopResult.success(list);
    }
}
