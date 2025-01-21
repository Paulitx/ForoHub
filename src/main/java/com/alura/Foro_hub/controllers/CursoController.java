package com.alura.Foro_hub.controllers;

import com.alura.Foro_hub.dominio.curso.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private ValidacionCursos validacion;

    @PostMapping
    public ResponseEntity<DatosRespuestaCurso> registrarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso,
                                                              UriComponentsBuilder uriComponentsBuilder) {
        Curso curso = cursoRepository.save(new Curso(datosRegistroCurso));
        DatosRespuestaCurso datosRespuestaCurso = new DatosRespuestaCurso(curso.getId(), curso.getNombre(),
                curso.getCategoria(), curso.getStatus());
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaCurso);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoCurso>> listadoCursos(Pageable pageable) {
        return ResponseEntity.ok(cursoRepository.findByStatusTrue(pageable).map(DatosListadoCurso::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarCurso (@RequestBody @Valid DatosActualizarCurso datosActualizarCurso){

        validacion.validarActualizar(datosActualizarCurso);
        Curso curso = cursoRepository.getReferenceById(datosActualizarCurso.id());
        curso.actualizarDatos(datosActualizarCurso);

        return ResponseEntity.ok(new DatosRespuestaCurso(curso.getId(), curso.getNombre(), curso.getCategoria(),
                curso.getStatus()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarCurso(@PathVariable Long id){
        try {
            Curso curso = cursoRepository.getReferenceById(id);
            curso.desactivarCurso();
            String mensaje = "El curso con id '" + id + "' ha sido eliminado correctamente.";
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            String mensajeError = "No se encontró el curso con id '" + id + "'.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaCurso> obtenerCurso(@PathVariable Long id){
        Curso curso = cursoRepository.getReferenceById(id);
        var datosCurso = new DatosRespuestaCurso(curso.getId(), curso.getNombre(), curso.getCategoria(),
                curso.getStatus());
        return ResponseEntity.ok(datosCurso);
    }

}
