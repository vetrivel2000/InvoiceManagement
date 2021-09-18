import logical.LogicalLayer;
import pojo.Customer;
import pojo.Invoice;
import pojo.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class InvoiceRunner {
    static double totalPrice=0;
    public static void main(String[] args)
    {
        Scanner scan= new Scanner(System.in);
        LogicalLayer logical=new LogicalLayer();
        int option;
        ArrayList<Customer> customers= new ArrayList<>();
        ArrayList<Invoice> invoices=new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();
        do {
            System.out.println("1.AddCustomer\n2.AddInvoice\n3.AddItem\n4.PrintAllCustomers\n5.PrintAllInvoices\n6.InvoicesOfACustomer\n7.DetailsOfAnInvoice\n8.Exit");
            option=scan.nextInt();
            switch (option)
            {
                case 1:
                {
                    System.out.println("Enter name");
                    String name=scan.next();
                    System.out.println("Enter mobile");
                    String mobileNumber= scan.next();
                    System.out.println("Enter city");
                    String city=scan.next();
                    int customerId=logical.generateCustomerId();
                    System.out.println("Your customerId is"+customerId);
                    Customer object= logical.getCustomerObject(name,mobileNumber,city,customerId);
                    customers.add(object);
                    break;
                }
                case 2:
                {
                    System.out.println("Enter CustomerId");
                    int customerId= scan.nextInt();
                    System.out.println("Enter Item");
                    String itemName = scan.next();
                    System.out.println("Enter price");
                    double price= scan.nextDouble();
                    int invoiceId= logical.generateInvoiceId();
                    System.out.println("Your invoiceId is:"+invoiceId);
                    Item item=logical.getItemObject(itemName,price);
                    items.add(item);
                    totalPrice+=price;
                    Invoice invoice=logical.getInvoiceObject(customerId, items,totalPrice,invoiceId);
                    invoices.add(invoice);
                    logical.storeIntoMap(invoice);
                    break;
                }
                case 3:
                {
                    System.out.println("EnterCustomerId");
                    int customerId= scan.nextInt();
                    System.out.println("Enter invoiceId");
                    int invoiceId= scan.nextInt();
                    System.out.println("Enter Item");
                    String itemName = scan.next();
                    System.out.println("Enter price");
                    double price= scan.nextDouble();
                    Item item=logical.getItemObject(itemName,price);
                    items.add(item);
                    totalPrice+=price;
                    Invoice invoice=logical.getInvoiceObject(customerId, items,totalPrice,invoiceId);
                    invoices.add(invoice);
                    logical.storeIntoMap(invoice);
                    break;
                }
                case 4:
                {
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    break;
                }
                case 5:
                {
                    for (Invoice invoice : invoices) {
                        System.out.println(invoice);
                    }
                    break;
                }
                case 6:
                {
                    System.out.println("Enter your CustomerId");
                    int customerId=scan.nextInt();
                    HashMap<Integer,HashMap<Integer,Invoice>> customerMap= logical.getCustomerMap();
                    System.out.println(customerMap.get(customerId));
                    break;
                }
                case 7:
                {
                    System.out.println("Enter your InvoiceId");
                    int invoiceId= scan.nextInt();
                    HashMap<Integer,Invoice> invoiceMap=logical.getInvoiceMap();
                    System.out.println(invoiceMap.get(invoiceId));
                    break;
                }
            }
        }while (option<8);
    }
}
