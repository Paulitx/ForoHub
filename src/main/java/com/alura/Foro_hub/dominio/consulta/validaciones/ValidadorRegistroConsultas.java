package com.alura.Foro_hub.dominio.consulta.validaciones;

import com.alura.Foro_hub.dominio.ValidacionException;
import com.alura.Foro_hub.dominio.consulta.ConsultaRepository;
import com.alura.Foro_hub.dominio.consulta.DatosRegistroConsulta;
import com.alura.Foro_hub.dominio.curso.CursoRepository;
import com.alura.Foro_hub.dominio.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorRegistroConsultas  implements IValidadorRegistroConsultas{

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validarRegistro(DatosRegistroConsulta datosRegistroConsulta) {

        var usuarioExistente = usuarioRepository.existsById(datosRegistroConsulta.usuario_id());
        if(!usuarioExistente){
            throw new ValidacionException("No existe un usuario con el id '" + datosRegistroConsulta.usuario_id() + "'.");
        }

        var cursoExistente = cursoRepository.existsById(datosRegistroConsulta.curso_id());
        if(!cursoExistente){
            throw new ValidacionException("No existe un curso con el id '" + datosRegistroConsulta.curso_id() + "'.");
        }

        var usuarioActivo = usuarioRepository.findStatusById(datosRegistroConsulta.usuario_id());
        if(!usuarioActivo){
            throw new ValidacionException("No se puede realizar una consulta con el usuario '" +
                    datosRegistroConsulta.usuario_id() + "', ya que se encuentra desabilitado.");
        }

        var cursoActivo = cursoRepository.findStatusById(datosRegistroConsulta.curso_id());
        if(!cursoActivo){
            throw new ValidacionException("No se puede realizar una consulta con el curso '" +
                    datosRegistroConsulta.curso_id() + "', ya que se encuentra desabilitado.");
        }

        var consultaPermitida = consultaRepository.existsByTituloAndMensajeAndStatusTrue(datosRegistroConsulta.titulo(),
                datosRegistroConsulta.mensaje());
        if(consultaPermitida) {
            throw new ValidacionException("Ya existe una consulta con el titulo '" + datosRegistroConsulta.titulo()
                    + "'" + ", y el mensaje '" + datosRegistroConsulta.mensaje() + "'.");
        }

         var consultaPermitida2 = consultaRepository.existsByMensajeAndStatusTrue(datosRegistroConsulta.mensaje());
        if(consultaPermitida2) {
            throw  new ValidacionException("Ya existe una consulta con el mensaje '" + datosRegistroConsulta.mensaje()
                    + "'.");
        }

    }
}
