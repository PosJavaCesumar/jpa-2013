package util;

import br.com.cesumar.ddd.Pedido;
import br.com.cesumar.ddd.Tratamento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HibernateUtilTest {

    @Test
    public void test() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Pedido pedido = new Pedido();
        pedido.setTratamento(Tratamento.ESPECIAL);
        session.persist(pedido);
        tx.commit();
        session.close();
    }
    
}