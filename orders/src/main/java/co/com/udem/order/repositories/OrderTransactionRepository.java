package co.com.udem.order.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.udem.order.documents.OrderTransaction;

public interface OrderTransactionRepository extends MongoRepository<OrderTransaction, String> {

}
