package br.com.cesumar.ddd;

import java.math.BigDecimal;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class QuantidadeAttributeConverter implements AttributeConverter<Quantidade, BigDecimal> {

    public BigDecimal convertToDatabaseColumn(Quantidade x) {
        return x.valor;
    }

    public Quantidade convertToEntityAttribute(BigDecimal y) {
        return Quantidade.newMetros(y);
    }
    
}