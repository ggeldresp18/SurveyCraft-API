package uni.edu.pe.proyectopoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.edu.pe.proyectopoo.model.RespuestaModel;
import uni.edu.pe.proyectopoo.service.RespuestaService;

@RestController
@RequestMapping("/api/respuesta")
public class RespuestaController {
    private final RespuestaService respuestaService;

    @Autowired
    public RespuestaController(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    @PostMapping
    public ResponseEntity<String> guardarRespuesta(@RequestBody RespuestaModel request) {
        RespuestaModel respuestaGuardada = respuestaService.guardarRespuesta(request);
        if (respuestaGuardada != null) {
            return ResponseEntity.ok("Respuesta guardada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la respuesta");
        }
    }
}
