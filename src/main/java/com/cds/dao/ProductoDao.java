package com.cds.dao;

import java.util.*;

import com.cds.model.Categorias;
import com.cds.model.Marcas;
import com.cds.model.Productos;

public interface ProductoDao {
	
	Long saveProducto(Productos productos) ;
	
	Productos findProductosById(Long id);

	List<Productos> findAllProductos(); 
	
	Long deleteProducto(Long id); 
	
	Long updateProducto(Productos productos);
	
}
