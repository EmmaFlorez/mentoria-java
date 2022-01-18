package br.com.mentoria.mentoriajava.controller;
import br.com.mentoria.mentoriajava.model.Categoria;
import br.com.mentoria.mentoriajava.model.dto.request.CategoriaRequestDTO;
import br.com.mentoria.mentoriajava.model.dto.response.CategoriaResponseDTO;
import br.com.mentoria.mentoriajava.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;
    @ResponseStatus (HttpStatus.CREATED)
    @PostMapping ("/categorias")
    public CategoriaResponseDTO salvarCategoria(@RequestBody CategoriaRequestDTO categoria){
        return categoriaService.salvarCategoria(categoria);
    }

    @GetMapping ("/categorias/{id}")
    public CategoriaResponseDTO retornarUmaCategoria(@PathVariable Long id){
        return categoriaService.buscarUmaCategoria(id);
    }

    @GetMapping ("/categorias")
    public List<CategoriaResponseDTO> retronarTodasCategorias(){
        return categoriaService.buscarCategorias();
    }

    @PutMapping ("/categorias/{id}")
    public CategoriaResponseDTO atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaRequestDTO categoriaAtualizada){
        return categoriaService.atualizarCategoria(id, categoriaAtualizada);
    }

    @DeleteMapping("/categorias/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void deletarCategoria(@PathVariable Long id){
        categoriaService.deletarCategoria(id);
    }
}