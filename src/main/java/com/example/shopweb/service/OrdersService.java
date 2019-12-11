package com.example.shopweb.service;

import com.example.shopweb.domain.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class OrdersService {
    private ArrayList<Order> orderList = new ArrayList<>();

    public OrdersService() {
        Order order = new Order("cucumber", 90, 0);
        Order order1 = new Order("apple", 100, 1);
        orderList.add(order);
        orderList.add(order1);
    }

    public void delete(Order order) {
        if (order != null)
            orderList.remove(order);
    }

    public void save(Order order) {
        if (order != null) {
            int id = order.getId();
            int size = orderList.size();
            if (id == 0 && size != 0) {
                order.setId(size + 1);
            }
            orderList.add(order);
        }

    }

    public Order getById(int id) {
        return orderList.get(id);
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }
}
