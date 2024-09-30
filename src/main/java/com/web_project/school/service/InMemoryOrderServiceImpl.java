//package com.web_project.school.service;
//
//import com.web_project.school.model.OrderModel;
//import com.web_project.school.repository.OrderRepository;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class InMemoryOrderServiceImpl implements OrderService {
//    private final OrderRepository orderRepository;
//
//    public InMemoryOrderServiceImpl(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }
//
//    @Override
//    public List<OrderModel> findAllOrders(){
//        return orderRepository.findAll(Sort.by("id"));
//    }
//
//    @Override
//    public OrderModel findOrderById(Long id) {
//        return orderRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public OrderModel addOrder(OrderModel order){
//        return orderRepository.save(order);
//    }
//
//    @Override
//    public OrderModel updateOrder(OrderModel order){
//        if (orderRepository.existsById(order.getId())) {
//            return orderRepository.save(order);
//        }
//        return null;
//    }
//
//    @Override
//    public void deleteOrder(Long id){
//        if (orderRepository.existsById(id)) {
//            orderRepository.deleteById(id);
//        }
//    }
//
//}
