package com.project.uywalky.Dto.UsuariosDTO;

public class TipoUsuarioDTO {
    private Integer idTipoUsuario;
    private String nombreTipoUsuario;
    private Integer estado;

    public TipoUsuarioDTO() {

    }

    public TipoUsuarioDTO(Integer idTipoUsuario, String nombreTipoUsuario, Integer estado) {
        this.idTipoUsuario = idTipoUsuario;
        this.nombreTipoUsuario = nombreTipoUsuario;
        this.estado = estado;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNombreTipoUsuario() {
        return nombreTipoUsuario;
    }

    public void setNombreTipoUsuario(String nombreTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "TipoUsuarioDTO{" +
                "idTipoUsuario=" + idTipoUsuario +
                ", nombreTipoUsuario='" + nombreTipoUsuario + '\'' +
                ", estado=" + estado +
                '}';
    }
}
