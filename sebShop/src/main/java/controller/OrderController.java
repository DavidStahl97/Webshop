package controller;

import model.Order;
import model.OrderBackend;
import model.OrderManagement;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderController {

    private OrderManagement orderManagement;


    public OrderController (){
       // this.orderManagement = new OrderManagement();
        readFromFile();
    }

    public int saveOrders (Order order){
        List<OrderBackend> userOrders;
        if (orderManagement.getOrders().keySet().contains(order.getUser())){
            userOrders= orderManagement.getOrders().get(order.getUser());
        }
        else {
            userOrders= new ArrayList<>();
        }
        OrderBackend orderBackend = convertOrderToBackendOrder(order);
        userOrders.add(orderBackend);
        orderManagement.getOrders().put(order.getUser(), userOrders);

        saveToFile();
        return orderBackend.getOrderNo();
    }

    public List<OrderBackend> getUserOrders(String username){
        return orderManagement.getOrders().get(username);
    }

    private void saveToFile  (){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
            mapper.writeValue(new File(System.getProperty("user.dir") + "/src/main/resources/" + "orders.json"), orderManagement);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile  (){
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
        try {
            File file = new File(System.getProperty("user.dir") + "/src/main/resources/" + "orders.json");
            System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
            this.orderManagement = mapper.readValue(file, OrderManagement.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private OrderBackend convertOrderToBackendOrder(Order order){
        OrderBackend orderBackend = new OrderBackend();
        orderBackend.setUser(order.getUser());
        orderBackend.setArticles(order.getArticles());
        orderBackend.setDate(order.getDate());
        orderBackend.setTotalprice(order.getTotalprice());
        orderManagement.setNumberOfOrders(orderManagement.getNumberOfOrders()+1);
        orderBackend.setOrderNo(orderManagement.getNumberOfOrders());
        return orderBackend;
    }


}
