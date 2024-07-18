package com.udla.evaluaytor.businessdomain.evaluacion.services;

import java.util.List;
import java.util.Optional;

import com.udla.evaluaytor.businessdomain.evaluacion.models.FormularioEvaluacion;

public interface FormularioEvaluacionService {
    List<FormularioEvaluacion> findAll();
    Optional<FormularioEvaluacion> findById(Long id);
    FormularioEvaluacion save(FormularioEvaluacion formularioEvaluacion);
    FormularioEvaluacion updateById(Long id, FormularioEvaluacion formularioEvaluacion);
    void deleteById(Long id);
    FormularioEvaluacion getFormularioEvaluacion(Long formularioId);
}
