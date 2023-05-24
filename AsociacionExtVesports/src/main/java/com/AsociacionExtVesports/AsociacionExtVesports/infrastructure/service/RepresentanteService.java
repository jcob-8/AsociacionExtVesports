package com.AsociacionExtVesports.AsociacionExtVesports.infrastructure.service;

import com.AsociacionExtVesports.AsociacionExtVesports.application.exceptions.ResourceNotFoundException;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AsociacionExtVesports.AsociacionExtVesports.application.repository.RepresentanteRepository;
import com.AsociacionExtVesports.AsociacionExtVesports.domain.RepresentanteSocioJ;

@Service
public class RepresentanteService {

    private final RepresentanteRepository representanteRepository;

    @Autowired
    public RepresentanteService(RepresentanteRepository representanteRepository) {
        this.representanteRepository = representanteRepository;
    }

    public List<RepresentanteSocioJ> getAllRepresentantes() {
        return representanteRepository.findAll();
    }

    public RepresentanteSocioJ getRepresentanteById(String id) {
        return representanteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Representante", "id", id));
    }

    public RepresentanteSocioJ createRepresentante(RepresentanteSocioJ representante) {
        return representanteRepository.save(representante);
    }

    public RepresentanteSocioJ updateRepresentante(String idRepresentante, RepresentanteSocioJ representanteDetails) {
        RepresentanteSocioJ representante = getRepresentanteById(idRepresentante);
        representante.setNombreCompleto(representanteDetails.getNombreCompleto());
        representante.setIdSocioRepresentado(representanteDetails.getIdSocioRepresentado());
        representante.setTelefono(representanteDetails.getTelefono());
        representante.setEmail(representanteDetails.getEmail());

        RepresentanteSocioJ updatedRepresentante = representanteRepository.save(representante);
        return updatedRepresentante;
    }

    public void deleteRepresentante(String id) {
        representanteRepository.deleteById(id);
    }
}
