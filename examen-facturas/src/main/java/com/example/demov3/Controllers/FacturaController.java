package com.example.demov3.Controllers;

import com.example.demov3.Entities.Factura;
import com.example.demov3.Services.FacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
    private final FacturaService service;

    public FacturaController(FacturaService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Factura> crear(@RequestBody Factura factura) {
        return ResponseEntity.status(201).body(service.crear(factura));
    }

    @GetMapping
    public List<Factura> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> actualizar(@PathVariable Long id, @RequestBody Factura factura) {
        return service.actualizar(id, factura).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return service.eliminar(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
