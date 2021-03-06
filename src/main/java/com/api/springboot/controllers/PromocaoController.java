package com.api.springboot.controllers;

import com.api.springboot.model.Promocao;
import com.api.springboot.repository.PromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api")
public class PromocaoController {

    @Autowired
    PromocaoRepository promocaoRepository;

    @GetMapping("/certo")
    public String scd(){
        return "A aplicação no heroku funcionou!!!!";
    }

    @GetMapping("/promocoes")
    public List<Promocao> listarPromocoes(){
        return promocaoRepository.findAll();
    }

    @GetMapping("/promocao/{id}")
    public Promocao promocaoById(@PathVariable(value = "id") long  id){
        return promocaoRepository.findById(id);
    }

    @PostMapping("/promocao")
    public Promocao salvarPromocao(@RequestBody Promocao promocao){
        return promocaoRepository.save(promocao);
    }

    @DeleteMapping("/promocao")
    public void deletaPromocao(@RequestBody Promocao promocao){
        promocaoRepository.delete(promocao);
    }

    @DeleteMapping("/promocao/{id}")
    public void deletetById(@PathVariable(value = "id")long id){
        promocaoRepository.deleteById(id);
    }

    @PutMapping("/promocao/put")
    public Promocao atualizarPromocao(@RequestBody Promocao promocao){
        return promocaoRepository.save(promocao);
    }
}
