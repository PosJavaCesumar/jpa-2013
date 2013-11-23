package br.com.cesumar.ddd;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TratamentoAttributeConverter implements AttributeConverter<Tratamento, String> {

    public String convertToDatabaseColumn(Tratamento x) {
        return x.getValue();
    }

    public Tratamento convertToEntityAttribute(String y) {
        return Tratamento.fromString(y);
    }
    
}