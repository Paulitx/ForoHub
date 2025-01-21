package com.alura.Foro_hub.controllers;

import com.alura.Foro_hub.dominio.consulta.*;
import com.alura.Foro_hub.dominio.curso.Curso;
import com.alura.Foro_hub.dominio.curso.CursoRepository;
import com.alura.Foro_hub.dominio.usuario.Usuario;
import com.alura.Foro_hub.dominio.usuario.UsuarioRepository;
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
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private ValidacionConsultas validacion;

    @PostMapping
    public ResponseEntity<DatosRespuestaConsulta> registrarConsulta(@RequestBody @Valid DatosRegistroConsulta datosRegistroConsulta,
                                                                    UriComponentsBuilder uriComponentsBuilder) {
        validacion.validarRegistro(datosRegistroConsulta);

        Usuario usuario = usuarioRepository.findById(datosRegistroConsulta.usuario_id()).get();
        Curso curso = cursoRepository.findById(datosRegistroConsulta.curso_id()).get();

        Consulta consulta = new Consulta(datosRegistroConsulta);
        consulta.setUsuario(usuario);
        consulta.setCurso(curso);

        consultaRepository.save(consulta);

        DatosRespuestaConsulta datosRespuestaConsulta = new DatosRespuestaConsulta(consulta.getId(), consulta.getTitulo(),
                consulta.getMensaje(), consulta.getFecha(), consulta.getStatus(), usuario.getId(), usuario.getNombre(),curso.getId(), curso.getNombre());

        URI url = uriComponentsBuilder.path("/consultas/{id}").buildAndExpand(consulta.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaConsulta);

    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoConsulta>> listadoConsultas (@PageableDefault(size = 10) Pageable pageable) {
        Page<Consulta> consultas = consultaRepository.findAllByStatusTrue(pageable);
        Page<DatosListadoConsulta> dtoPage = consultas.map(DatosListadoConsulta::new);
        return ResponseEntity.ok(dtoPage);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarConsulta(@RequestBody @Valid DatosActualizarConsulta datosActualizarConsulta) {

        validacion.validarActualizar(datosActualizarConsulta);

        Consulta consulta = consultaRepository.getReferenceById(datosActualizarConsulta.id());
        consulta.actualizarDatos(datosActualizarConsulta);
        if (datosActualizarConsulta.curso_id() != null) {
            Curso curso = cursoRepository.findById(datosActualizarConsulta.curso_id()).get();
            consulta.setCurso(curso);
        }
        return ResponseEntity.ok(new DatosRespuestaConsulta(consulta.getId(), consulta.getTitulo(), consulta.getMensaje(), consulta.getFecha(),
                consulta.getStatus(), consulta.getUsuario().getId(), consulta.getUsuario().getNombre(), consulta.getCurso().getId(), consulta.getCurso().getNombre()));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarConsulta(@PathVariable Long id) {
        try {
            Consulta consulta = consultaRepository.getReferenceById(id);
            consulta.desactivarConsulta();
            String mensaje = "La consulta con id '" + id + "' ha sido eliminada correctamente.";
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            String mensajeError = "No se encontró la consulta con id '" + id + "'.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaConsulta> consultaPorId(@PathVariable Long id) {
        Consulta consulta = consultaRepository.getReferenceById(id);
        var datosConsulta = new DatosRespuestaConsulta(consulta.getId(), consulta.getTitulo(), consulta.getMensaje(),
                consulta.getFecha(), consulta.getStatus(),consulta.getUsuario().getId(), consulta.getUsuario().getNombre(),
                consulta.getCurso().getId(), consulta.getCurso().getNombre());
        return ResponseEntity.ok(datosConsulta);
    }

}
