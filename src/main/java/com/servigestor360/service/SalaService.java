package com.servigestor360.service;

import com.servigestor360.entity.Sala;
import com.servigestor360.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository SalaRepository;

    // Listar todas las salas
    public List<Sala> listarSalas() {
        return SalaRepository.findAll();
    }

    // Guardar una sala
    public Sala guardarSala(Sala sala) {
        return SalaRepository.save(sala);
    }

    // Buscar sala por ID
    public Sala buscarPorId(Integer id) {
        return SalaRepository.findById(id).orElse(null);
    }

    // Actualizar sala
    public Sala actualizarSala(Integer id, Sala salaActualizada) {

        Sala sala = SalaRepository.findById(id).orElse(null);

        if (sala != null) {

            sala.setNombreSala(salaActualizada.getNombreSala());
            sala.setTipoSala(salaActualizada.getTipoSala());
            sala.setCapacidad(salaActualizada.getCapacidad());
            sala.setUbicacion(salaActualizada.getUbicacion());
            sala.setDisponible(salaActualizada.getDisponible());

            return SalaRepository.save(sala);
        }

        return null;
    }

    // Eliminar sala
    public void eliminarSala(Integer id) {
        SalaRepository.deleteById(id);
    }
}