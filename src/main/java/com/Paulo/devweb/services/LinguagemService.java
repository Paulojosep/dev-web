package com.Paulo.devweb.services;

import com.Paulo.devweb.domain.Linguagem;
import com.Paulo.devweb.domain.Usuario;
import com.Paulo.devweb.repositories.LinguagemRepository;
import com.Paulo.devweb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinguagemService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LinguagemRepository repository;

    public List<Linguagem> findAll(Integer id_usu) {
        usuarioService.findById(id_usu);
        return repository.findAllByUsuario(id_usu);
    }

    public Linguagem findById(Integer id) {
        Optional<Linguagem> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Linguagem não econtrado! Id: " + id + "Linguagem: " + Linguagem.class.getName()));
    }

    public Linguagem create(Integer id_usu, Linguagem obj) {
        obj.setId(null);
        Usuario usu = usuarioService.findById(id_usu);
        obj.setUsuario(usu);
        return repository.save(obj);
    }

    public Linguagem update(Integer id, Linguagem obj) {
        Linguagem newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    public void delete(Integer id) {
        Linguagem obj = findById(id);
        repository.delete(obj);
    }

    private void updateData(Linguagem newObj, Linguagem obj) {
        newObj.setNome(obj.getNome());
        newObj.setDescricao(obj.getDescricao());
    }

}
