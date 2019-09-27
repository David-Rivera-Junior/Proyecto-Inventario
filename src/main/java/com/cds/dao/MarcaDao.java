package com.cds.dao;
import java.util.*;
import com.cds.model.Marcas;
import com.cds.model.Proveedores;

public interface MarcaDao {
	
	Long saveMarca(Marcas marcas) ;
	
	Marcas findMarcaById(Long id);

	List<Marcas> findAllMarcas(); 
	
	Long deleteMarca(Long id); 
	
	Long updateMarca(Marcas marcas);
	
}
