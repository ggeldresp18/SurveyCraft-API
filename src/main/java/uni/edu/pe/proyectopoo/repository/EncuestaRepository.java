package uni.edu.pe.proyectopoo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uni.edu.pe.proyectopoo.model.EncuestaModel;

@Repository
public interface EncuestaRepository extends CrudRepository<EncuestaModel, Long> {
}


