package com.servigestor360.controller;

import com.servigestor360.entity.Sala;
import com.servigestor360.service.SalaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping
    public List<Sala> listarSalas() {
        return salaService.listarSalas();
    }

    @GetMapping("/{id}")
    public Sala buscarPorId(@PathVariable Integer id) {
        return salaService.buscarPorId(id);
    }

    @PostMapping
    public Sala guardarSala(@Valid @RequestBody Sala sala) {
        return salaService.guardarSala(sala);
    }

    @PutMapping("/{id}")
    public Sala actualizarSala(
            @PathVariable Integer id,
            @RequestBody Sala sala) {

        return salaService.actualizarSala(id, sala);
    }

    @DeleteMapping("/{id}")
    public void eliminarSala(@PathVariable Integer id) {
        salaService.eliminarSala(id);
    }
}