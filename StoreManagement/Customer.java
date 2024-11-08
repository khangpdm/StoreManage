package storeManagement;

public abstract class Customer{
    String _name;
    int _age;
    int _customerID;
    String _membershipType;
    double _discount;
    double _totalSpent;
    
    public Customer(){}

    public void Set(int customerID,String name, int age, String membershipType, double discount, double totalSpent){
        _customerID = customerID;
        _name = name;
        _age = age;
        _membershipType = membershipType;
        _discount = discount;
        _totalSpent = totalSpent;
    }

    public void SetAge(int value) {_age = value ;}
    public void SetName(int value) {_age = value ;}
    public void SetCustomerID(int value) {_age = value ;}
    public void SetMemberShip(int value) {_age = value ;}
    public void SetDiscount(int value) {_age = value ;}
    public void SetTotalSpent(int value) {_age = value ;}

    public void GetAge(){return _age;}
    public void GetName(){return _name;}
    public void GetCustomerID(){return _customerID;}
    public void GetMemberShip(){return _membershipType;}
    public void GetDiscount(){return _discount;}
    public void GetTotalSpent(){return _totalSpent;}

    public String toString(){
        String res = "";
        res = res + "CustomerID: " + _customerID + "\n";
        res = res + "Name: " + _name + "\n";
        res = res + "Age: " + _age + "\n";
        res = res + "Membership Type: " + _membershipType + "\n";
        res = res + "Discount: " + _discount + "\n";
        res = res + "Total spent: $" + _totalSpent + "\n";
        return res;
    }
}
class RegularCustomer extends Customer{
    public RegularCustomer(){}

    public double calFinalPrice(double orgPrice){
        return orgPrice * (1 - _discount / 100);
    }
}

class VIPCustomer extends Customer{
    public VIPCustomer(){
        _discount = 15%; //Giảm giá cho khác VIP 15%
    }

    public double calFinalPrice(double orgPrice){
        return orgPrice * (1 - _discount / 100);
    }
}

class StudentCustomer extends Customer{
    public StudentCustomer(){
        _discount = 10%; //Giảm giá cho khác VIP 15%
    }

    public double calFinalPrice(double orgPrice){
        return orgPrice * (1 - _discount / 100);
    }
}