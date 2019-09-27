package com.cds.dao;
import java.util.*;

import com.cds.model.Productos;
import com.cds.model.Salidas;

public interface SalidaDao {
	
	Long saveSalida(Salidas salidas) ;
	
	Salidas findSalidasById(Long id);

	List<Salidas> findAllSalidas(); 
	
	Long deleteSalida(Long id); 
	
	Long updateSalida(Salidas salidas);
	
	Productos findProductosById(Long id);
}
