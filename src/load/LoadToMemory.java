package load;

import pojo.Invoice;

import java.util.ArrayList;
import java.util.HashMap;

public class LoadToMemory {
    HashMap<Integer, HashMap<Integer, Invoice>> customerHashMap=new HashMap<>();
    HashMap<Integer, Invoice> invoiceHashMap;

    public void addToMap(Invoice invoice)
    {
            int customerId=invoice.getCustomerId();
            invoiceHashMap=customerHashMap.get(customerId);
            if(invoiceHashMap==null)
            {
                invoiceHashMap=new HashMap<>();
                customerHashMap.put(customerId,invoiceHashMap);
                //                invoiceList.add(invoice);
            }
            invoiceHashMap.put(invoice.getInvoiceId(),invoice);
    }
    public HashMap<Integer,HashMap<Integer,Invoice>> getCustomerHashMap()
    {
        return customerHashMap;
    }
    public HashMap<Integer,Invoice> getInvoiceHashMap()
    {
        return invoiceHashMap;
    }
}