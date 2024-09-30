package com.web_project.school.service.impl;

import com.web_project.school.model.OrderModel;
import com.web_project.school.repository.OrderRepository; // Убедитесь, что этот репозиторий существует.
import com.web_project.school.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends GenericServiceImpl<OrderModel> implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        super(orderRepository);
        this.orderRepository = orderRepository;
    }
}