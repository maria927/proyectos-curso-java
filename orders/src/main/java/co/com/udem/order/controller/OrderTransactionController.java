package co.com.udem.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.udem.order.documents.OrderTransaction;
import co.com.udem.order.repositories.OrderTransactionRepository;

@RestController
@RequestMapping("/transaction")
public class OrderTransactionController {
	
	private static final Logger log = LoggerFactory.getLogger(OrderTransactionController.class);

    private final JmsTemplate jmsTemplate;

    @Autowired
    private OrderTransactionRepository orderTransactionRepository;
 

    public OrderTransactionController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    @PostMapping("/send")
    public void send(@RequestBody OrderTransaction transaction) {
        log.info("Sending a transaction.");
        jmsTemplate.convertAndSend("OrderTransactionQueue", transaction);
    }
    
    @GetMapping("/list")
    public List<OrderTransaction> list() {
        log.info("Listing transactions.");
        List<OrderTransaction> listTransactions = orderTransactionRepository.findAll();
        
        return listTransactions;
        //jmsTemplate.
    }

}
