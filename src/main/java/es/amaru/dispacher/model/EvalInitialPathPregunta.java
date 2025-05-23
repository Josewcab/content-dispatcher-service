package es.amaru.dispacher.model;

import lombok.Data;

import java.util.List;

@Data
public class EvalInitialPathPregunta {
    private String preguntaId;
    private String enunciado;
    private String tipo;
    private List<EvalInitialPathRespuesta> opciones;
}
