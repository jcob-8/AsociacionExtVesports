package com.AsociacionExtVesports.AsociacionExtVesports.application.controllers;

import org.springframework.web.bind.annotation.*;


import com.AsociacionExtVesports.AsociacionExtVesports.domain.RepresentanteSocioJ;
import com.AsociacionExtVesports.AsociacionExtVesports.infrastructure.service.RepresentanteService;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class RepresentanteController {

    private final RepresentanteService representanteService;

    public RepresentanteController(RepresentanteService representanteService) {
        this.representanteService = representanteService;
    }

    @GetMapping({"/representantes"})
    public String getAllRepresentantes(Model model) {
        model.addAttribute("representantes", representanteService.getAllRepresentantes());
        return "representantes";
    }

    //CREAR
    @GetMapping("/representantes/create")
    public String showCreateForm(Model model) {
        model.addAttribute("representante", new RepresentanteSocioJ());
        return "createRepresentante";
    }

    @PostMapping("/representantes/create")
    public String createRepresentante(@ModelAttribute("representantes") RepresentanteSocioJ representante) {
        representanteService.createRepresentante(representante);
        return "redirect:/representantes";
    }
    

    // EDITAR
    @GetMapping("/representantes/edit/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        RepresentanteSocioJ representante = representanteService.getRepresentanteById(id);
        model.addAttribute("representante", representante);
        return "editRepresentante";
    }

    @PostMapping("/representantes/edit/{id}")
    public String updateRepresentante(@PathVariable("id") String id, @ModelAttribute("representante") RepresentanteSocioJ representante, Model model) {
        representanteService.updateRepresentante(id, representante);
        model.addAttribute("representantes", representanteService.getAllRepresentantes());
        return "redirect:/representantes";
    }
    

    //BORRAR
    @PostMapping("/representantes/delete/{id}")
    public String deleteRepresentante(@PathVariable("id") String id, Model model) {
        representanteService.deleteRepresentante(id);
        model.addAttribute("representate", representanteService.getAllRepresentantes());
        return "redirect:/representantes";
    }
    

    @DeleteMapping("/representantes/{id}")
    public ResponseEntity<?> deleteRepresentante(@PathVariable String id) {
        representanteService.deleteRepresentante(id);
        return ResponseEntity.ok().build();
    }
}