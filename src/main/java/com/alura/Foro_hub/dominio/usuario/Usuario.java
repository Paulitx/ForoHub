package com.alura.Foro_hub.dominio.usuario;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String clave;
    private String email;
    private Boolean status;

    public Usuario(DatosRegistroUsuario d) {
        this.nombre = d.nombre();
        this.clave = d.clave();
        this.email = d.email();
        this.status = true;
    }

    public void registrarUsuario(DatosRegistroUsuario d, String claveEncriptada) {
        this.nombre = d.nombre();
        this.clave = claveEncriptada;
        this.email = d.email();
        this.status = true;
    }

    public void actualizarDatosClave(DatosActualizarUsuario d, String claveEncriptada){
        if(d.nombre() != null){
            this.nombre = d.nombre();
        } else if (d.email() != null) {
            this.email = d.email();
        } else if (d.clave() != null) {
            this.clave = claveEncriptada;
        }
    }

    public void actualizarDatos(DatosActualizarUsuario d){
        if(d.nombre() != null){
            this.nombre = d.nombre();
        } else if (d.email() != null) {
            this.email = d.email();
        }
    }

    public Usuario() {
    }

    public void desactivarUsuario(){
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

        @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return nombre;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
