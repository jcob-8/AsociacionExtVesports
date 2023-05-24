package com.AsociacionExtVesports.AsociacionExtVesports.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document("organos_de_representacion_de_la_asociacion")
public class OrganoRepreAsociacion {
    @Id
    private String id;
    private String nombreOrgano;
    private String idSocioRepresentado;
    private Date fechaTomaPosesion;
    private Date fechaCese;
}



