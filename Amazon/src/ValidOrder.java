import java.util.*;

/**
 * Created by chiko on 1/20/2017.
 */

public class ValidOrder {
    static class Order{
        String order;
    }

    static class OrderDependencies{
        Order order;
        Order dependency;
    }


    public static ArrayList<Order> validOrder(ArrayList<OrderDependencies> orderDependencies){
        Map<Order, ArrayList<Order>> orderMap = new LinkedHashMap<>();

        for(OrderDependencies dependencies: orderDependencies){
            if(!orderMap.containsKey(dependencies.dependency)){
                ArrayList<Order> orderList = new ArrayList<>();
                orderList.add(dependencies.order);
                orderMap.put(dependencies.dependency, orderList);
            }else{
                ArrayList<Order> orderList;
                orderList = orderMap.get(dependencies.dependency);
                orderList.add(dependencies.order);
                orderMap.put(dependencies.dependency, orderList);
            }
        }

        Stack<Order> stack = new Stack<>();
        Set<Order> hs = new HashSet<Order>();
        for(Map.Entry<Order, ArrayList<Order>> entry: orderMap.entrySet()){
            if(!hs.contains(entry.getKey()))
                validOrderUtil(entry.getKey(), stack, orderMap, hs);
        }

        ArrayList<Order> resultList = new ArrayList<Order>();

        while (!stack.isEmpty()){
            resultList.add(stack.pop());
        }

        return resultList;
    }


    public static void validOrderUtil(Order dep, Stack<Order> stack, Map<Order, ArrayList<Order>> orderMap, Set<Order> hs){
        hs.add(dep);
        if(orderMap.containsKey(dep)) {
            ArrayList<Order> ordList = orderMap.get(dep);
            for (Order ord : ordList) {
                if (!hs.contains(ord))
                    validOrderUtil(ord, stack, orderMap, hs);
            }
        }
        stack.push(dep);
    }

    public static void main(String[] args) {
        Order uttappa = new Order();
        uttappa.order = "uttappa";
        Order tava = new Order();
        tava.order = "tava";
        Order rava = new Order();
        rava.order = "rava";
        OrderDependencies orderDependencies1 = new OrderDependencies();
        OrderDependencies orderDependencies2 = new OrderDependencies();
        orderDependencies1.order = uttappa;
        orderDependencies1.dependency = rava;
        orderDependencies2.order = rava;
        orderDependencies2.dependency = tava;
        ArrayList<OrderDependencies> dep = new ArrayList<>();

        dep.add(orderDependencies2);
        dep.add(orderDependencies1);

        for(Order ord : validOrder(dep)){
            System.out.print(ord.order+" ");
        }
    }

}



