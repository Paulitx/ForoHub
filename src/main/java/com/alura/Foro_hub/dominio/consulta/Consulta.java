package com.alura.Foro_hub.dominio.consulta;

import com.alura.Foro_hub.dominio.curso.Curso;
import com.alura.Foro_hub.dominio.curso.DatosActualizarCurso;
import com.alura.Foro_hub.dominio.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table (name = "consultas")
@Entity (name = "Consulta")
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private Boolean status;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "usuario_id")
    private Usuario usuario;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "curso_id")
    private Curso curso;

    public Consulta() {
    }

    public Consulta(DatosRegistroConsulta d) {
        this.titulo = d.titulo();
        this.mensaje = d.mensaje();
        this.fecha = LocalDateTime.now();
        this.status = true;
        this.usuario = usuario;
        this.curso = curso;

    }

    public void actualizarDatos(DatosActualizarConsulta d){
        if(d.titulo() != null){
            this.titulo = d.titulo();
        } else if (d.mensaje() != null) {
            this.mensaje = d.mensaje();
        } else if (d.curso_id() != null) {
            this.curso = curso;

        }
    }

    public void desactivarConsulta(){
        this.status = false;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Boolean getStatus() {
        return status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
