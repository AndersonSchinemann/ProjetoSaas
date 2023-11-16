package com.topdata.repository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.topdata.model.Usuario;


import jakarta.transaction.Transactional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // métodos do repositório
	
	// Método para buscar usuários por nome e email
    //List<Usuario> findByNameContainingAndEmailContaining(final String name , final String email);
    
	
	
    @Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.profile")
    List<Usuario> findAllWithProfile();
    
    @Transactional
    int deleteUsuarioById(int id);

    List<Usuario> findByNameContainingOrEmailContaining(String searchText, boolean searchMode);

	boolean existsById(int id);

	//Usuario findByUsername(String name);
 
}
