package uni.edu.pe.proyectopoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.proyectopoo.model.EncuestaModel;
import uni.edu.pe.proyectopoo.model.PreguntaModel;
import uni.edu.pe.proyectopoo.service.EncuestaService;

import java.util.List;

@RestController
@RequestMapping("/encuesta")
public class EncuestaViewController {
    private final EncuestaService encuestaService;

    @Autowired
    public EncuestaViewController(EncuestaService encuestaService) {
        this.encuestaService = encuestaService;
    }

    @GetMapping("/listar")
    public List<EncuestaModel> listarEncuestas() {
        return encuestaService.listarEncuestas();
    }

    @GetMapping("/mostrar/{id}")
    public EncuestaModel mostrarEncuesta(@PathVariable Long id) {
        EncuestaModel encuesta = encuestaService.obtenerEncuestaPorId(id);
        List<PreguntaModel> preguntas = encuestaService.obtenerPreguntasPorEncuestaId(id);

        encuesta.setPreguntas(preguntas);
        return encuesta;
    }


    @GetMapping("/mostrar/{id}/preguntas")
    public List<PreguntaModel> mostrarPreguntas(@PathVariable Long id) {
        EncuestaModel encuesta = encuestaService.obtenerEncuestaPorId(id);
        if (encuesta != null) {
            return encuesta.getPreguntas();
        }
        return null;
    }
}
