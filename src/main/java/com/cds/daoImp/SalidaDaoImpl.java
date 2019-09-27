package com.cds.daoImp;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.cds.dao.SalidaDao;
import com.cds.model.Productos;
import com.cds.model.Salidas;
import com.cds.util.HibernateUtil;
import com.cds.util.MySQLlConnexion;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


public class SalidaDaoImpl extends MySQLlConnexion implements SalidaDao{
	
	private static SalidaDaoImpl salidaDaoImpl = null;
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public Long saveSalida(Salidas salidas) {
		 String sql = "INSERT INTO salidas(id_producto,cantidad) VALUES ("+salidas.getProductos().getIdProducto()+","+salidas.getCantidad()+")";
		 long response = 1l;
		 try {
	            //Abrir Conexion con MySQL
	            this.conectar();
	            //Preparar la Query
	            PreparedStatement statment = (PreparedStatement) this.getCn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	            //Setear los datos
	           // statment.setLong(1, 1l);
		        //statment.setInt(2, 5);
	            //Ejecutar la insercion
	            statment.executeUpdate();
	            } catch (Exception e) {
	            //Excepciones
	            System.out.println("Error"+e);
	            
	        }finally{
	            //Cerrar la Conexion
	            //this.cerrarCn();
	        	response = 0l;
	        }
		    return response;
		
	}
	
	@Override
	public Salidas findSalidasById(Long id) {
		Session session = this.sessionFactory.openSession();
		Salidas salidas  = null;
		try {
			salidas = new Salidas();
			salidas = session.load(Salidas.class, id);
		} catch (Exception e) {
			System.out.println("null");
		}finally {
			session.close();
		}
		return salidas;
	}
	@Override
	public List<Salidas> findAllSalidas() {
		Session session = this.sessionFactory.openSession();
		List<Salidas> lista = (List<Salidas>) session.createQuery("FROM Salidas").list();
		return lista;
	}
	@Override
	public Long deleteSalida(Long id) {
		System.out.print("---------"+id);
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Salidas salidas = new Salidas();
		salidas.setIdSalida(id);
		
		long response = 1l;
		
		try {
			session.delete(salidas);
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
	public Long updateSalida(Salidas salidas) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(salidas);
		transaction.commit();
		session.close();
		return 1l;
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
	
	public static void main(String[] args) {
		 SalidaDaoImpl salidaDaoImpl = new   SalidaDaoImpl();
		 Salidas salida = new Salidas(10l,new Productos(1l), 50, null, null);
		 salidaDaoImpl.saveSalida(salida );
	}

}
