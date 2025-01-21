package com.alura.Foro_hub.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import com.alura.Foro_hub.dominio.usuario.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ValidacionUsuarios validacion;

    private Usuario usuario = new Usuario();
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario, UriComponentsBuilder uriComponentsBuilder) {

        validacion.validarRegistro(datosRegistroUsuario);

        String claveEncriptada = encoder.encode(datosRegistroUsuario.clave());
        usuario.registrarUsuario(datosRegistroUsuario, claveEncriptada);
        usuarioRepository.save(usuario);
        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(usuario.getId(), usuario.getNombre(),
                usuario.getEmail(), usuario.getStatus());
        URI url = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaUsuario);

    }

    @GetMapping
    public ResponseEntity <Page<DatosListadoUsuario>> listarUsuarios(@PageableDefault (size=10) Pageable pageable){
        return ResponseEntity.ok(usuarioRepository.findByStatusTrue(pageable).map(DatosListadoUsuario::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario){

        validacion.validarActualizar(datosActualizarUsuario);

        usuario = usuarioRepository.getReferenceById(datosActualizarUsuario.id());
        if(datosActualizarUsuario.clave() != null){
            String claveEncriptada = encoder.encode(datosActualizarUsuario.clave());
            usuario.actualizarDatosClave(datosActualizarUsuario, claveEncriptada);
        } else {
             usuario.actualizarDatos(datosActualizarUsuario);
        }
        return ResponseEntity.ok(new DatosRespuestaUsuario(usuario.getId(), usuario.getNombre(), usuario.getEmail(),
                usuario.getStatus()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarUsuario(@PathVariable Long id){
        try {
            Usuario usuario = usuarioRepository.getReferenceById(id);
            usuario.desactivarUsuario();
            String mensaje = "El usuario con id '" + id + "' ha sido eliminado correctamente.";
            return ResponseEntity.ok(mensaje);

        } catch (EntityNotFoundException e) {
            String mensajeError = "No se encontró el usuario con id '" + id + "'.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaUsuario> getUsuario(@PathVariable Long id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        var datosUsuario = new DatosRespuestaUsuario(usuario.getId(), usuario.getNombre(), usuario.getEmail()
                , usuario.getStatus());
        return ResponseEntity.ok(datosUsuario);
    }

}
