package com.AsociacionExtVesports.AsociacionExtVesports.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.AsociacionExtVesports.AsociacionExtVesports.domain.OrganoRepreAsociacion;
import java.util.Optional;

public interface OrganoRepository extends MongoRepository<OrganoRepreAsociacion, String> {

    Optional<OrganoRepreAsociacion> findById(String id);

    OrganoRepreAsociacion save(OrganoRepreAsociacion organo);
}
