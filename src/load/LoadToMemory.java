package load;

import pojo.Invoice;

import java.util.ArrayList;
import java.util.HashMap;

public class LoadToMemory {
    HashMap<Integer, HashMap<Integer, ArrayList<Invoice>>> customerHashMap=new HashMap<>();
    HashMap<Integer, ArrayList<Invoice>> invoiceHashMap;
    ArrayList<Invoice> invoiceList;

    public void addToMap(Invoice invoice)
    {
            int customerId=invoice.getCustomerId();
            invoiceHashMap=customerHashMap.get(customerId);
            if(invoiceHashMap==null)
            {
                invoiceHashMap=new HashMap<>();
                customerHashMap.put(customerId,invoiceHashMap);
                int invoiceId=invoice.getInvoiceId();
                invoiceList=invoiceHashMap.get(invoiceId);
                //                invoiceList.add(invoice);
            }
            else
            {
                int invoiceId=invoice.getInvoiceId();
                invoiceList=invoiceHashMap.get(invoiceId);
            }
            if(invoiceList==null)
            {
                invoiceList=new ArrayList<>();
            }
            invoiceList.add(invoice);
            invoiceHashMap.put(invoice.getInvoiceId(),invoiceList);
    }
    public HashMap<Integer,HashMap<Integer,ArrayList<Invoice>>> getCustomerHashMap()
    {
        return customerHashMap;
    }
    public HashMap<Integer,ArrayList<Invoice>> getInvoiceHashMap()
    {
        return invoiceHashMap;
    }
}