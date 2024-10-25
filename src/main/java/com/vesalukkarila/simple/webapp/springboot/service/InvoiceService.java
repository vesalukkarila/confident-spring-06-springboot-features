package com.vesalukkarila.simple.webapp.springboot.service;

import com.vesalukkarila.simple.webapp.springboot.model.Invoice;
import com.vesalukkarila.simple.webapp.springboot.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {

    private List<Invoice> invoices = new CopyOnWriteArrayList<>();
    private final UserService userService;
    private final String cdnUrl;

    public InvoiceService(UserService userService, @Value("${cdn.url}") String cdnUrl) {
        this.userService = userService;
        this.cdnUrl = cdnUrl;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Printout from invoicesService's postconstruct");
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Printout from invoiceService's predestroy");
    }


    public List<Invoice> findAll() {
        return invoices;
    }


    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalStateException();
        }

        //TODO real pdf creation and storing it o network server
        Invoice invoice = new Invoice(userId, amount, cdnUrl + "/images/default/sample.pdf");
        invoices.add(invoice);
        return invoice;
    }

}
