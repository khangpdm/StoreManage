package storeManagement;

import java.util.*;

public class Shop {
    private Vector<Product> productList = new Vector<Product>();
    private Vector<Customer> customerList = new Vector<Customer>();
    private Vector<Employee> _employeeList = new Vector<Employee>();
    
    public Shop() {}

    public Vector<Product> GetProductList() {
        return productList;
    }

    public Vector<Customer> GetCustomerList() {
        return customerList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }
}