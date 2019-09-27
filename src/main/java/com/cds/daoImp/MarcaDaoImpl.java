package com.cds.daoImp;
import java.util.*;
import org.hibernate.*;
import com.cds.model.Marcas;
import com.cds.dao.MarcaDao;
import com.cds.util.HibernateUtil;

public class MarcaDaoImpl implements MarcaDao{
	
	private static MarcaDaoImpl marcaDaoImpl = null;
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public Long saveMarca(Marcas marcas) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long)session.save(marcas);
		transaction.commit();
		session.close();
		return id;
	}

	@Override
	public Marcas findMarcaById(Long id) {
		Session session = this.sessionFactory.openSession();
		Marcas marca  = null;
		try {
			marca = new Marcas();
			marca = session.load(Marcas.class, id);
		} catch (Exception e) {
			System.out.println("null");
		}finally {
			session.close();
		}
		return marca;
	}

	@Override
	public List<Marcas> findAllMarcas() {
		Session session = this.sessionFactory.openSession();
		List<Marcas> lista = (List<Marcas>) session.createQuery("FROM Marcas").list();
		return lista;
	}

	@Override
	public Long deleteMarca(Long id) {
		System.out.print(id);
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Marcas marcas = new Marcas();
		marcas.setIdMarca(id);
		
		long response = 1l;
		
		try {
			session.delete(marcas);
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
	public Long updateMarca(Marcas marcas) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(marcas);
		transaction.commit();
		session.close();
		return 1l;
	}
	
}
