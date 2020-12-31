package co.com.udem.crud.restcontrollers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.udem.crud.dto.UsuarioDTO;
import co.com.udem.crud.entities.Usuario;
import co.com.udem.crud.repositories.UsuarioRepository;
import co.com.udem.crud.util.ConvertUsuario;

@RestController
public class UsuarioRestController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private ConvertUsuario convertUsuario = new ConvertUsuario();

	public UsuarioRestController(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@PostMapping("/usuarios/adicionarUsuario")
	public ResponseEntity<String> adicionarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		
		try {
			Usuario usuario = convertUsuario.convertToEntity(usuarioDTO);
			usuarioRepository.save(usuario);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}

		return ResponseEntity.ok("Usuario guardado exitosamente");
	}

	@GetMapping("/usuarios")
	public Iterable<Usuario> listarUsuarios() {  //Tarea: convertir a DTO convertToDTO
		return usuarioRepository.findAll();
	}
	
//	@GetMapping("/usuarios")
//	public Iterable<Usuario> listarUsuarios() {  //Tarea: convertir a DTO convertToDTO
//		
//		UsuarioDTO usuarioDTO = new UsuarioDTO();
//
//		try {
//			Usuario usuario = (Usuario) usuarioRepository.findAll();
//			usuarioDTO = convertUsuario.convertToDTO(usuario);
//		} catch (ParseException e) {
//			System.err.println("Error convirtiendo a entity a DTO: " + e.getMessage() + e.getCause());
//		}
//		return (Iterable<Usuario>) usuarioDTO;
//	}

	@DeleteMapping("/usuarios/{id}")
	public void eliminarUsuario(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
	}
	
	@PutMapping("/usuarios/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody Usuario newUser, @PathVariable Long id) {
        if(usuarioRepository.findById(id).isPresent()) {
            Usuario user = usuarioRepository.findById(id).get();
            user.setFirstName(newUser.getFirstName());
            user.setLastName(newUser.getLastName());
            user.setEmail(newUser.getEmail());
            usuarioRepository.save(user);
            return ResponseEntity.ok("Se actualizó exitosamente");
        }else {
            return null;
        }
    }

//	@GetMapping("/usuarios/{id}")
//	public Usuario buscarUsuario(@PathVariable Long id) {
//		return usuarioRepository.findById(id).get();
//	}
	
	@GetMapping("/usuarios/{id}")
	public UsuarioDTO buscarUsuario(@PathVariable Long id) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();

		try {
			Usuario usuario = usuarioRepository.findById(id).get();
			usuarioDTO = convertUsuario.convertToDTO(usuario);
		} catch (ParseException e) {
			System.err.println("Error convirtiendo a entity a DTO: " + e.getMessage() + e.getCause());
		}
		return usuarioDTO;
	}

}
