package com.udla.evaluaytor.businessdomain.evaluacion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.udla.evaluaytor.businessdomain.evaluacion.models.Categoria;
import com.udla.evaluaytor.businessdomain.evaluacion.models.FormularioEvaluacion;
import com.udla.evaluaytor.businessdomain.evaluacion.models.Perito;
import com.udla.evaluaytor.businessdomain.evaluacion.models.Proveedor;
import com.udla.evaluaytor.businessdomain.evaluacion.repositories.FormularioEvaluacionRepository;

import reactor.core.publisher.Mono;

@Service
public class FormularioEvaluacionImp implements FormularioEvaluacionService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private FormularioEvaluacionRepository formularioEvaluacionRepository;

    @Override
    public List<FormularioEvaluacion> findAll() {
        return formularioEvaluacionRepository.findAll();
    }

    @Override
    public Optional<FormularioEvaluacion> findById(Long id) {
        return formularioEvaluacionRepository.findById(id);
    }

    @Override
    public FormularioEvaluacion save(FormularioEvaluacion formularioEvaluacion) {
        return formularioEvaluacionRepository.save(formularioEvaluacion);
    }

    @Override
    public FormularioEvaluacion updateById(Long id, FormularioEvaluacion formularioEvaluacion) {
        if (formularioEvaluacionRepository.existsById(id)) {
            formularioEvaluacion.setId(id);
            return formularioEvaluacionRepository.save(formularioEvaluacion);
        }
        return null; // O lanzar una excepción
    }

    @Override
    public void deleteById(Long id) {
        formularioEvaluacionRepository.deleteById(id);
    }

    @Override
    public FormularioEvaluacion getFormularioEvaluacion(Long formularioId) {
        // Obtén el FormularioEvaluacion desde el repositorio
        FormularioEvaluacion formularioEvaluacion = formularioEvaluacionRepository.findById(formularioId)
            .orElseThrow(() -> new RuntimeException("Formulario no encontrado"));

        // Obtén los IDs de Proveedor y Perito desde el formulario
        Long proveedorId = formularioEvaluacion.getProveedor_id();
        Long categoriaId = formularioEvaluacion.getCategoria_id();
        Long peritoId = formularioEvaluacion.getPerito_id();

        // Llama al microservicio de proveedor para obtener la información del proveedor
        WebClient webClient = webClientBuilder.build();
        Mono<Proveedor> proveedorMono = webClient.get()
            .uri("http://EMPRESA/api/empresa/proveedor/findbyid/{id}", proveedorId)
            .retrieve()
            .bodyToMono(Proveedor.class);
        Proveedor proveedor = proveedorMono.block();
        formularioEvaluacion.setProveedor(proveedor);

        Mono<Categoria> categoriaMono = webClient.get()
            .uri("http://EMPRESA/api/empresa/categoria/findbyid/{id}", categoriaId)
            .retrieve()
            .bodyToMono(Categoria.class);
        Categoria categoria = categoriaMono.block();
        formularioEvaluacion.setCategoria(categoria);

        Mono<Perito> peritoMono = webClient.get()
            .uri("http://EMPRESA/api/empresa/perito/findbyid/{id}", peritoId)
            .retrieve()
            .bodyToMono(Perito.class);
        Perito perito = peritoMono.block();
        formularioEvaluacion.setPerito(perito);
        
        return formularioEvaluacion;
    }
}
