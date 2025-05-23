package es.amaru.dispacher.model;

import lombok.Data;

import java.util.List;

@Data
public class TestPath {
    private String unidadId;
    private String titulo;
    private String bloqueCurricular;
    private String nivel;
    private int unidad;
    private int capitulo;
    private String tipoEvaluacion;
    private List<PreguntaTest> preguntas;
}
