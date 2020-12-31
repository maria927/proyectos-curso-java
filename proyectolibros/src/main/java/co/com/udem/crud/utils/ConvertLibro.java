package co.com.udem.crud.utils;

import java.text.ParseException;

import org.modelmapper.ModelMapper;

import co.com.udem.crud.dto.LibroDTO;
import co.com.udem.crud.entities.Libro;

public class ConvertLibro {
	
	private ModelMapper modelMapper = new ModelMapper();
	   
    public Libro convertToEntity(LibroDTO libroDTO) throws ParseException {
        return modelMapper.map(libroDTO, Libro.class);
    }

}
