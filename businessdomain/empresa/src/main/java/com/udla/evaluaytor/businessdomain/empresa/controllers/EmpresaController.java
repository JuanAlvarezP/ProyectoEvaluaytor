package com.udla.evaluaytor.businessdomain.empresa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udla.evaluaytor.businessdomain.empresa.dto.ProveedorDTO;
import com.udla.evaluaytor.businessdomain.empresa.dto.ProveedorResponseDTO;
import com.udla.evaluaytor.businessdomain.empresa.models.Categoria;
import com.udla.evaluaytor.businessdomain.empresa.models.Perito;
import com.udla.evaluaytor.businessdomain.empresa.repositories.CategoriaRepository;
import com.udla.evaluaytor.businessdomain.empresa.repositories.EmpresaRepository;
import com.udla.evaluaytor.businessdomain.empresa.repositories.PeritoRepository;
import com.udla.evaluaytor.businessdomain.empresa.repositories.ProveedorRepository;
import com.udla.evaluaytor.businessdomain.empresa.services.ProveedorService;




@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {
    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    ProveedorRepository proveedorRepository;

    @Autowired
    PeritoRepository peritoRepository;

    @Autowired 
    CategoriaRepository categoriaRepository;

    @Autowired
    private ProveedorService proveedorService;


  /* 
    // Listar todo
    @GetMapping("/findall")
    public List<Empresa> listarEmpresa() {
        return empresaRepository.findAll();
    }


    // Listar por Id
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Empresa> obtenerEmpresaPorId(@PathVariable Long id) {
        Optional<Empresa> premioOptional = empresaRepository.findById(id);
        return premioOptional.map(premio -> new ResponseEntity<>(premio, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear una nueva empresa
    @PostMapping("/save")
    public ResponseEntity<Empresa> crearEmpresa(@RequestBody Empresa nuevoPremio) {
        Empresa premioGuardado = empresaRepository.save(nuevoPremio);
        return new ResponseEntity<>(premioGuardado, HttpStatus.CREATED);
    }

    // Actualizar empresa
    @PutMapping("/updatebyid/{id}")
    public ResponseEntity<Empresa> actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresaActual) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        return empresaOptional.map(empresa -> {
            empresa.setId(id);
            empresa.setNombre(empresaActual.getNombre());
            empresa.setDireccion(empresaActual.getDireccion());
            Empresa empresaActualGuardado = empresaRepository.save(empresa);
            return new ResponseEntity<>(empresaActualGuardado, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar un empresa por ID
    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<Void> eliminarEmpresa(@PathVariable Long id) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        if (empresaOptional.isPresent()) {
            empresaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

*/

    //PROVEEDOR//////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping("proveedor/findall")
    public ResponseEntity<List<ProveedorResponseDTO>> getAllProveedores() {
        List<ProveedorResponseDTO> proveedores = proveedorService.getAllProveedores();
        return ResponseEntity.ok(proveedores);
    }

    @GetMapping("proveedor/findbyid/{id}")
     public ResponseEntity<ProveedorResponseDTO> getProveedorById(@PathVariable Long id) {
        ProveedorResponseDTO proveedor = proveedorService.getProveedorById(id);
        return ResponseEntity.ok(proveedor);
    }

    // Crear una nuevo proveedor
    @PostMapping("/proveedor/save")
    public ResponseEntity<ProveedorResponseDTO> createProveedor(@RequestBody ProveedorDTO proveedorDTO) {
        ProveedorResponseDTO proveedorGuardado = proveedorService.createProveedor(proveedorDTO);
        return new ResponseEntity<>(proveedorGuardado, HttpStatus.CREATED);
    }
      
    @PutMapping("/proveedor/updatebyid/{id}")
    public ResponseEntity<ProveedorResponseDTO> updateProveedor(@PathVariable Long id, @RequestBody ProveedorDTO proveedorUpdateDTO) {
        ProveedorResponseDTO updatedProveedor = proveedorService.updateProveedor(id, proveedorUpdateDTO);
        return ResponseEntity.ok(updatedProveedor);
    }

    @DeleteMapping("/proveedor/deletebyid/{id}")
    public ResponseEntity<Void> deleteProveedorById(@PathVariable Long id) {
        proveedorService.deleteProveedorById(id);
        return ResponseEntity.noContent().build();
    }

     //PERITO//////////////////////////////////////////////////////////////////////////////////////////

    
    @GetMapping("/perito/findall")
    public List<Perito> listarPerito() {
        return peritoRepository.findAll();
    }

    @GetMapping("perito/findbyid/{id}")
    public ResponseEntity<Perito> getPeritoById(@PathVariable Long id) {
        Optional<Perito> peritoOptional = peritoRepository.findById(id);
        return peritoOptional.map(perito -> new ResponseEntity<>(perito, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/perito/save")
    public ResponseEntity<Perito> crearPerito(@RequestBody Perito nuevoPerito) {
        Perito peritoGuardado = peritoRepository.save(nuevoPerito);
        return new ResponseEntity<>(peritoGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/perito/updatebyid/{id}")
    public ResponseEntity<Perito> actualizarPerito(@PathVariable Long id, @RequestBody Perito peritoActual) {
        Optional<Perito> peritoOptional = peritoRepository.findById(id);
        return peritoOptional.map(perito -> {
            perito.setId(id);
            perito.setNombre(peritoActual.getNombre());
            perito.setDireccion(peritoActual.getDireccion());
            Perito peritoActualGuardado = peritoRepository.save(perito);
            return new ResponseEntity<>(peritoActualGuardado, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/perito/deletebyid/{id}")
    public ResponseEntity<Void> eliminarPerito(@PathVariable Long id) {
        Optional<Perito> peritoOptional = peritoRepository.findById(id);
        if (peritoOptional.isPresent()) {
            peritoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //CATEGORIA//////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/categoria/findall")
    public List<Categoria> listarCategoria() {
        return categoriaRepository.findAll();
    }


    @GetMapping("categoria/findbyid/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        return categoriaOptional.map(categoria -> new ResponseEntity<>(categoria, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/categoria/save")
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria nuevaCategoria) {
        Categoria categoriaGuardada = categoriaRepository.save(nuevaCategoria);
        return new ResponseEntity<>(categoriaGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/categoria/updatebyid/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoriaActual) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        return categoriaOptional.map(categoria -> {
            categoria.setId(id);
            categoria.setDescripcion(categoriaActual.getDescripcion());
            Categoria categoriaActualGuardado = categoriaRepository.save(categoria);
            return new ResponseEntity<>(categoriaActualGuardado, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/categoria/deletebyid/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isPresent()) {
            categoriaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

