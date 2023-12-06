package com.project.uywalky.Dto.TransaccionesDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.uywalky.Entity.TransaccionesEntitys.Transacciones;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaccionesDTO {
    @JsonProperty("id_transaccion")
    private int id;
    private Integer paseadorId;
    private Integer propietarioId;
    private Integer tiposTransaccionId;
    private Integer estadoTransaccionId;
    private Integer monto;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer estado;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Timestamp createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Timestamp updatedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer createdBy;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer updatedBy;

    public TransaccionesDTO(Transacciones transacciones){
        this.id = transacciones.getId_transaccion();
        this.paseadorId = transacciones.getPaseadores().getId_paseador();
        this.propietarioId = transacciones.getPropietarios().getId_propietario();
        this.tiposTransaccionId = transacciones.getTiposTransaccion().getId_tipo_transaccion();
        this.estadoTransaccionId = transacciones.getEstadoTransaccion().getId_estado_transaccion();
        this.monto = transacciones.getMonto();
    }

}
