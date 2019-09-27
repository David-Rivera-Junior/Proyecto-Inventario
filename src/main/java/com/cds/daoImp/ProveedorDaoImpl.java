package com.cds.daoImp;
import java.util.*;
import org.hibernate.*;
import com.cds.model.Proveedores;
import com.cds.model.Roles;
import com.cds.dao.ProveedorDao;
import com.cds.util.HibernateUtil;

public class ProveedorDaoImpl implements ProveedorDao{
	
	private static ProveedorDaoImpl proveedorDaoImpl = null;
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public Long saveProveedor(Proveedores proveedor) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long)session.save(proveedor);
		transaction.commit();
		session.close();
		return id;
	}

	@Override
	public Proveedores findProveedorById(Long id) {
		Session session = this.sessionFactory.openSession();
		Proveedores proveedor = null;
		
		try {
			proveedor = new Proveedores();
			proveedor = session.load(Proveedores.class, id);
		} catch (Exception e) {
			System.out.println("null");
		}finally {
			session.close();
		}
		return proveedor;
	}

	@Override
	public List<Proveedores> findAllProveedores() {
		Session session = this.sessionFactory.openSession();
		List<Proveedores> lista = (List<Proveedores>) session.createQuery("from Proveedores").list();
		return lista;
	}
	

	@Override
	public Long deleteProveedor(Long id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Proveedores proveedor = new Proveedores();
		proveedor.setIdProveedor(id);
		
		long response = 1l;
		
		try {
			session.delete(proveedor);
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
	public Long updateProveedor(Proveedores proveedores) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(proveedores);
		transaction.commit();
		session.close();
		return 1l;
	}

}
