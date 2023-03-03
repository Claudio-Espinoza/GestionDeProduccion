package ufro.dci.gestionapp.service;

import org.springframework.stereotype.Service;
import ufro.dci.gestionapp.model.shooper.Order;
import ufro.dci.gestionapp.model.shooper.Shooper;
import ufro.dci.gestionapp.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    final private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrderObject(int cost, String name,String typePaid, int sizePizza, int sizeBread, int sizeDrink, Shooper shooper) {
        Order order = new Order( name,cost, typePaid , generateDate() ,sizePizza, sizeDrink, sizeBread, shooper);
        saveOrder(order);
    }

    private void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public int calculateCost(int pizzaCost, int drinkCost, int breadCost) {
        System.out.println("Costo \"----------------------------------------------------\"" +  pizzaCost+ drinkCost+ breadCost );
        return pizzaCost+ drinkCost+ breadCost;

    }

    public LocalDateTime generateDate() {
        return LocalDateTime.now();
    }


    public List<Order> getListOfOrder(){
        return orderRepository.findAll();
    }
}
