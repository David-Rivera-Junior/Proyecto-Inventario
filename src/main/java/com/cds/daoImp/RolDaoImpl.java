package com.cds.daoImp;
import java.util.*;
import org.hibernate.*;
import com.cds.model.Roles;
import com.cds.dao.RolDao;
import com.cds.util.HibernateUtil;

public class RolDaoImpl implements RolDao{
	
	private static RolDaoImpl rolDaoImpl = null;
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


	@Override
	public List<Roles> findAllRoles() {
		Session session = this.sessionFactory.openSession();
		List<Roles> lista = (List<Roles>) session.createQuery("FROM Roles").list();
		return lista;
	}

	@Override
	public Long deleteRol(Long id) {
		System.out.print("------------------------"+id);
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Roles roles = new Roles();
		roles.setIdRol(id);
		
		long response = 1l;
		
		try {
			session.delete(roles);
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
	public Long saveRol(Roles roles) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long)session.save(roles);
		transaction.commit();
		session.close();
		return id;
	}

	@Override
	public Roles findRolById(Long id) {
		Session session = this.sessionFactory.openSession();
		Roles rol = null;
		try {
			rol = new Roles();
			rol = session.load(Roles.class, id);
		} catch (Exception e) {
			System.out.println("null");
		}finally {
			session.close();
		}
		return rol;
	}

	@Override
	public Long updateRol(Roles roles) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(roles);
		transaction.commit();
		session.close();
		return 1l;
	}

}
