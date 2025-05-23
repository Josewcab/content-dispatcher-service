package es.amaru.dispacher.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.amaru.dispacher.model.EvalInitialPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class EvalInitialPathService {

    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${initial-test.path}")
    private String initalTestpath;

    public EvalInitialPath obtenerTestInicial(){
        try (InputStream in = new ClassPathResource(initalTestpath).getInputStream()){
            return objectMapper.readValue(in, EvalInitialPath.class);
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
