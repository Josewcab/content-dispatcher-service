package es.amaru.dispacher.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.amaru.dispacher.model.UnidadLeccionV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class ContenidoLeccionServiceV1 {

    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();

    public UnidadLeccionV1 obtenerLeccion (String nombreFichero){
        try {
            String ruta = "contenido/" + nombreFichero;
            InputStream inputStream = new ClassPathResource(ruta).getInputStream();
            return objectMapper.readValue(inputStream, UnidadLeccionV1.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
