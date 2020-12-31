package co.com.udem.crud.repositories;

import org.springframework.data.repository.CrudRepository;

import co.com.udem.crud.entities.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long> {


}
