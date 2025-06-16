package uni.edu.pe.proyectopoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.proyectopoo.model.EncuestaModel;
import uni.edu.pe.proyectopoo.model.PreguntaModel;
import uni.edu.pe.proyectopoo.service.EncuestaService;
import uni.edu.pe.proyectopoo.service.RespuestaService;

import java.util.List;

@RestController
@RequestMapping("/encuesta")
public class EncuestaController {
    private final EncuestaService encuestaService;
    private final RespuestaService respuestaService;

    @Autowired
    public EncuestaController(EncuestaService encuestaService, RespuestaService respuestaService) {
        this.encuestaService = encuestaService;
        this.respuestaService = respuestaService;
    }

    @PostMapping(value = "/registrar", consumes = "application/json")
    public EncuestaModel registrarEncuesta(@RequestBody EncuestaPreguntaRequest request) {
        EncuestaModel encuesta = request.getEncuesta();
        List<PreguntaRequest> preguntas = request.getPreguntas();

        // Asignar la encuesta a cada pregunta y sus opciones
        for (PreguntaRequest preguntaRequest : preguntas) {
            PreguntaModel pregunta = new PreguntaModel(preguntaRequest.getPregunta());
            pregunta.setEncuesta(encuesta);
            pregunta.setOpciones(preguntaRequest.getOpciones());
            encuesta.getPreguntas().add(pregunta);
        }

        return encuestaService.registrarEncuesta(encuesta);
    }

    public static class EncuestaPreguntaRequest {
        private EncuestaModel encuesta;
        private List<PreguntaRequest> preguntas;

        public EncuestaModel getEncuesta() {
            return encuesta;
        }

        public void setEncuesta(EncuestaModel encuesta) {
            this.encuesta = encuesta;
        }

        public List<PreguntaRequest> getPreguntas() {
            return preguntas;
        }

        public void setPreguntas(List<PreguntaRequest> preguntas) {
            this.preguntas = preguntas;
        }
    }

    public static class PreguntaRequest {
        private String pregunta;
        private List<String> opciones;

        public String getPregunta() {
            return pregunta;
        }

        public void setPregunta(String pregunta) {
            this.pregunta = pregunta;
        }

        public List<String> getOpciones() {
            return opciones;
        }

        public void setOpciones(List<String> opciones) {
            this.opciones = opciones;
        }
    }
}
