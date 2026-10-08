package com.example.demov3;

import com.example.demov3.Entities.Factura;
import com.example.demov3.Repositories.FacturaRepository;
import com.example.demov3.Services.FacturaService;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FacturaServiceTests {
    private final FacturaRepository repository = mock(FacturaRepository.class);
    private final FacturaService service = new FacturaService(repository);

    private Factura datos() {
        Factura factura = new Factura();
        factura.setNumero("F-001");
        factura.setCliente("Ana");
        factura.setTotal(125.5);
        factura.setFecha(LocalDate.of(2026, 10, 8));
        return factura;
    }

    @Test
    void crearGeneraUnaEntidadNuevaSinUsarElIdDelCliente() {
        Factura entrada = datos();
        entrada.setId(99L);
        when(repository.save(any(Factura.class))).thenAnswer(call -> {
            Factura nueva = call.getArgument(0);
            assertNull(nueva.getId());
            nueva.setId(1L);
            return nueva;
        });
        Factura creada = service.crear(entrada);
        assertEquals(1L, creada.getId());
        assertEquals("F-001", creada.getNumero());
        assertEquals("Ana", creada.getCliente());
        assertEquals(125.5, creada.getTotal());
        assertEquals(LocalDate.of(2026, 10, 8), creada.getFecha());
    }

    @Test
    void actualizarConservaElIdDeLaRuta() {
        Factura existente = datos();
        existente.setId(1L);
        Factura entrada = datos();
        entrada.setId(99L);
        entrada.setCliente("Luis");
        when(repository.findById(1L)).thenReturn(Optional.of(existente));
        when(repository.save(existente)).thenReturn(existente);
        Factura actualizada = service.actualizar(1L, entrada).orElseThrow();
        assertEquals(1L, actualizada.getId());
        assertEquals("Luis", actualizada.getCliente());
        verify(repository).save(existente);
    }

    @Test
    void actualizarAusenteNoCreaOtraFactura() {
        when(repository.findById(8L)).thenReturn(Optional.empty());
        assertTrue(service.actualizar(8L, datos()).isEmpty());
        verify(repository, never()).save(any());
    }

    @Test
    void eliminarSoloBorraCuandoExiste() {
        when(repository.existsById(1L)).thenReturn(true);
        assertTrue(service.eliminar(1L));
        verify(repository).deleteById(1L);
        assertFalse(service.eliminar(8L));
        verify(repository, never()).deleteById(8L);
    }
}
