package com.AsociacionExtVesports.AsociacionExtVesports.infrastructure.service;

import com.AsociacionExtVesports.AsociacionExtVesports.application.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.AsociacionExtVesports.AsociacionExtVesports.application.repository.OrganoRepository;
import com.AsociacionExtVesports.AsociacionExtVesports.domain.OrganoRepreAsociacion;
import org.springframework.stereotype.Service;

@Service
public class OrganoService {

    private final OrganoRepository organoRepository;

    @Autowired
    public OrganoService(OrganoRepository organoRepository) {
        this.organoRepository = organoRepository;
    }

    public List<OrganoRepreAsociacion> getAllOrganos() {
        return organoRepository.findAll();
    }

    public OrganoRepreAsociacion getOrganoById(String id) {
        return organoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Organo", "id", id));
    }

    public OrganoRepreAsociacion createOrgano(OrganoRepreAsociacion organo) {
        return organoRepository.save(organo);
    }

    public OrganoRepreAsociacion updateOrgano(String id, OrganoRepreAsociacion organoDetails) {
    	OrganoRepreAsociacion organo = getOrganoById(id);
        organo.setNombreOrgano(organoDetails.getNombreOrgano());
        organo.setIdSocioRepresentado(organoDetails.getIdSocioRepresentado());
        organo.setFechaTomaPosesion(organoDetails.getFechaTomaPosesion());
        organo.setFechaCese(organoDetails.getFechaCese());
        return organoRepository.save(organo);
    }

    public void deleteOrgano(String id) {
        organoRepository.deleteById(id);
    }
}
