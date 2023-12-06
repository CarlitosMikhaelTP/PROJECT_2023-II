package com.project.uywalky.Dto.TransaccionesDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoTransaccionDTO {

    private String nombre_estado;
    private String descripcion;
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

}
