package com.cds.daoImp;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.cds.dao.EntradaDao;
import com.cds.model.Entradas;
import com.cds.model.Productos;
import com.cds.util.HibernateUtil;
import com.cds.util.MySQLlConnexion;

public class EntradaDaoImpl implements EntradaDao{
	
	private static EntradaDaoImpl entradaDaoImpl = null;
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public Long saveEntrada(Entradas entradas) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long)session.save(entradas);
		session.close();
		return 0l;
	}
	@Override
	public List<Entradas> findAllEntradas() {
		Session session = this.sessionFactory.openSession();
		List<Entradas> lista = (List<Entradas>) session.createQuery("FROM Entradas").list();
		return lista;
	}
	@Override
	public Long deleteEntrada(Long id) {
		System.out.print(id);
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Entradas entradas = new Entradas();
		entradas.setIdEntrada(id);
		
		long response = 1l;
		
		try {
			session.delete(entradas);
			transaction.commit();
		} catch (Exception e) {
			response = 0l;
			System.out.println("Error:"+e);
			transaction.rollback();
		}
		finally {
			session.clear();
			session.close();
		}
		return response;
	}
	@Override
	public Long updateEntrada(Entradas entradas) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(entradas);
		transaction.commit();
		session.close();
		return 1l;
	}
	@Override
	public Entradas findEntradasById(Long id) {
		Session session = this.sessionFactory.openSession();
        Entradas entradas  = null;
		try {
			entradas = new Entradas();
			entradas = session.load(Entradas.class, id);
		} catch (Exception e) {
			System.out.println("null");
		}finally {
			session.close();
		}
		return entradas;
	}
	public static void main(String[] args) {
		 EntradaDaoImpl salidaDaoImpl = new   EntradaDaoImpl();
		salidaDaoImpl.saveEntrada(new Entradas());
	}
}
