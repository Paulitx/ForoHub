package com.alura.Foro_hub.dominio.usuario;

import com.alura.Foro_hub.dominio.usuario.validaciones.IValidadorActualizarUsuario;
import com.alura.Foro_hub.dominio.usuario.validaciones.IValidadorRegistroUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidacionUsuarios {

    @Autowired
    private List<IValidadorRegistroUsuarios> validadoresRegistros;

    @Autowired
    private List<IValidadorActualizarUsuario> validadoresActualizar;

    public void validarRegistro(DatosRegistroUsuario datosRegistroUsuario) {
        validadoresRegistros.forEach(v -> v.validarRegistro(datosRegistroUsuario));
    }

    public void validarActualizar(DatosActualizarUsuario datosActualizarUsuario) {
        validadoresActualizar.forEach(v -> v.validarActualizar(datosActualizarUsuario));
    }
}
