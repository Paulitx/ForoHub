package com.alura.Foro_hub.dominio.consulta;

import com.alura.Foro_hub.dominio.ValidacionException;
import com.alura.Foro_hub.dominio.consulta.validaciones.IValidadorActualizarConsulta;
import com.alura.Foro_hub.dominio.consulta.validaciones.IValidadorRegistroConsultas;
import com.alura.Foro_hub.dominio.curso.CursoRepository;
import com.alura.Foro_hub.dominio.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidacionConsultas {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired

    private List<IValidadorRegistroConsultas> validadoresRegistros;
    private List<IValidadorActualizarConsulta> validadoresActualizar;

    @Autowired
    public ValidacionConsultas(
            List<IValidadorRegistroConsultas> validadoresRegistros,
            List<IValidadorActualizarConsulta> validadoresActualizar) {
        this.validadoresRegistros = validadoresRegistros;
        this.validadoresActualizar = validadoresActualizar;
    }


    public void validarRegistro(DatosRegistroConsulta datosRegistroConsulta) {
        validadoresRegistros.forEach(v -> v.validarRegistro(datosRegistroConsulta));

    }

    public void validarActualizar(DatosActualizarConsulta datosActualizarConsulta) {
        validadoresActualizar.forEach(v -> v.validarActualizar(datosActualizarConsulta));
    }

}
