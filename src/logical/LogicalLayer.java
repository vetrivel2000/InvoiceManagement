package logical;
import load.LoadToMemory;
import pojo.Customer;
import pojo.Invoice;
import pojo.Item;

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
    public Invoice getInvoiceObject(int customerId,ArrayList<Item> items,double price,int invoiceId)
    {
        Invoice object= new Invoice();
        object.setCustomerId(customerId);
        object.setItems(items);
        object.setTotalPrice(price);
        object.setInvoiceId(invoiceId);
        return object;
    }
    public Item getItemObject(String itemName,double price)
    {
        Item object= new Item();
        object.setItemName(itemName);
        object.setPrice(price);
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
    public HashMap<Integer,HashMap<Integer,Invoice>> getCustomerMap()
    {
        return load.getCustomerHashMap();
    }
    public HashMap<Integer,Invoice> getInvoiceMap()
    {
        return load.getInvoiceHashMap();
    }
}
