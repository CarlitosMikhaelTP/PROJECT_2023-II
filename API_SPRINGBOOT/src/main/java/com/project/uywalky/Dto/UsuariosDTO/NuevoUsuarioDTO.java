package com.project.uywalky.Dto.UsuariosDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
// En el DTO agregaremos las anotaciones de validación para permitir el correcto
// flujo de peticiones que vayan de acuerdo con el base de datos
public class NuevoUsuarioDTO {

    @NotNull
    @NotBlank
    @Size(max = 20)// Estableciendo el mínimo y máximom de caracteres en Strings
    private String nombres;
    @NotNull
    @NotBlank
    @Size(max = 20)
    private String apellidos;

    @NotNull
    @NotBlank  // No especificamos más porque sus propiedades están definidas en su propio DTO
    private int tipoUsuario;

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String apodo;

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String direccion;

    @NotNull
    @NotBlank
    @Min(value = 18, message = "La edad mínima es 18")
    @Max(value = 80, message = "La edad máxima es 100")
    private Integer edad;

    @NotNull
    @NotBlank
    @Size(max = 9)
    private String celular;

    @NotNull
    @NotBlank
    @Size(max = 8)
    private String dni;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer estado;

    @Override
    public String toString() {
        return "NuevoUsuarioDTO{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", apodo='" + apodo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", estado=" + estado +
                '}';
    }
}

