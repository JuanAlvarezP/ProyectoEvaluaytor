package com.udla.evaluaytor.businessdomain.evaluacion.services;

import java.util.List;
import java.util.Optional;

import com.udla.evaluaytor.businessdomain.evaluacion.models.EstadoFormulario;

public interface EstadoFormularioService {
    List<EstadoFormulario> findAll();
    Optional<EstadoFormulario> findById(Long id);
    EstadoFormulario save(EstadoFormulario estadoFormulario);
    EstadoFormulario updateById(Long id, EstadoFormulario estadoFormulario);
    void deleteById(Long id);
}