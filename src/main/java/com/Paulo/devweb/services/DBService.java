package com.Paulo.devweb.services;

import com.Paulo.devweb.domain.Linguagem;
import com.Paulo.devweb.domain.Usuario;
import com.Paulo.devweb.repositories.LinguagemRepository;
import com.Paulo.devweb.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LinguagemRepository linguagemRepository;

    public void iniciaBaseDeDados() {
        Usuario usuario1 = new Usuario(null, "Paulo Modesto", "paulo@gmail.com");
        Usuario usuario2 = new Usuario(null, "Telma Modesto", "telma@gmail.com");
        Usuario usuario3 = new Usuario(null, "Cleber Modesto", "cleber@gmail.com");

        Linguagem linguagem1 = new Linguagem(null, "Java", "Linguagem Java", usuario1);
        Linguagem linguagem2 = new Linguagem(null, "C", "Linguagem C", usuario1);
        Linguagem linguagem3 = new Linguagem(null, "Python", "Linguagem Python", usuario3);
        Linguagem linguagem4 = new Linguagem(null, "C#", "Linguagem C#", usuario1);
        Linguagem linguagem5 = new Linguagem(null, "JavaScript", "Linguagem JavaScript", usuario1);
        //Linguagem linguagem6 = new Linguagem(null, "TypeScript", "Linguagem TypScript", usuario2);

        usuario1.getLinguagems().addAll(Arrays.asList(linguagem1,linguagem2,linguagem4,linguagem5));
        usuario2.getLinguagems().addAll(Arrays.asList(linguagem3));

        usuarioRepository.saveAll(Arrays.asList(usuario1,usuario2,usuario3));
        linguagemRepository.saveAll(Arrays.asList(linguagem1,linguagem2,linguagem3,linguagem4,linguagem5));

    }
}
