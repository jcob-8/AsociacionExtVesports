package com.AsociacionExtVesports.AsociacionExtVesports.application.controllers;

import org.springframework.web.bind.annotation.*;

import com.AsociacionExtVesports.AsociacionExtVesports.domain.OrganoRepreAsociacion;
import com.AsociacionExtVesports.AsociacionExtVesports.infrastructure.service.OrganoService;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


@Controller
public class OrganoController {
    private final OrganoService organoService;

    public OrganoController(OrganoService organoService) {
        this.organoService = organoService;
    }

    @GetMapping({"/organos"})
    public String getAllOrganos(Model model) {
        model.addAttribute("organos", organoService.getAllOrganos());
        return "organos";
    }
    

    //CREAR
    @GetMapping("/organos/create")
    public String showCreateForm(Model model) {
        OrganoRepreAsociacion organo = new OrganoRepreAsociacion();
        model.addAttribute("organo", organo);
        return "createOrgano";
    }

    @PostMapping("/organos/create")
    public String createOrgano(@ModelAttribute("organos") @Valid OrganoRepreAsociacion organo, BindingResult result) {
        organoService.createOrgano(organo);
        return "redirect:/organos";
    }
        
    
    //EDITAR

    @GetMapping("/organos/edit/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        OrganoRepreAsociacion organo = organoService.getOrganoById(id);
        model.addAttribute("organo", organo);
        return "editOrgano";
    }

    @PostMapping("/organos/edit/{id}")
    public String updateOrgano(@PathVariable("id") String id, @ModelAttribute("organo") @Valid OrganoRepreAsociacion organo, BindingResult result, Model model) {
        organoService.updateOrgano(id, organo);
        model.addAttribute("organos", organoService.getAllOrganos());
        return "redirect:/organos";
    }


    //BORRAR
    @PostMapping("/organos/delete/{id}")
    public String deleteOrgano(@PathVariable("id") String id, Model model) {
        organoService.deleteOrgano(id);
        model.addAttribute("organo", organoService.getAllOrganos());
        return "redirect:/organos";
    }
        

    @DeleteMapping("/organos/{id}")
    public ResponseEntity<?> deleteRepresentante(@PathVariable String id) {
        organoService.deleteOrgano(id);
        return ResponseEntity.ok().build();
    }
}