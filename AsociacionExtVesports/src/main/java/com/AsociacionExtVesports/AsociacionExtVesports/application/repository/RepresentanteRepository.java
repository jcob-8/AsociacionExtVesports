package com.AsociacionExtVesports.AsociacionExtVesports.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.AsociacionExtVesports.AsociacionExtVesports.domain.RepresentanteSocioJ;
import java.util.Optional;


public interface RepresentanteRepository extends MongoRepository<RepresentanteSocioJ, String>{ 

	   Optional<RepresentanteSocioJ> findById(String id);
	   RepresentanteSocioJ save(RepresentanteSocioJ socio);

}
