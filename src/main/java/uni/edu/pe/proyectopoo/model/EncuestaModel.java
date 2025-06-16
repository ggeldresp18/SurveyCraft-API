package uni.edu.pe.proyectopoo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "encuesta")
public class EncuestaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "encuesta", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PreguntaModel> preguntas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<PreguntaModel> getPreguntas() {
        return preguntas;
    }

    public EncuestaModel() {
        preguntas = new ArrayList<>();
    }


    public void setPreguntas(List<PreguntaModel> preguntas) {
        this.preguntas = preguntas;
    }
}
