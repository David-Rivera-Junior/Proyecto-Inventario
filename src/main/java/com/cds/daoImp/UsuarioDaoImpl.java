package com.cds.daoImp;

import java.util.List;
import org.hibernate.*;
import com.cds.dao.UsuarioDao;
import com.cds.model.Usuarios;
import com.cds.util.HibernateUtil;

public class UsuarioDaoImpl implements UsuarioDao{
	
	private static UsuarioDaoImpl usuarioDaoImpl = null;
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public Long saveUsuario(Usuarios usuarios) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long)session.save(usuarios);
		transaction.commit();
		session.close();
		return id;
	}
	@Override
	public Usuarios findUsuariosById(Long id) {
		Session session = this.sessionFactory.openSession();
        Usuarios usuarios = null;
		try {
			usuarios = new Usuarios();
			usuarios = session.load(Usuarios.class, id);
		} catch (Exception e) {
			System.out.println("null");
		}finally {
			session.close();
		}
		return usuarios;
	}
	@Override
	public List<Usuarios> findAllUsuarios() {
		Session session = this.sessionFactory.openSession();
		List<Usuarios> lista = (List<Usuarios>) session.createQuery("FROM Usuarios").list();
		return lista;
	}
	@Override
	public Long deleteUsuario(Long id) {
		System.out.print(id);
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Usuarios usuarios = new Usuarios();
		usuarios.setIdUsuario(id);
		
		long response = 1l;
		
		try {
			session.delete(usuarios);
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
	public Long updateUsuario(Usuarios usuarios) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(usuarios);
		transaction.commit();
		session.close();
		return 1l;
	}
}
