package storeManagement;
interface Employee{
    String GetType();
    String GetName();
    int GetHourlyPayment();
    int GetTotalHours();
    //Setter
    void setData();
    //Methods
    void CalculateTotal();
    int GetTotal();
    String toString();
}

class SalesPerson implements Employee{
    private String _type = "SalesPerson";
    private String _name;
    private int _hourlyPayment;
    private int _totalHours;
    private int _total;

    //Constructor
    public SalesPerson() {}
    //Getter
    public String GetType()  { return _type; }
    public String GetName() { return _name; }
    public int GetHourlyPayment() { return _hourlyPayment; }
    public int GetTotalHours() { return _totalHours; }
    //Setter
    public void setData(String name, int hourlyPayment, int totalHours){
        _name = name;
        _hourlyPayment = hourlyPayment;
        _totalHours = totalHours;
    }
    //Methods
    public void CalculateTotal(){
        _total = _hourlyPayment * _totalHours;
    }
    public int GetTotal() { return _total; }
    public String toString(){
        String res = "";
        res = res + _type + ":" + _name + "\n";
        res = res + "\tSalary per hour: " + _hourlyPayment + "\n";
        res = res + "Working hours: " + _totalHours + "\n";
        return res;
    }

    class Manager implements Employee{
        private String _type = 'Manager';
        private String _name;
        private int _hourlyPayment;
        private int _totalHours;
        private int _total;

        //Constructor
        public Manager(){}
        //Getter
        public String GetType() { return _type; }
        public String GetName() { return _name; }
        public int GetHourlyPayment() { return _hourlyPayment; }
        public int GetTotalHours() { return _totalHours; }
        //Setter
        public void setData(String name, int hourlyPayment, int totalHours){
            _name = name;
            _hourlyPayment = hourlyPayment;
            _totalHours = totalHours;
        }
        //Methods
        public void CalculateTotal(){
            _total = _hourlyPayment * _totalHours;
        }
        public int GetTotal() { return _total; }
        public String toString(){
            String res = "";
            res = res + _type + ":" + _name + "\n";
            res = res + "\tSalary per hour: " + _hourlyPayment + "\n";
            res = res + "Working hours: " + _totalHours + "\n";
            return res;
        }

        class Guard implements Employee{
            private String _type = 'Guard';
            private String _name;
            private int _hourlyPayment;
            private int _totalHours;
            private int _total;

            //Contructor
            public Guard(){}
            //Getter
            public String GetType(){ return _type; }
            public String GetName(){ return _name; }
            public int GetHourlyPayment() { return _hourlyPayment; }
            public int GetTotalHours() { return _totalHours; }
            //Setter
            public void setData(String name, int hourlyPayment, int totalHours){
                _name = name;
                _hourlyPayment = hourlyPayment;
                _totalHours = totalHours;
            }
            //Methods
            public void CalculateTotal(){
                _total = _totalHours * _hourlyPayment;
            }
            public int GetTotal(){ return _total; }
            public String toString(){
                String res = "";
                res = res + _type + ":" + _name + "\n";
                res = res + "\tSalary per hour: " + _hourlyPayment + "\n";
                res = res + "\tWorking hours: " + _totalHours + "\n";
                return res;
            }
            class Cashier implements Employee{
                private String _type = 'Cashier';
                private String _name;
                private int _hourlyPayment;
                private int _totalHours;
                private int _total;
    
                //Contructor
                public Cashier(){}
                //Getter
                public String GetType(){ return _type; }
                public String GetName(){ return _name; }
                public int GetHourlyPayment() { return _hourlyPayment; }
                public int GetTotalHours() { return _totalHours; }
                //Setter
                public void setData(String name, int hourlyPayment, int totalHours){
                    _name = name;
                    _hourlyPayment = hourlyPayment;
                    _totalHours = totalHours;
                }
                //Methods
                public void CalculateTotal(){
                    _total = _totalHours * _hourlyPayment;
                }
                public int GetTotal(){ return _total; }
                public String toString(){
                    String res = "";
                    res = res + _type + ":" + _name + "\n";
                    res = res + "\tSalary per hour: " + _hourlyPayment + "\n";
                    res = res + "\tWorking hours: " + _totalHours + "\n";
                    return res;
                }
        }
    }
}