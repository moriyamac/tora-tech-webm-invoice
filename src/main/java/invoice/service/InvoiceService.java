package invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import invoice.dao.model.InvoiceEntity;
import invoice.dao.repository.DirectSqlRepository;
import invoice.dao.repository.InvoiceRepository;
import invoice.response.InvoiceResult;



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
    public List<InvoiceResult> search(final String invoiceNo) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dataSource.xml")) {
            List<InvoiceResult> result = directSqlRepository.getInvoiceByInvoiceNo(invoiceNo);
            return result;
        }
    }

    /**
     * @param entity
     * @return
     */
    public List<InvoiceResult> save(final InvoiceEntity entity) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dataSource.xml")) {
            List<InvoiceResult>  result = invoiceRepository.save(entity);
            return result;
        }
    }
}
