package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManagement implements Serializable {


   private static final long serialVersionUID = -7226972858281959175L;
   private Map<String, List<OrderBackend>> orders;
   private int numberOfOrders;

   public OrderManagement (){
      this.orders = new HashMap<>();
   }

   public Map<String, List<OrderBackend>> getOrders() {
      return orders;
   }

   public void setOrders(Map<String, List<OrderBackend>> orders) {
      this.orders = orders;
   }


   public int getNumberOfOrders() {
      return numberOfOrders;
   }

   public void setNumberOfOrders(int numberOfOrders) {
      this.numberOfOrders = numberOfOrders;
   }
}
