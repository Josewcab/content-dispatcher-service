package es.amaru.dispacher.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.amaru.dispacher.model.TestPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class TestCalibradorService {

    @Autowired
    private final ObjectMapper objectMapper;

    public TestCalibradorService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public TestPath obtenerTestCalibrador(String fileName){

        try (InputStream is = new ClassPathResource("contenido/" + fileName).getInputStream()){
            return objectMapper.readValue(is, TestPath.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
