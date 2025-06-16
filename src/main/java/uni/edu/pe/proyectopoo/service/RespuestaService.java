package uni.edu.pe.proyectopoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.edu.pe.proyectopoo.model.RespuestaModel;
import uni.edu.pe.proyectopoo.repository.RespuestaRepository;

@Service
public class RespuestaService {
    private final RespuestaRepository respuestaRepository;

    @Autowired
    public RespuestaService(RespuestaRepository respuestaRepository) {
        this.respuestaRepository = respuestaRepository;
    }

    public RespuestaModel guardarRespuesta(RespuestaModel respuesta) {
        return respuestaRepository.save(respuesta);
    }
}

