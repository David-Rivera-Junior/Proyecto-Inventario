package com.cds.dao;
import java.util.*;

import com.cds.model.Roles;
import com.cds.model.Usuarios;

public interface UsuarioDao {
	
	Long saveUsuario(Usuarios usuarios) ;
	
	Usuarios findUsuariosById(Long id);

	List<Usuarios> findAllUsuarios(); 
	
	Long deleteUsuario(Long id); 
	
	Long updateUsuario(Usuarios usuarios);
	
}
