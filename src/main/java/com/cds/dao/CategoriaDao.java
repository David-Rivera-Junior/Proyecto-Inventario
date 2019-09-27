package com.cds.dao;
import com.cds.model.Categorias;
import java.util.*;

public interface CategoriaDao {
	
	Long saveCategoria(Categorias categorias) ;
	
	Categorias findCategoriaById(Long id);

	List<Categorias> findAllCategorias(); 
	
	Long deleteCategoria(Long id); 
	
	Long updateCategoria(Categorias categorias);
}
