package com.cds.daoImp;

import java.util.List;
import org.hibernate.*;
import com.cds.dao.ProductoDao;
import com.cds.model.Productos;
import com.cds.util.HibernateUtil;

public class ProductoDaoImpl implements ProductoDao {

	private static ProductoDaoImpl productoDaoImpl = null;
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public Long saveProducto(Productos productos) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long)session.save(productos);
		transaction.commit();
		session.close();
		return id;
	}

	@Override
	public Productos findProductosById(Long id) {
		Session session = this.sessionFactory.openSession();
		Productos producto  = null;
		try {
			producto = new Productos();
			producto = (Productos) session.createQuery("FROM Productos where idProducto = "+id).uniqueResult();
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			session.close();
		}
		return producto;
	}

	@Override
	public List<Productos> findAllProductos() {
		Session session = this.sessionFactory.openSession();
		List<Productos> lista = (List<Productos>) session.createQuery("FROM Productos").list();
		return lista;
	}

	@Override
	public Long deleteProducto(Long id) {
		System.out.print(id);
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Productos productos = new Productos();
		productos.setIdProducto(id);
		
		long response = 1l;
		
		try {
			session.delete(productos);
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
	public Long updateProducto(Productos productos) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(productos);
		transaction.commit();
		session.close();
		return 1l;
	}
	
	public static void main(String[] args) {
		 ProductoDaoImpl salidaDaoImpl = new  ProductoDaoImpl();
		 Productos producto= salidaDaoImpl.findProductosById(4l);
		 System.out.println(producto.getCantidad());
		
	}

}
