package es.amaru.dispacher.model;

import lombok.Data;

import java.util.List;

@Data
public class EvalInitialPath {

    private String testId;
    private String version;
    private String titulo;
    private String descripcion;
    private int numeroPreguntas;
    private String fechaCreacion;
    private String autor;
    private List<EvalInitialPathPregunta> preguntas;
}
