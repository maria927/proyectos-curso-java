package co.com.udem.order.documents;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

	@Document
	@Getter
	@Setter
	@ToString(exclude = "id")
	@NoArgsConstructor
	public class OrderTransaction {
	    
	    @Id
	    private String id;
	    private String from;
	    private String to;
	    private BigDecimal amount;

	 

	    public OrderTransaction(final String from, final String to, final BigDecimal amount) {
	        this.from = from;
	        this.to = to;
	        this.amount = amount;
	    }

	 

	}
