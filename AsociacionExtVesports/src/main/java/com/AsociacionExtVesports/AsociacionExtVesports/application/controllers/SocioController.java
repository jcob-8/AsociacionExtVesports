package com.AsociacionExtVesports.AsociacionExtVesports.application.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.AsociacionExtVesports.AsociacionExtVesports.domain.Socio;
import com.AsociacionExtVesports.AsociacionExtVesports.infrastructure.service.SocioService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SocioController {

    @Autowired
    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @GetMapping
    public List<Socio> getAllSocios() {
        return socioService.getAllSocios();
    }

    @GetMapping("/{id}")
    public Socio getSocioById(@PathVariable String id) {
        return socioService.getSocioById(id);
    }

    @GetMapping({"/socios", "/"})
    public String getSocios(Model model) {
        model.addAttribute("socios", socioService.getAllSocios());
        return "socios";
    }
    
    //CREAR

    @GetMapping("/socios/create")
    public String showCreateForm(Model model) {
        // Crea un nuevo objeto Socio y lo agrega al modelo
        Socio socio = new Socio();
        model.addAttribute("socio", socio);

        // Retorna el nombre de la vista
        return "createSocio";
    }

    @PostMapping("/socios/create")
    public String createSocio(@ModelAttribute("socio") Socio socio) {
        // Usa el servicio para guardar el nuevo Socio
        socioService.createSocio(socio);

        // Redirige al usuario a la lista de socios
        return "redirect:/socios";
    }
    
    //EDITAR

    @GetMapping("/socios/edit/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        Socio socio = socioService.getSocioById(id);
        if (socio == null) {
            throw new IllegalArgumentException("Id de socio inválido:" + id);
        }

        model.addAttribute("socio", socio);
        return "editSocio";
    }

    @PostMapping("/socios/edit/{id}")
    public String updateSocio(@PathVariable("id") String id, @ModelAttribute("socio") @Valid Socio socio, BindingResult result, Model model) {
       /* if (result.hasErrors()) {
            return "editSocio";
        }*/

        socioService.updateSocio(id, socio);

        model.addAttribute("socios", socioService.getAllSocios());
        return "redirect:/socios";
    }

    @PutMapping("/socios/{id}")
    public Socio updateSocio(@PathVariable String id, @RequestBody Socio socioDetails) {
        return socioService.updateSocio(id, socioDetails);
    }

    @PostMapping("/socios/delete/{id}")
    public String deleteSocio(@PathVariable("id") String id, Model model) {
        socioService.deleteSocio(id);

        model.addAttribute("socio", socioService.getAllSocios());
        return "redirect:/socios";
    }

    @DeleteMapping("/socios/{id}")
    public ResponseEntity<?> deleteSocio(@PathVariable String id) {
        socioService.deleteSocio(id);
        return ResponseEntity.ok().build();
    }
}
