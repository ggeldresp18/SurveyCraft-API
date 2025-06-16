package uni.edu.pe.proyectopoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.edu.pe.proyectopoo.model.PreguntaModel;

import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<PreguntaModel, Long> {
    List<PreguntaModel> findByEncuestaId(Long encuestaId);
}
