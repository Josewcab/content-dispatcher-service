package es.amaru.dispacher.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;


@Slf4j
@Component
public class DiccionarioDeRutas {
    @Autowired
    private final ObjectMapper objectMapper;

    @Value("${diccionario-file-name}")
    private String fileName;

    @Getter
    private Map<String, String> rutas = Collections.emptyMap();

    public DiccionarioDeRutas(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void cargarDiccionario(){
        try (InputStream is = new ClassPathResource(fileName).getInputStream()){
            rutas = objectMapper.readValue(is, new TypeReference<>() {});
            log.info("📁 Diccionario cargado con {} rutas", rutas.size());
        } catch (IOException e) {
            log.error("❌ No se pudo cargar el diccionario: {}", e.getMessage() + fileName);
        }
    }

    public String obtenerRuta(String codigo) {
        return rutas.get(codigo);
    }


}
