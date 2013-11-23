package br.com.cesumar.ddd;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PedidoItem implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;

    private Quantidade quantidade;
    
}
