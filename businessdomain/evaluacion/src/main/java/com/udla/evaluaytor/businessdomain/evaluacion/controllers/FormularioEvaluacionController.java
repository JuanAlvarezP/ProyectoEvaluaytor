package com.udla.evaluaytor.businessdomain.evaluacion.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udla.evaluaytor.businessdomain.evaluacion.models.EstadoDetalle;
import com.udla.evaluaytor.businessdomain.evaluacion.models.EstadoFormulario;
import com.udla.evaluaytor.businessdomain.evaluacion.models.FormularioEvaluacion;
import com.udla.evaluaytor.businessdomain.evaluacion.services.EstadoDetalleService;
import com.udla.evaluaytor.businessdomain.evaluacion.services.EstadoFormularioService;
import com.udla.evaluaytor.businessdomain.evaluacion.services.FormularioEvaluacionService;

@RestController
@RequestMapping("/api/evaluacion")
public class FormularioEvaluacionController {

    @Autowired
    private FormularioEvaluacionService formularioEvaluacionService;

    @Autowired
    private EstadoFormularioService estadoFormularioService;

    @Autowired
    private EstadoDetalleService estadoDetalleService;

    // Endpoints para FormularioEvaluacion

    @GetMapping("/findall")
    public List<FormularioEvaluacion> findAllFormularios() {
        return formularioEvaluacionService.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public Optional<FormularioEvaluacion> findFormularioById(@PathVariable Long id) {
        return formularioEvaluacionService.findById(id);
    }

    @PostMapping("/save")
    public FormularioEvaluacion saveFormulario(@RequestBody FormularioEvaluacion formularioEvaluacion) {
        return formularioEvaluacionService.save(formularioEvaluacion);
    }

    @PutMapping("/updatebyid/{id}")
    public FormularioEvaluacion updateFormularioById(@PathVariable Long id, @RequestBody FormularioEvaluacion formularioEvaluacion) {
        return formularioEvaluacionService.updateById(id, formularioEvaluacion);
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteFormularioById(@PathVariable Long id) {
        formularioEvaluacionService.deleteById(id);
    }

    // Endpoints para EstadoFormulario

    @GetMapping("/estadoevaluacion/findall")
    public List<EstadoFormulario> findAllEstadoEvaluacion() {
        return estadoFormularioService.findAll();
    }

    @GetMapping("/estadoevaluacion/findbyid/{id}")
    public Optional<EstadoFormulario> findEstadoEvaluacionById(@PathVariable Long id) {
        return estadoFormularioService.findById(id);
    }

    @PostMapping("/estadoevaluacion/save")
    public EstadoFormulario saveEstadoEvaluacion(@RequestBody EstadoFormulario estadoFormulario) {
        return estadoFormularioService.save(estadoFormulario);
    }

    @PutMapping("/estadoevaluacion/updatebyid/{id}")
    public EstadoFormulario updateEstadoEvaluacionById(@PathVariable Long id, @RequestBody EstadoFormulario estadoFormulario) {
        return estadoFormularioService.updateById(id, estadoFormulario);
    }

    @DeleteMapping("/estadoevaluacion/deletebyid/{id}")
    public void deleteEstadoEvaluacionById(@PathVariable Long id) {
        estadoFormularioService.deleteById(id);
    }

    // Endpoints para EstadoDetalle

    @GetMapping("/estadodetalle/findall")
    public List<EstadoDetalle> findAllEstadoDetalle() {
        return estadoDetalleService.findAll();
    }

    @GetMapping("/estadodetalle/findbyid/{id}")
    public Optional<EstadoDetalle> findEstadoDetalleById(@PathVariable Long id) {
        return estadoDetalleService.findById(id);
    }

    @PostMapping("/estadodetalle/save")
    public EstadoDetalle saveEstadoDetalle(@RequestBody EstadoDetalle estadoDetalle) {
        return estadoDetalleService.save(estadoDetalle);
    }

    @PutMapping("/estadodetalle/updatebyid/{id}")
    public EstadoDetalle updateEstadoDetalleById(@PathVariable Long id, @RequestBody EstadoDetalle estadoDetalle) {
        return estadoDetalleService.updateById(id, estadoDetalle);
    }

    @DeleteMapping("/estadodetalle/deletebyid/{id}")
    public void deleteEstadoDetalleById(@PathVariable Long id) {
        estadoDetalleService.deleteById(id);
    }
}
