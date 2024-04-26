package com.example.orderapi.entity;
import com.example.orderapi.entity.Customer;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders") // Specify the table name here
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private int customerId;

    private String customerName;

    private int productId;

    private float amount;

    private Date orderDate;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", productId=" + productId +
                ", amount=" + amount +
                ", orderDate=" + orderDate +
                '}';
    }
}
