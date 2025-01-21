package com.alura.Foro_hub.dominio.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private Boolean status;

    public Curso() {
    }

    public Curso(DatosRegistroCurso d) {
        this.nombre = d.nombre();
        this.categoria = d.categoria();
        this.status = true;
    }

    public void actualizarDatos(DatosActualizarCurso d){
        if(d.nombre() != null){
            this.nombre = d.nombre();
        } else if (d.categoria() != null) {
            this.categoria = d.categoria();

        }
    }

    public void desactivarCurso(){
        this.status = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
