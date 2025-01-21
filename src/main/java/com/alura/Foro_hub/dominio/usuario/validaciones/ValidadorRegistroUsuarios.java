package com.alura.Foro_hub.dominio.usuario.validaciones;

import com.alura.Foro_hub.dominio.ValidacionException;
import com.alura.Foro_hub.dominio.usuario.DatosRegistroUsuario;
import com.alura.Foro_hub.dominio.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorRegistroUsuarios implements IValidadorRegistroUsuarios{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void validarRegistro(DatosRegistroUsuario datosRegistroUsuario) {
        var usuarioPermitido = usuarioRepository.existsByNombreAndEmailAndStatusTrue(datosRegistroUsuario.nombre(),
                datosRegistroUsuario.email());
        if(usuarioPermitido){
            throw new ValidacionException("No se puede registrar el usuario debido a que el nombre '" +
                    datosRegistroUsuario.nombre() + "' y el email '" + datosRegistroUsuario.email() +
                    "' han sido registrados anteriormente.");
        }
        var usuarioPermitido2 = usuarioRepository.existsByNombreAndStatusTrue(datosRegistroUsuario.nombre());
        if (usuarioPermitido2) {
            throw new ValidacionException("No se puede registrar el usuario debido a que el nombre '" +
                    datosRegistroUsuario.nombre() + "' ha sido registrado anteriormente.");
        }
        var usuarioPermitido3 = usuarioRepository.existsByEmailAndStatusTrue(datosRegistroUsuario.email());
        if (usuarioPermitido3) {
            throw new ValidacionException("No se puede registrar el usuario debido a que el email '" +
                    datosRegistroUsuario.email() + "' ha sido registrado anteriormente.");
        }
    }
}
