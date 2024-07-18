package com.udla.evaluaytor.businessdomain.evaluacion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udla.evaluaytor.businessdomain.evaluacion.models.EstadoDetalle;
import com.udla.evaluaytor.businessdomain.evaluacion.repositories.EstadoDetalleRepository;

@Service
public class EstadoDetalleServiceImpl implements EstadoDetalleService {

    @Autowired
    private EstadoDetalleRepository repository;

    @Override
    public List<EstadoDetalle> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<EstadoDetalle> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public EstadoDetalle save(EstadoDetalle estadoDetalle) {
        return repository.save(estadoDetalle);
    }

    @Override
    public EstadoDetalle updateById(Long id, EstadoDetalle estadoDetalle) {
        if (repository.existsById(id)) {
            estadoDetalle.setId(id);
            return repository.save(estadoDetalle);
        }
        return null; // O lanzar una excepción
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
