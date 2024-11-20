package storeManagement;

import java.util.*;

public class Bill {
    Customer _customer;
    List<Product> _products;
    Employee _membershipType;
    double _totalSpent;

    public Bill() {
        _products = new ArrayList<>();
    }

    public Bill(Customer customer, Employee membershipType) {
        _customer = customer;
        _membershipType = membershipType;
        _products = new ArrayList<>();
    }

    public void SetCustomer(Customer customer) { _customer = customer; }
    public void SetMemberShip(Employee membershipType) { _membershipType = membershipType; }
    public void addProduct(Product product) { _products.add(product); }

    public Customer GetCustomer() { return _customer; }
    public Employee GetMemberShip() { return _membershipType; }
    public List<Product> getProducts() { return _products; }
    public double GetTotalSpent() { return _totalSpent; }

    public void calculateTotalPayment() {
        _totalSpent = 0;
        for (Product product : _products) {
            _totalSpent += product.getPrice();
        }
        _totalSpent = _customer.calFinalPrice(_totalSpent);
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Customer Information:\n");
        res.append(_customer.toString()).append("\n");

        res.append("Products Purchased:\n");
        for (Product product : _products) {
            res.append(product.toString()).append("\n");
        }

        res.append("Delivery Person Information:\n");
        res.append(_membershipType.toString()).append("\n");

        calculateTotalPayment();
        res.append("Total Payment: $").append(_totalSpent).append("\n");

        return res.toString();
    }
}
