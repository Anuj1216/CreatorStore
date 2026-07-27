//package com.anuj.creatorstore.services;
//
//import com.anuj.creatorstore.dtos.OrderItemRequest;
//import com.anuj.creatorstore.dtos.OrderRequest;
//import com.anuj.creatorstore.entities.Order;
//import com.anuj.creatorstore.entities.OrderItem;
//import com.anuj.creatorstore.entities.Product;
//import com.anuj.creatorstore.repositories.OrderRepository;
//import com.anuj.creatorstore.repositories.ProductRepository;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class OrderService {
//    private final OrderRepository orderRepository;
//    private final ProductRepository productRepository;
//
//    @Transactional
//    public Order createOrder(OrderRequest orderRequest) {
//
//        List<OrderItem> orderItems = new ArrayList<>();
//
//        BigDecimal totalPrice = BigDecimal.ZERO;
//
//        Order order = new Order();
//        order.setCustomerName(orderRequest.getCustomerName());
//        order.setCustomerEmail(orderRequest.getCustomerEmail());
//        order.setStatus("CONFIRMED");
//
//        for(OrderItemRequest itemRequest: orderRequest.getItems()){
//            Product product = productRepository.findById(itemRequest.getProductId()
//            ).orElseThrow(() -> new RuntimeException("Product not found with id:" +  itemRequest.getProductId()));
//
//            //Check product Stock
//            if(product.getStockQuantity() < itemRequest.getQuantity()){
//                throw new RuntimeException("Not enough stock for this product");
//            }
//
//            //Calculate total price
//            BigDecimal priceOfItem = product.getPrice().multiply(BigDecimal.valueOf(itemRequest.getQuantity()));
//
//            totalPrice = totalPrice.add(priceOfItem);
//
//            //Update the latest stock quantity
//            product.setStockQuantity(
//                    product.getStockQuantity() - itemRequest.getQuantity()
//            );
//
//            productRepository.save(product);
//
//            //Builder pattern to make obj
//            OrderItem orderItem = OrderItem.builder()
//                    .order(order)
//                    .product(product)
//                    .quantity(itemRequest.getQuantity())
//                    .priceAtPurchase(product.getPrice())
//                    .build();
//
//            orderItems.add(orderItem);
//
//        }
//
//        order.setOrderItems(orderItems);
//        order.setTotalPrice(totalPrice);
//
//        return orderRepository.save(order);
//    }
//
//    public List<Order> getAllOrders() {
//        return orderRepository.findAll();
//    }
//
//    public Order getOrderById(Long orderId) {
//        return orderRepository.findById(orderId)
//                .orElseThrow(() -> new RuntimeException("Order not found with id:" +  orderId));
//    }
//}
