package com.AsociacionExtVesports.AsociacionExtVesports.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@Document("representantes_socios_jurídicos")
public class RepresentanteSocioJ {
    @Id
    private String id;
    private String nombreCompleto;
    private String idSocioRepresentado;
    private String telefono;
    private String email;
}

