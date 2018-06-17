package invoice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import invoice.dao.model.InvoiceEntity;
import invoice.dao.repository.InvoiceRepository;
import invoice.response.InvoiceError;
import invoice.response.InvoiceResult;
import invoice.response.ResponseInvoice;
import invoice.service.InvoiceService;


@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;
    @Autowired
    InvoiceRepository invoiceRepository;

    @RequestMapping(value = "/{invoice_no}", method = RequestMethod.GET)
    @CrossOrigin
    public ResponseInvoice search(@PathVariable("invoice_no") final String invoiceNo) {
        List<InvoiceResult> result = invoiceService.search(invoiceNo);
        ResponseInvoice response = new ResponseInvoice(null, result);
        return response;
    }

    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin
    public ResponseInvoice create(@RequestBody final InvoiceEntity invoice) throws ApplicationException {
        if (invoice.getInvoiceStartDate().compareTo(invoice.getInvoiceEndDate()) > 0) {
            throw new ApplicationException();
        }
        List<InvoiceResult> result = invoiceService.save(invoice);
        ResponseInvoice response = new ResponseInvoice(null, result);
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ ApplicationException.class })
    @ResponseBody
    public ResponseInvoice handleError() {
        InvoiceError error = new InvoiceError();
        error.setErrorCode("40002");
        error.setErrorDetail("invoice_start_date,invoice_end_date");
        error.setErrorDetail("請求日時のフォーマットが不正です。");
        List<InvoiceError> errorList = new ArrayList<InvoiceError>();
        errorList.add(error);
        ResponseInvoice response = new ResponseInvoice(errorList, null);
        return response;
    }
}
