package invoice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import invoice.dao.InvoiceByInvoiceNo;
import invoice.dao.model.InvoiceEntity;
import invoice.dao.repository.DirectSqlRepository;
import invoice.dao.repository.InvoiceRepository;



@Service
@Transactional
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    DirectSqlRepository directSqlRepository;

    /**
     * @param invoiceNo
     * @return
     */
    public Optional<InvoiceByInvoiceNo> search(final String invoiceNo) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dataSource.xml")) {
            Optional<InvoiceByInvoiceNo> result = directSqlRepository.getInvoiceByInvoiceNo(invoiceNo);
            return result;
        }
    }

    /**
     * @param entity
     * @return
     */
    public InvoiceEntity save(final InvoiceEntity entity) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dataSource.xml")) {
        	InvoiceEntity  result = invoiceRepository.save(entity);
            return result;
        }
    }
}
