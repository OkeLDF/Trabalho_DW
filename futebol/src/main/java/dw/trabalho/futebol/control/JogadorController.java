package dw.trabalho.futebol.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dw.trabalho.futebol.model.Jogador;
import dw.trabalho.futebol.repository.JogadorRepository;

@RestController
public class JogadorController {
    @Autowired
    JogadorRepository rep;

    // http://localhost:8000/futebol
    @GetMapping("/")
    public ResponseEntity<List<Jogador>> getAllJogadores(@RequestParam(required = false) String nome){
        try {
            List<Jogador> lj = new ArrayList<Jogador>();
            if(nome==null){
                rep.findAll().forEach(lj::add);
            }
            else {
                rep.findByNomeContaining(nome).forEach(lj::add);
            }

            if(lj.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
