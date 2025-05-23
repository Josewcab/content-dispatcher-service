package es.amaru.dispacher.controller;

import es.amaru.dispacher.model.TestPath;
import es.amaru.dispacher.model.enums.PathEnum;
import es.amaru.dispacher.service.TestCalibradorService;
import es.amaru.dispacher.util.DiccionarioDeRutas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestCalibradorController {

    @Autowired
    private final TestCalibradorService testCalibradorService;

    @Autowired
    private final DiccionarioDeRutas diccionarioDeRutas;

    public TestCalibradorController(TestCalibradorService testCalibradorService, DiccionarioDeRutas diccionarioDeRutas) {
        this.testCalibradorService = testCalibradorService;
        this.diccionarioDeRutas = diccionarioDeRutas;
    }

    @GetMapping("/testcalibrador/{path}/{nivel}/{unidad}/{capitulo}")
    public ResponseEntity<TestPath> getTestCalibrador(@PathVariable String path, @PathVariable String nivel, @PathVariable String unidad, @PathVariable String capitulo){

        String fileName = diccionarioDeRutas.obtenerRuta(componerFileName(path, nivel, unidad, capitulo));
        TestPath test = testCalibradorService.obtenerTestCalibrador(fileName);

        return ResponseEntity.ok(test);
    }

    private String seleccionPath (String providedPath){
        return PathEnum.fromDesc(providedPath);
    }

    private String componerFileName(String path, String nivel, String unidad, String capitulo){
        String pathName = seleccionPath(path);
        return nivel + unidad + capitulo + "-TEST-" + pathName;
    }
}
