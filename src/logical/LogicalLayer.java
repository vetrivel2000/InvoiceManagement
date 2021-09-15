package logical;

import load.LoadToMemory;
import pojo.Customer;
import pojo.Invoice;

import java.util.ArrayList;
import java.util.HashMap;

public class LogicalLayer {
    static int customerId =0;
    static int invoiceId=0;
    LoadToMemory load = new LoadToMemory();
    public Customer getCustomerObject(String name,String mobileNumber,String city,int customerId)
    {
        Customer object= new Customer();
        object.setName(name);
        object.setMobileNumber(mobileNumber);
        object.setCity(city);
        object.setCustomerId(customerId);
        return object;
    }
    public Invoice getInvoiceObject(int customerId,String item,double price,int invoiceId)
    {
        Invoice object= new Invoice();
        object.setCustomerId(customerId);
        object.setItem(item);
        object.setPrice(price);
        object.setInvoiceId(invoiceId);
        return object;
    }
    public void storeIntoMap(Invoice invoices)
    {
        load.addToMap(invoices);
    }
    public int generateCustomerId()
    {
        customerId++;
        return customerId;
    }
    public int generateInvoiceId()
    {
        invoiceId++;
        return invoiceId;
    }
    public HashMap<Integer,HashMap<Integer,ArrayList<Invoice>>> getCustomerMap()
    {
        return load.getCustomerHashMap();
    }
    public HashMap<Integer,ArrayList<Invoice>> getInvoiceMap()
    {
        return load.getInvoiceHashMap();
    }
}
