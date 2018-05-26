package invoice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import invoice.dao.InvoiceByInvoiceNo;
import invoice.dao.model.InvoiceEntity;
import invoice.dao.repository.InvoiceRepository;
import invoice.service.InvoiceService;


@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;
    @Autowired
    InvoiceRepository invoiceRepository;

    @RequestMapping(value = "/invoice/{invoice_no}", method = RequestMethod.GET)
    public Optional<InvoiceByInvoiceNo> search(@PathVariable("invoice_no") final String invoiceNo) {
        return invoiceService.search(invoiceNo);
    }

    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    public InvoiceEntity create(@RequestBody final InvoiceEntity invoice) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dataSource.xml")) {
            InvoiceEntity  result = invoiceRepository.save(invoice);
            return result;
        }

    }
}
