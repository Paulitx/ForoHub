package com.alura.Foro_hub.dominio.curso;

import com.alura.Foro_hub.dominio.curso.validaciones.IValidadorActualizarCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidacionCursos {
    @Autowired
    private List<IValidadorActualizarCurso> validadoresActualizar;

    public void validarActualizar(DatosActualizarCurso datosActualizarCurso) {
        validadoresActualizar.forEach(v -> v.validarActualizar(datosActualizarCurso));
    }
}
