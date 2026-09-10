package com.example.sis414recetas.Controllers;

import com.example.sis414recetas.Models.RecetaModel;
import com.example.sis414recetas.Models.TiempoModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/receta")
public class RecetaController {

    private static List<RecetaModel> recetas = new ArrayList<>();

    static {
        TiempoModel tiempoInicial = new TiempoModel("30 minutos", "Fácil");
        recetas.add(new RecetaModel("Salteña Paceña", "Desayuno", tiempoInicial));
    }

    @GetMapping
    public List<RecetaModel> obtenerRecetas() {
        return recetas;
    }

    @PostMapping
    public RecetaModel guardarReceta(@RequestBody RecetaModel receta) {
        recetas.add(receta);
        return receta;
    }

    @PatchMapping
    public String actualizarParcialReceta(@RequestBody RecetaModel recetaConCambios) {
        for (RecetaModel r : recetas) {
            if (r.getNombrePlato().equalsIgnoreCase(recetaConCambios.getNombrePlato())) {
                if (recetaConCambios.getTiempo() != null) {
                    r.setTiempo(recetaConCambios.getTiempo());
                }
                return "Receta actualizada parcialmente con éxito";
            }
        }
        return "No se encontró la receta para actualizar";
    }

    @DeleteMapping
    public String eliminarReceta(@RequestBody RecetaModel recetaABorrar) {
        boolean eliminado = recetas.removeIf(r ->
                r.getNombrePlato().equalsIgnoreCase(recetaABorrar.getNombrePlato())
        );

        if (eliminado) {
            return "Objeto eliminado con éxito";
        }
        return "No se encontró el objeto especificado para eliminar";
    }
}