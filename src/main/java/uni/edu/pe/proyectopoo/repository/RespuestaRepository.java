package uni.edu.pe.proyectopoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.edu.pe.proyectopoo.model.RespuestaModel;

@Repository
public interface RespuestaRepository extends JpaRepository<RespuestaModel, Long> {
}

