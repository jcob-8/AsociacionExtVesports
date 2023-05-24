package com.AsociacionExtVesports.AsociacionExtVesports.application.repository;


import com.AsociacionExtVesports.AsociacionExtVesports.domain.RepresentanteSocioJ;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.AsociacionExtVesports.AsociacionExtVesports.domain.Socio;
import java.util.Optional;

public interface SocioRepository extends MongoRepository<Socio, String>{

           Optional<Socio> findById(String id);

	   Socio save(Socio socio);
    
    
}
