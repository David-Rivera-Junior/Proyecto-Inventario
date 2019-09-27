package com.cds.dao;
import java.util.*;
import com.cds.model.Roles;

public interface RolDao {
	
	Long saveRol(Roles roles) ;
	
	Roles findRolById(Long id);

	List<Roles> findAllRoles(); 
	
	Long deleteRol(Long id); 
	
	Long updateRol(Roles roles);
	
}
