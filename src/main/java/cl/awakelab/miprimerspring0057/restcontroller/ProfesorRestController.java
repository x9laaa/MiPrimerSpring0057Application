package cl.awakelab.miprimerspring0057.restcontroller;

import cl.awakelab.miprimerspring0057.entity.Profesor;
import cl.awakelab.miprimerspring0057.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorRestController {
    @Autowired
    IProfesorService objProfesorService;

    @PostMapping
    public Profesor crearProfesor(@RequestBody Profesor nuevoProfesor){
        return objProfesorService.crearProfesor(nuevoProfesor);
    }
    @PutMapping("/{id}")
    public Profesor actualizarProfesor(@PathVariable int id,@RequestBody Profesor profesor){
        return objProfesorService.actualizarProfesor(id,profesor);
    }
    @GetMapping
    public List<Profesor> listarProfesor(){
        return objProfesorService.listarProfesor();
    }
    @GetMapping("/{idProfesor}")
    public Profesor listarProfesorID(@PathVariable int idProfesor){
        return objProfesorService.listarProfesorID(idProfesor);
    }
    @DeleteMapping("/{id}")
    public void eliminarProfesor(@PathVariable int id){
        objProfesorService.eliminarProfesor(id);
    }
    @DeleteMapping
    public void eliminarProfesor2(@RequestBody Profesor profesor){
        objProfesorService.eliminarProfesor2(profesor);
    }
}
