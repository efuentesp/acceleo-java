/**
 * Autor: PSG.
 * Proyecto:
 * Version: 0.1 
 * Clase para generar servicios de los usuarios. 
 */
package com.softtek.acceleo.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.repository.UsuarioRepository;
import com.softtek.acceleo.demo.domain.Usuario;
import com.softtek.acceleo.demo.service.UsuarioService;
/**
 * Clase UsuarioServiceImpl.
 * @author PSG.
 *
 */
@Service("usuarioService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 * Agrega un usuario.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUsuario(Usuario usuario) {
		usuarioRepository.addUsuario(usuario);
	}

	/**
	 * Edita un usuario.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void editUsuario(Usuario usuario) {
		usuarioRepository.editUsuario(usuario);
	}
	
	/**
	 * Consulta informacion de usuarios.
	 */
	public List<Usuario> listUsuarios(Usuario usuario) {
		return usuarioRepository.listUsuarios(usuario);
	}

	/**
	 * Obtiene informacion de un usuario.
	 */
	public Usuario getUsuario(UUID empid) {
		return usuarioRepository.getUsuario(empid);
	}

	/**
	 * Elimina un usuario.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteUsuario(Usuario usuario) {
		 usuarioRepository.deleteUsuario(usuario);
	}

	/**
	 * Consulta informacion de usuarios y la pagina.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Usuario> listUsuariosPagination(Usuario usuario, int page, int size) {
		return usuarioRepository.listUsuariosPagination(usuario, page, size);
	}

	/**
	 * Obtiene el numero de usuarios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRowsSearch(String query) {

		return usuarioRepository.getTotalRowsSearch(query);
	}
	
	/**
	 * Obtiene el numero de usuarios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows(String query) {

		return usuarioRepository.getTotalRows(query);
	}

	/**
	 * Obtiene el numero de usuarios consultados.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long getTotalRows() {
		return usuarioRepository.getTotalRows();
	}

	/**
	 * Consulta informacion de los usuarios y la pagina.
	 */
	public List<Usuario> listUsuariosQuery(Usuario usuario, String query, int page, int size) {
		// TODO Auto-generated method stub
		return usuarioRepository.listUsuariosQuery(usuario, query, page, size);
	}
}	
