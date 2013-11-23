package br.com.cesumar.ddd;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public enum Tratamento {
    ESPECIAL("E"), NORMAL("N");
    
    private final String value;
    
    private static final Map<String, Tratamento> valueMap;
    
    static {
        ImmutableMap.Builder<String, Tratamento> builder = ImmutableMap.builder();
        for (Tratamento tratamento: values()) {
            builder.put(tratamento.value, tratamento);
        }
        valueMap = builder.build();
    }
    
    public static Tratamento fromString(String value) {
        return valueMap.get(value);
    }
    
    private Tratamento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
}
