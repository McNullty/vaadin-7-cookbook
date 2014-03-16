package com.analemma.vaadin_spring_database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analemma.vaadin_spring_database.dao.OrderDAO;
import com.analemma.vaadin_spring_database.model.Order;

import java.util.List;

/**
 * @author Ondrej Kvasnovsky
 */
@Service
public class OrderService {

  @Autowired
  private OrderDAO orderDAO;

  public List<Order> findAll() {
    List<Order> res = orderDAO.findAll();
    return res;
  }
}
