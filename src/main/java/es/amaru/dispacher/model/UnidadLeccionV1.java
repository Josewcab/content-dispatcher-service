package es.amaru.dispacher.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnidadLeccionV1 {
    private String unidadId;
    private String titulo;
    private String bloqueCurricular;
    private String nivel;
    private int unidad;
    private int capitulo;
    private String descripcion;
    private List<ContenidoPorPath> paths;
}
