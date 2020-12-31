package co.com.udem.crud.restcontrollers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.udem.crud.dto.LibroDTO;
import co.com.udem.crud.entities.Libro;
import co.com.udem.crud.repositories.LibroRepository;
import co.com.udem.crud.utils.ConvertLibro;




@RestController
public class LibroRestController {
	
	@Autowired
	private LibroRepository libroRepo;
	
	private ConvertLibro convertLibro = new ConvertLibro();

	
	@PostMapping("/libros/adicionarLibro")
	public ResponseEntity<String> adicionarLibro(@RequestBody LibroDTO libroDTO) {
		
		
			try {
				Libro libro = convertLibro.convertToEntity(libroDTO);
				libroRepo.save(libro);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		return ResponseEntity.ok("Usuario guardado exitosamente");
	}

}
