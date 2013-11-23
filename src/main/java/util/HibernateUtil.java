package util;

import br.com.cesumar.ddd.Pedido;
import br.com.cesumar.ddd.PedidoItem;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            final AnnotationConfiguration cfg = new AnnotationConfiguration();
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            cfg.addAnnotatedClass(Pedido.class);
            cfg.addAnnotatedClass(PedidoItem.class);
            sessionFactory = cfg.configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}