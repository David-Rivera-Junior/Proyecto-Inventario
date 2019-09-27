package com.cds.daoImp;
import java.util.*;
import org.hibernate.*;
import com.cds.model.Categorias;
import com.cds.dao.CategoriaDao;
import com.cds.util.HibernateUtil;

public class CategoriaDaoImpl implements CategoriaDao{
	
	private static CategoriaDaoImpl categoriaDaoImpl = null;
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public Long saveCategoria(Categorias categorias) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long)session.save(categorias);
		transaction.commit();
		session.close();
		return id;
	}

	@Override
	public Categorias findCategoriaById(Long id) {
		Session session = this.sessionFactory.openSession();
		Categorias categorias = null;
		
		try {
			categorias = new Categorias();
			categorias = session.load(Categorias.class, id);
		} catch (Exception e) {
			System.out.println("null");
		}finally {
			session.close();
		}
		return categorias;
	}

	@Override
	public List<Categorias> findAllCategorias() {
		Session session = this.sessionFactory.openSession();
		List<Categorias> lista = (List<Categorias>) session.createQuery("FROM Categorias").list();
		return lista;
	}

	@Override
	public Long deleteCategoria(Long id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Categorias categorias = new Categorias();
		categorias.setIdCategoria(id);
		
		long response = 1l;
		
		try {
			session.delete(categorias);
			transaction.commit();
		} catch (Exception e) {
			response = 0l;
			transaction.rollback();
		}
		finally {
			session.clear();
			session.close();
		}
		
		return response;
	}

	@Override
	public Long updateCategoria(Categorias categorias) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(categorias);
		transaction.commit();
		session.close();
		return 1l;
	}
	
	/*public static void main(String[] args) {
		CategoriaDaoImpl categoriaDaoImpl = new CategoriaDaoImpl();
		for(Categorias test: categoriaDaoImpl.findAllCategorias()) {
			System.out.println(test.getNombreCategoria());
		}
			
	}*/

}
