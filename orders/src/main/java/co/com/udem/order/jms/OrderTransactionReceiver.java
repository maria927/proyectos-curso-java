package co.com.udem.order.jms;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import co.com.udem.order.documents.OrderTransaction;
import co.com.udem.order.repositories.OrderTransactionRepository;

@Component
public class OrderTransactionReceiver {

	private static final Logger log = LoggerFactory.getLogger(OrderTransactionReceiver.class);

	 

    private final OrderTransactionRepository transactionRepository;

    public OrderTransactionReceiver(OrderTransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    private int count = 1;


    @JmsListener(destination = "OrderTransactionQueue", containerFactory = "myFactory")
    public void receiveMessage(OrderTransaction transaction) {
        log.info("<" + count + "> Received <" + transaction + ">");
        count++;
        // throw new RuntimeException();
        transactionRepository.save(transaction);
    }
}
