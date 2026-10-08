package com.example.demov3.Services;

import com.example.demov3.Entities.Factura;
import com.example.demov3.Repositories.FacturaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {
    private final FacturaRepository repository;

    public FacturaService(FacturaRepository repository) {
        this.repository = repository;
    }

    public Factura crear(Factura datos) {
        Factura factura = new Factura();
        copiarDatos(datos, factura);
        return repository.save(factura);
    }

    public List<Factura> listar() { return repository.findAll(); }

    public Optional<Factura> buscarPorId(Long id) { return repository.findById(id); }

    public Optional<Factura> actualizar(Long id, Factura datos) {
        return repository.findById(id).map(factura -> {
            copiarDatos(datos, factura);
            return repository.save(factura);
        });
    }

    public boolean eliminar(Long id) {
        if (!repository.existsById(id)) { return false; }
        repository.deleteById(id);
        return true;
    }

    private void copiarDatos(Factura origen, Factura destino) {
        destino.setNumero(origen.getNumero());
        destino.setCliente(origen.getCliente());
        destino.setTotal(origen.getTotal());
        destino.setFecha(origen.getFecha());
    }
}
