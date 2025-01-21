package com.alura.Foro_hub.dominio.usuario.validaciones;

import com.alura.Foro_hub.dominio.ValidacionException;
import com.alura.Foro_hub.dominio.usuario.DatosActualizarUsuario;
import com.alura.Foro_hub.dominio.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorActualizarUsuario implements IValidadorActualizarUsuario{

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validarActualizar(DatosActualizarUsuario datosActualizarUsuario) {
        if(datosActualizarUsuario.nombre() != null && datosActualizarUsuario.email() != null) {
            var usuarioNombreNull = datosActualizarUsuario.nombre();
            var usuarioEmailNull = datosActualizarUsuario.email();
            if(usuarioNombreNull.isBlank() && usuarioEmailNull.isBlank()){
                throw new ValidacionException("Ni el nombre ni el email pueden estar vacios, " +
                        "por favor digite los datos validos.");
            }
            var usuarioNombreYEmail = usuarioRepository.existsByNombreAndEmailAndStatusTrue(datosActualizarUsuario.nombre(),
                    datosActualizarUsuario.email());
            if (usuarioNombreYEmail) {
                throw new ValidacionException("No se puede actualizar el usuario debido a que el nombre '" +
                        datosActualizarUsuario.nombre() + "' y el email '" + datosActualizarUsuario.email() +
                        "' han sido registrados anteriormente.");
            }
        }
        if(datosActualizarUsuario.id() != null ) {
            var usuarioId = usuarioRepository.existsById(datosActualizarUsuario.id());
            if (!usuarioId) {
                throw new ValidacionException("El id del usuario no existe.");
            }
        }
        if(datosActualizarUsuario.nombre() != null) {
            var usuarioNombreNull = datosActualizarUsuario.nombre();
            if(usuarioNombreNull.isBlank()){
                throw new ValidacionException("El nombre no puede estar vacio, " +
                        "por favor digite un nombre valido.");
            }
            var usuarioNombre = usuarioRepository.existsByNombreAndStatusTrue(datosActualizarUsuario.nombre());
            if (usuarioNombre) {
                throw new ValidacionException("No se puede actualizar el usuario debido a que el nombre '" +
                        datosActualizarUsuario.nombre() + "' ha sido registrado anteriormente.");
            }
        }
        if(datosActualizarUsuario.email() != null) {
            var usuarioEmailNull = datosActualizarUsuario.email();
            if(usuarioEmailNull.isBlank()){
                throw new ValidacionException("El email no puede estar vacio, " +
                        "por favor digite un email valido.");
            }
            var usuarioEmail = usuarioRepository.existsByEmailAndStatusTrue(datosActualizarUsuario.email());
            if (usuarioEmail) {
                throw new ValidacionException("No se puede actualizar el usuario debido a que el email '" +
                        datosActualizarUsuario.email() + "' ha sido registrado anteriormente.");
            }
        }
    }
}
