

public class program{
    public static void main(String[] args) {
        Ilogger logger = new logtodatabase();
        logger.log();

        Customer customer = new GoldCustomer(1, "shyam", "chauhan", "syam@123gmail.com");
        OrderService orderService = new OrderService(new ConsoleLogger());
        orderService.processOrder(customer);
        
    }

}

 interface Ilogger{
    void log();
}

 interface discountablecustomer{
    public int  getdiscountpercentage();
}

 class logtodatabase implements Ilogger{
  @Override
   public  void  log(){
        System.out.println("stored to database");
    }
}
class logtofile implements Ilogger{
   @Override
    public void log(){
        System.out.println("stored to file");
    }
}
    class ConsoleLogger implements Ilogger {
        @Override
        public void log(){
            System.out.println("Logging to console");
        }

    }



interface Icustomer
{
    
}

abstract class Customer implements Icustomer{
    protected int customerId;
    protected String firstName;
    protected String lastName;
    protected String email;

    public Customer(int customerId, String firstName, String lastName, String email) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    
    
}

}




class BronzeCustomer extends Customer implements discountablecustomer {
    public BronzeCustomer(int customerId, String firstName, String lastName, String email) {
        super(customerId, firstName, lastName, email);
    }
    @Override
    public int getdiscountpercentage() {
        return 15;
    }
}
class SilverCustomer extends Customer implements discountablecustomer {
    public SilverCustomer(int customerId, String firstName, String lastName, String email) {
        super(customerId, firstName, lastName, email);
    }

    @Override
    public int getdiscountpercentage() {
        return 20;
    }
}
class GoldCustomer extends Customer implements discountablecustomer {
    public GoldCustomer(int customerId, String firstName, String lastName, String email) {
        super(customerId, firstName, lastName, email);
    }

    @Override
    public int getdiscountpercentage() {
        return 25;
    }
}
class PlatinumCustomer extends Customer implements discountablecustomer {
    public PlatinumCustomer(int customerId, String firstName, String lastName, String email) {
        super(customerId, firstName, lastName, email);
    }

    @Override
    public int getdiscountpercentage() {
        return 27;
    }
}
class OrderService {
    private final Ilogger logger;

    public OrderService(Ilogger logger) {
        this.logger = logger;
    }

    public void processOrder(Customer customer) {
        try {
            if (customer instanceof discountablecustomer) {
                int discount = ((discountablecustomer) customer).getdiscountpercentage();
                System.out.println("Processing order for " + customer.firstName + " with discount: " + discount + "%");
            } else {
                System.out.println("Processing order for " + customer.firstName + " with no discount.");
            }
            logger.log();
        } catch (Exception e) {
            System.out.println("An error occurred while processing the order.");
            logger.log();
    }
}

}

