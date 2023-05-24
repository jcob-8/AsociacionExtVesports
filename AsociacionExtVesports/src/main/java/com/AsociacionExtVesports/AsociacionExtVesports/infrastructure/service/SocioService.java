package com.AsociacionExtVesports.AsociacionExtVesports.infrastructure.service;

import com.AsociacionExtVesports.AsociacionExtVesports.application.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.AsociacionExtVesports.AsociacionExtVesports.application.repository.SocioRepository;
import com.AsociacionExtVesports.AsociacionExtVesports.domain.Socio;

import java.util.List;

@Service
public class SocioService {

    private final SocioRepository socioRepository;

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public List<Socio> getAllSocios() {
        return socioRepository.findAll();
    }

    public Socio getSocioById(String id) {
        return socioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Socio", "id", id));
    }
    
    public Socio createSocio(Socio socio) {
        return socioRepository.save(socio);
    }

    public Socio updateSocio(String id, Socio socioDetails) {
        Socio socio = getSocioById(id);
        socio.setTipoSocio(socioDetails.getTipoSocio());
        socio.setNivelSocio(socioDetails.getNivelSocio());
        socio.setNombreCompleto(socioDetails.getNombreCompleto());
        socio.setFechaAlta(socioDetails.getFechaAlta());
        socio.setFechaBaja(socioDetails.getFechaBaja());
        socio.setCuotaAlCorriente(socioDetails.getCuotaAlCorriente());

        socio.setFechaNacimiento(socioDetails.getFechaNacimiento());
        socio.setGenero(socioDetails.getGenero());
        socio.setDireccion(socioDetails.getDireccion());
        socio.setTelefono(socioDetails.getTelefono());
        socio.setEmail(socioDetails.getEmail());
        socio.setNacionalidad(socioDetails.getNacionalidad());
        socio.setOtrosDatosRelevantes(socioDetails.getOtrosDatosRelevantes());

        socio.setNivelEstudios(socioDetails.getNivelEstudios());
        socio.setCarrera(socioDetails.getCarrera());
        socio.setInstitucionEducativa(socioDetails.getInstitucionEducativa());
        return socioRepository.save(socio);
    }

    public void deleteSocio(String id) {
        socioRepository.deleteById(id);
    }
}