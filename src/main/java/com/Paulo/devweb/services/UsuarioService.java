package com.Paulo.devweb.services;

import com.Paulo.devweb.domain.Usuario;
import com.Paulo.devweb.dto.UsuarioDTO;
import com.Paulo.devweb.repositories.UsuarioRepository;
import com.Paulo.devweb.services.exceptions.DataIntegrityViolationException;
import com.Paulo.devweb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario findById(Integer id) {
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id " + id + ", " + Usuario.class.getName()));
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario create(Usuario obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Usuario update(Integer id, UsuarioDTO objDTO) {
        Usuario obj = findById(id);
        obj.setNome(objDTO.getNome());
        obj.setEmail(objDTO.getEmail());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Usuario não pode ser deletado!");
        }
    }
}
