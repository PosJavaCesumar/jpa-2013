package br.com.cesumar.ddd;

import static com.google.common.base.Preconditions.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Formattable;
import java.util.Formatter;

public class Quantidade implements Serializable, Formattable {
    
    final Medida medida;
    
    final BigDecimal valor;
    
    private Quantidade(Medida medida, BigDecimal valor) {
        this.medida = medida;
        this.valor = valor;
    }
    
    public static Quantidade newMetros(BigDecimal valor) {
        checkNotNull(valor, "Valor não pode ser nulo.");
        return new Quantidade(Medida.METROS, valor);
    }

    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%d %s", valor, medida);
    }
    
}
