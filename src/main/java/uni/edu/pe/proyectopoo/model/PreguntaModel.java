package uni.edu.pe.proyectopoo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pregunta")
public class PreguntaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pregunta;

    @ElementCollection
    @CollectionTable(name = "opcion")
    private List<String> opciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "encuesta_id")
    private EncuestaModel encuesta;

    public PreguntaModel() {
    }

    public PreguntaModel(String pregunta) {
        this.pregunta = pregunta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public EncuestaModel getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(EncuestaModel encuesta) {
        this.encuesta = encuesta;
    }
}
