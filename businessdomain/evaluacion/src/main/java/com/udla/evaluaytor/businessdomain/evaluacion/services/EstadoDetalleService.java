package com.udla.evaluaytor.businessdomain.evaluacion.services;

import java.util.List;
import java.util.Optional;

import com.udla.evaluaytor.businessdomain.evaluacion.models.EstadoDetalle;

public interface EstadoDetalleService {
    List<EstadoDetalle> findAll();
    Optional<EstadoDetalle> findById(Long id);
    EstadoDetalle save(EstadoDetalle estadoDetalle);
    EstadoDetalle updateById(Long id, EstadoDetalle estadoDetalle);
    void deleteById(Long id);
}
