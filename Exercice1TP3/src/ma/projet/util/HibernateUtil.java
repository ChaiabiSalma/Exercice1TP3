
package ma.projet.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    // Ce bloc de code statique s'exécute lorsque la classe HibernateUtil est chargée pour la première fois
    static {
        try{
            sessionFactory=(SessionFactory) new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void shutdown() {
        getSessionFactory().close();//libère toutes les ressources
    }
}

