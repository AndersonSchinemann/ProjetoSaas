package com.topdata.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topdata.model.Usuario;
import com.topdata.repository.ProfileRepository;
import com.topdata.repository.UsuarioRepository;

@Service
public class UsuarioService{
	
	@Autowired
	private final UsuarioRepository userRepository;
	@Autowired
    private final ProfileRepository profileRepository;
    
    public UsuarioService(UsuarioRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }
    public void save(Usuario usuario) {
	        profileRepository.save(usuario.getProfile());
	        userRepository.save(usuario);
	}
    public Usuario getUsuario(String userId) {
    	Long id = Long.parseLong(userId);
        return userRepository.findById(id).get();	
    }
    public List<Usuario> getAllUsuarios() {
        return userRepository.findAll();
    }

    public Usuario getUsuarioById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

//    public List<Usuario> searchUsuarios(String searchTerm) {
//        return userRepository.findByNameContainingAndEmailContaining(searchTerm, searchTerm);
//    }
    
    public void deleteUsuarioAll(Usuario usuario) {
    	userRepository.delete(usuario);
    }
    
    public boolean deleteUsuario(long id) {
    	try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            
           return false;
        }
    }
    
    public List<Usuario> pesquisaUsuario(String searchText, boolean searchMode){
    	System.out.println("Procurando usuario Sevice");
    	return userRepository.findByNameContainingOrEmailContaining(searchText,searchMode);
    }
    
    public Usuario atualizarUsuario(Usuario usuarioAtualizado) {
        // Verifique se o usuário existe antes de tentar atualizar
        if (userRepository.existsById(usuarioAtualizado.getId())) {
            return userRepository.save(usuarioAtualizado);
        } else {
            // Lógica de tratamento se o usuário não existir
            return null;
        }
    }
    
}
