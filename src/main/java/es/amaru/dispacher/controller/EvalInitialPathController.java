package es.amaru.dispacher.controller;

import es.amaru.dispacher.model.EvalInitialPath;
import es.amaru.dispacher.service.EvalInitialPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvalInitialPathController {

    @Autowired
    EvalInitialPathService service;

    @GetMapping("/initialtest")
    public ResponseEntity<EvalInitialPath> getInitialPath(){
        return ResponseEntity.ok(service.obtenerTestInicial());
    }
}
