package es.amaru.dispacher.model;

import lombok.Data;

import java.util.List;

@Data
public class PreguntaTest {
    private String preguntaId;
    private String targetPath;
    private String enunciado;
    private List<OpcionTest> opciones;
    private String tipo;
    private String feedbackCorrecto;
    private String feedbackIncorrecto;
}

