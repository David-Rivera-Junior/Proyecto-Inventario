package com.cds.dao;
import java.util.*;
import com.cds.model.Entradas;
import com.cds.model.Productos;

public interface EntradaDao {
	
	Long saveEntrada(Entradas entradas) ;
	
	Entradas findEntradasById(Long id);

	List<Entradas> findAllEntradas(); 
	
	Long deleteEntrada(Long id); 
	
	Long updateEntrada(Entradas entradas);
}
