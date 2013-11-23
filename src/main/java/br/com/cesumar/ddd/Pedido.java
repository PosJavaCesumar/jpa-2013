package br.com.cesumar.ddd;

import com.google.common.base.Objects;
import static com.google.common.base.Preconditions.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    
    @Convert(converter = TratamentoAttributeConverter.class)
    private Tratamento tratamento;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable
    private List<PedidoItem> itens = Lists.newLinkedList();
    
    public List<PedidoItem> getItens() {
        return ImmutableList.copyOf(itens);
    }
    
    public void addItem(PedidoItem item) {
        if (!itens.contains(item)) {
            checkState(itens.size() < 5, "Pedido já possui 5 itens.");
            itens.add(item);
        }
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("id", id).toString();
    }

    public Tratamento getTratamento() {
        return tratamento;
    }

    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }
    
}