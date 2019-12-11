package com.example.shopweb.controller;

import com.example.shopweb.domain.Order;
import com.example.shopweb.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListViewController {
    @Autowired
    OrdersService ordersService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView getOrderPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("orderList", ordersService.getOrderList());
        model.setViewName("order");
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addNewOrderPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("addNewOrder");
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewOrder(@RequestParam(value = "name") String name, @RequestParam(value = "price") int price) {
        Order order = new Order(name, price);
        ordersService.save(order);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteOrder(@PathVariable("id") int id) {
        Order order = ordersService.getById(id);
        if (order != null)
            ordersService.delete(order);
        return "redirect:/";
    }

    @RequestMapping(path = "/status/{id}", method = RequestMethod.POST)
    public boolean updateStatus(@PathVariable("id") int id){
        Order order = ordersService.getById(id);
        boolean status=order.isStatus();
        boolean newStatus=!status;
        order.setStatus(newStatus);
        return newStatus;
    }

}
