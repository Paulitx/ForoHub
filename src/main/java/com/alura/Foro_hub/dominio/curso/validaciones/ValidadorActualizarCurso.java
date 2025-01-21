package com.alura.Foro_hub.dominio.curso.validaciones;

import com.alura.Foro_hub.dominio.ValidacionException;
import com.alura.Foro_hub.dominio.curso.CursoRepository;
import com.alura.Foro_hub.dominio.curso.DatosActualizarCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorActualizarCurso implements IValidadorActualizarCurso{

    @Autowired
    private CursoRepository cursoRepository;

    public void validarActualizar(DatosActualizarCurso datosActualizarCurso) {
        if(datosActualizarCurso.id() != null ) {
            var usuarioId = cursoRepository.existsById(datosActualizarCurso.id());
            if (!usuarioId) {
                throw new ValidacionException("El id del curso no existe.");
            }
        }
        if(datosActualizarCurso.nombre() != null){
            var cursoNombreNull = datosActualizarCurso.nombre();
            if(cursoNombreNull.isBlank()){
                throw new ValidacionException("El nombre no puede estar vacio, " +
                        "por favor digite un nombre valido.");
            }
        }

    }
}
