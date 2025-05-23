package es.amaru.dispacher.model;

import lombok.Data;

@Data
public class ContenidoPorPath {
    private String path;
    private String titulo;
    private String contenidoMarkdown;
    private String evaluacionSugerida;
    private String tono;
}