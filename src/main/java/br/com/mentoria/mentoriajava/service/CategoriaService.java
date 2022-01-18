package br.com.mentoria.mentoriajava.service;

import br.com.mentoria.mentoriajava.model.Categoria;
import br.com.mentoria.mentoriajava.model.dto.request.CategoriaRequestDTO;
import br.com.mentoria.mentoriajava.model.dto.response.CategoriaResponseDTO;
import br.com.mentoria.mentoriajava.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    public CategoriaResponseDTO salvarCategoria(CategoriaRequestDTO categoria){
        Categoria cat = CategoriaRequestDTO.conversor(categoria);
        categoriaRepository.save(cat);
        return new CategoriaResponseDTO(cat);
    }

    public List<CategoriaResponseDTO> buscarCategorias(){
        return CategoriaResponseDTO.converterLista(categoriaRepository.findAll());
    }

    public CategoriaResponseDTO buscarUmaCategoria(Long id) {
        Categoria categoria = categoriaRepository.findById(id).get();
        if(categoria == null){
            throw new EntityNotFoundException("Categoria não existente");
        }
        return new CategoriaResponseDTO(categoriaRepository.findById(id).get());
    }


    public CategoriaResponseDTO atualizarCategoria(Long id, CategoriaRequestDTO cat) {
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(id);
        if(categoriaExistente.isEmpty()){
            throw new EntityNotFoundException("Categoria não existente");
        }
        Categoria categoriaAtualizada = CategoriaRequestDTO.conversor(cat);
        categoriaAtualizada.setId(categoriaExistente.get().getId());
        return new CategoriaResponseDTO(categoriaRepository.save(categoriaAtualizada));
    }

    public void deletarCategoria(Long id){
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(id);
        if(categoriaExistente.isEmpty()){
            throw new EntityNotFoundException("Categoria não existente");
        }
        categoriaRepository.deleteById(id);
    }
}