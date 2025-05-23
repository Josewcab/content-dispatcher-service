package es.amaru.dispacher.controller;

import es.amaru.dispacher.model.UnidadLeccionV1;
import es.amaru.dispacher.util.DiccionarioDeRutas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import es.amaru.dispacher.service.ContenidoLeccionServiceV1;

@RestController
public class LeccionController {
    @Autowired
    private final ContenidoLeccionServiceV1 contenidoLeccionServiceV1;

    @Autowired
    private final DiccionarioDeRutas diccionarioDeRutas;

    public LeccionController(ContenidoLeccionServiceV1 contenidoLeccionServiceV1, DiccionarioDeRutas diccionarioDeRutas) {
        this.contenidoLeccionServiceV1 = contenidoLeccionServiceV1;
        this.diccionarioDeRutas = diccionarioDeRutas;
    }

    @GetMapping("/lesson/{nivel}/{unidad}/{capitulo}")
    public ResponseEntity<UnidadLeccionV1> getLeccion(@PathVariable String nivel, @PathVariable String unidad, @PathVariable String capitulo){
        String fileName = diccionarioDeRutas.obtenerRuta(nivel+unidad+capitulo);
        UnidadLeccionV1 leccion = contenidoLeccionServiceV1.obtenerLeccion(fileName);
        return ResponseEntity.ok(leccion);
    }
}
