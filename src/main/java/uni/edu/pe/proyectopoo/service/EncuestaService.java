package uni.edu.pe.proyectopoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.proyectopoo.model.EncuestaModel;
import uni.edu.pe.proyectopoo.model.PreguntaModel;
import uni.edu.pe.proyectopoo.repository.EncuestaRepository;
import uni.edu.pe.proyectopoo.repository.PreguntaRepository;

import java.util.List;

@Service
public class EncuestaService {
    private final EncuestaRepository encuestaRepository;
    private final PreguntaRepository preguntaRepository;

    @Autowired
    public EncuestaService(EncuestaRepository encuestaRepository, PreguntaRepository preguntaRepository) {
        this.encuestaRepository = encuestaRepository;
        this.preguntaRepository = preguntaRepository;
    }

    public EncuestaModel registrarEncuesta(EncuestaModel encuesta) {
        EncuestaModel encuestaGuardada = encuestaRepository.save(encuesta);
        List<PreguntaModel> preguntas = encuesta.getPreguntas();
        for (PreguntaModel pregunta : preguntas) {
            pregunta.setEncuesta(encuestaGuardada);
            preguntaRepository.save(pregunta);
        }
        return encuestaGuardada;
    }

    public List<EncuestaModel> listarEncuestas() {
        return (List<EncuestaModel>) encuestaRepository.findAll();
    }

    public EncuestaModel obtenerEncuestaPorId(Long id) {
        return encuestaRepository.findById(id).orElse(null);
    }

    public List<PreguntaModel> obtenerPreguntasDeEncuesta(Long encuestaId) {
        return preguntaRepository.findByEncuestaId(encuestaId);
    }



    public List<PreguntaModel> obtenerPreguntasPorEncuestaId(Long encuestaId) {
        return preguntaRepository.findByEncuestaId(encuestaId);
    }

}
