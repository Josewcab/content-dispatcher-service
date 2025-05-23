package es.amaru.dispacher.model;

import lombok.Data;

import java.util.Map;

@Data
public class EvalInitialPathRespuesta {
    private String texto;
    private boolean esCorrecta;
    private String justificacion;
    private Map<String, Double> pathWeight;
}
