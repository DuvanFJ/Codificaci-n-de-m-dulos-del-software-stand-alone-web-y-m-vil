package com.servigestor360.service;

import com.servigestor360.entity.Reserva;
import com.servigestor360.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // Listar todas las reservas
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    // Guardar nueva reserva
    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Buscar reserva por ID
    public Reserva buscarPorId(Integer id) {
        return reservaRepository.findById(id).orElse(null);
    }

    // Actualizar reserva
    public Reserva actualizarReserva(Integer id, Reserva reservaActualizada) {

        Reserva reserva = reservaRepository.findById(id).orElse(null);

        if (reserva != null) {

            reserva.setNombreSolicitante(reservaActualizada.getNombreSolicitante());
            reserva.setFechaReserva(reservaActualizada.getFechaReserva());
            reserva.setHoraInicio(reservaActualizada.getHoraInicio());
            reserva.setHoraFin(reservaActualizada.getHoraFin());
            reserva.setEstado(reservaActualizada.getEstado());
            reserva.setSala(reservaActualizada.getSala());

            return reservaRepository.save(reserva);
        }

        return null;
    }

    // Eliminar reserva
    public void eliminarReserva(Integer id) {
        reservaRepository.deleteById(id);
    }
}