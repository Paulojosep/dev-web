package com.Paulo.devweb.resources;

import com.Paulo.devweb.domain.Linguagem;
import com.Paulo.devweb.dto.LinguagemDTO;
import com.Paulo.devweb.services.LinguagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "linguagens")
public class LinguagemResource {

    @Autowired
    private LinguagemService service;

    @GetMapping // http://localhost:8080/linguagens?usuario=id
    public ResponseEntity<List<LinguagemDTO>> findAll(@RequestParam(value = "usuario", defaultValue = "0") Integer id_usu) {
        List<Linguagem> list = service.findAll(id_usu);
        List<LinguagemDTO> listDTO = list.stream().map(obj -> new LinguagemDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Linguagem> findById(@PathVariable Integer id) {
        Linguagem obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Linguagem> create(@RequestParam(value = "usuario", defaultValue = "0") Integer id_usu,@Valid @RequestBody Linguagem obj) {
        Linguagem newObj = service.create(id_usu,obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/linguagens/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Linguagem> update(@PathVariable Integer id,@Valid @RequestBody Linguagem obj) {
        Linguagem newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
