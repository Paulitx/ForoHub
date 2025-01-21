package com.alura.Foro_hub.dominio.consulta.validaciones;

import com.alura.Foro_hub.dominio.ValidacionException;
import com.alura.Foro_hub.dominio.consulta.ConsultaRepository;
import com.alura.Foro_hub.dominio.consulta.DatosActualizarConsulta;
import com.alura.Foro_hub.dominio.curso.CursoRepository;
import com.alura.Foro_hub.dominio.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorActualizarConsulta implements  IValidadorActualizarConsulta{

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validarActualizar(DatosActualizarConsulta datosActualizarConsulta) {

        if (datosActualizarConsulta.titulo() != null && datosActualizarConsulta.mensaje() != null) {
            var usuarioMensajeNull = datosActualizarConsulta.mensaje();
            var usuarioTituloNull = datosActualizarConsulta.titulo();
            if(usuarioMensajeNull.isBlank()&& usuarioTituloNull.isBlank()){
                throw new ValidacionException("Ni el mensaje ni el titulo pueden estar vacios, " +
                        "por favor digite los datos validos.");
            }
            var consultaDuplicada = consultaRepository.existsByTituloAndMensajeAndStatusTrue(
                    datosActualizarConsulta.titulo(), datosActualizarConsulta.mensaje());
            if (consultaDuplicada) {
                throw new ValidacionException("Ya existe una consulta con el título '" +
                        datosActualizarConsulta.titulo() + "' y el mensaje '" + datosActualizarConsulta.mensaje() + "'.");
            }
        }

        if (datosActualizarConsulta.curso_id() != null) {
            var cursoExistente = cursoRepository.existsById(datosActualizarConsulta.curso_id());
            if (!cursoExistente) {
                throw new ValidacionException("No existe un curso con el id '" + datosActualizarConsulta.curso_id() + "'.");
            }

            var cursoActivo = cursoRepository.findStatusById(datosActualizarConsulta.curso_id());
            if (!cursoActivo) {
                throw new ValidacionException("No se puede realizar una consulta con el curso '" +
                        datosActualizarConsulta.curso_id() + "', ya que se encuentra deshabilitado.");
            }
        }

        if (datosActualizarConsulta.mensaje() != null) {
            var usuarioMensajeNull = datosActualizarConsulta.mensaje();
            if(usuarioMensajeNull.isBlank()){
                throw new ValidacionException("El mensaje no puede estar vacio, por favor digite un mensaje valido.");
            }
            var consultaConMismoMensaje = consultaRepository.existsByMensajeAndIdNotAndStatusTrue(
                    datosActualizarConsulta.mensaje(), datosActualizarConsulta.id());
            if (consultaConMismoMensaje) {
                throw new ValidacionException("Ya existe una consulta con el mensaje '" + datosActualizarConsulta.mensaje() + "'.");
            }
        }

        if (datosActualizarConsulta.titulo() != null) {
            var usuarioTituloNull = datosActualizarConsulta.titulo();
            if(usuarioTituloNull.isBlank()){
                throw new ValidacionException("El titulo no puede estar vacio, por favor digite un mensaje valido.");
            }
            var consultaConMismoTitulo = consultaRepository.existsByMensajeAndIdNotAndStatusTrue(
                    datosActualizarConsulta.mensaje(), datosActualizarConsulta.id());
            if (consultaConMismoTitulo) {
                throw new ValidacionException("Ya existe una consulta con el titulo '" + datosActualizarConsulta.titulo() + "'.");
            }
        }

    }
}
