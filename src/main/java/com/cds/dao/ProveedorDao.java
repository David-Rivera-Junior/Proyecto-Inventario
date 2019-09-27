package com.cds.dao;
import java.util.*;
import com.cds.model.Proveedores;

public interface ProveedorDao {

	Long saveProveedor(Proveedores proveedores) ;
	
	Proveedores findProveedorById(Long id);

	List<Proveedores> findAllProveedores(); 
	
	Long deleteProveedor(Long id); 
	
	Long updateProveedor(Proveedores proveedores);
}
