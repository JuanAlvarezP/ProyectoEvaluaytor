package com.udla.evaluaytor.businessdomain.evaluacion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udla.evaluaytor.businessdomain.evaluacion.models.EstadoFormulario;
import com.udla.evaluaytor.businessdomain.evaluacion.repositories.EstadoFormularioRepository;

@Service
public class EstadoFormularioServiceImpl implements EstadoFormularioService {

    @Autowired
    private EstadoFormularioRepository repository;

    @Override
    public List<EstadoFormulario> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<EstadoFormulario> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public EstadoFormulario save(EstadoFormulario estadoFormulario) {
        return repository.save(estadoFormulario);
    }

    @Override
    public EstadoFormulario updateById(Long id, EstadoFormulario estadoFormulario) {
        if (repository.existsById(id)) {
            estadoFormulario.setId(id);
            return repository.save(estadoFormulario);
        }
        return null; // O lanzar una excepción
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}