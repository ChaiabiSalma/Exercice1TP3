
package ma.projet.service;

import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.entity.Produit;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitService implements IDao<Produit>{

    @Override
    public boolean create(Produit produit) {
        
        Session session=null;
        try { 
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(produit);
            session.getTransaction().commit();
            return true;
        }catch(HibernateException e){
            session.getTransaction().rollback();
        }finally {
            
                session.close(); 
            
        }
        return false;
    }

    @Override
    public boolean update(Produit produit) {
        Session session=null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();  
            session.beginTransaction();
            session.update(produit);
            session.getTransaction().commit();
        return true;
        }catch(HibernateException e){
            session.getTransaction().rollback();
        }finally {
            
                session.close(); 
            
        }
        return false;
    }
    @Override
    public boolean delete(Produit produit) {
        Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(produit);
            session.getTransaction().commit();
            return true;
        }catch(HibernateException e){
            session.getTransaction().rollback();
        }finally {
            
                session.close(); 
            
        }
        return false;
    }

    @Override
    public Produit findById(int id) {
        Session session=null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
           return (Produit) session.get(Produit.class, id);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Produit> findAll() {
        Session session=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();     
            return session.createQuery("from Produit").list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if (session != null) {
                session.close(); 
            }
        }
    }
    
}
