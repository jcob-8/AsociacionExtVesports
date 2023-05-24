package com.AsociacionExtVesports.AsociacionExtVesports.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "socios")
public class Socio {
    @Id
    private String id;
    private String tipoSocio;
    private String nivelSocio;
    private String nombreCompleto;
    private Date fechaAlta;
    private Date fechaBaja;
    private String cuotaAlCorriente;

    
    // Información sociodemográfica
    private Date fechaNacimiento;
    private String genero;
    private String direccion;
    private String telefono;
    private String email;
    private String nacionalidad;
    private String otrosDatosRelevantes;
    
    // Información académica
    private String nivelEstudios;
    private String carrera;
    private String institucionEducativa;
}

