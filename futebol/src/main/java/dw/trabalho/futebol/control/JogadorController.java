package dw.trabalho.futebol.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dw.trabalho.futebol.model.Jogador;
import dw.trabalho.futebol.repository.JogadorRepository;

@RestController
public class JogadorController {
    @Autowired
    JogadorRepository rep;

    @GetMapping("/jogador/")
    public ResponseEntity<List<Jogador>> getAllJogadores(@RequestParam(required = false) String nome){
        try {
            List<Jogador> jogadores = new ArrayList<Jogador>();
            if(nome==null){
                rep.findAll().forEach(jogadores::add);
            }
            else {
                rep.findByNomeContaining(nome).forEach(jogadores::add);
            }

            if(jogadores.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/jogador/{id}")
    public ResponseEntity<Jogador> getJogadorById(@PathVariable Long id){
        try {
            Optional<Jogador> data = rep.findById(id);

            if(data.isPresent()){
                return new ResponseEntity<>(data.get(), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/jogador/")
    public ResponseEntity<HttpStatus> createJogador(@RequestBody Jogador jogador){
        try {
            rep.save(jogador);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/jogador/{id}")
    public ResponseEntity<Jogador> updateJogador(@PathVariable Long id, @RequestBody Jogador jogadorRequest){
        try {
            Optional<Jogador> data = rep.findById(id);

            if(data.isPresent()) {
                Jogador jogador = data.get();

                jogador.setNome(jogadorRequest.getNome());
                jogador.setEmail(jogadorRequest.getEmail());
                jogador.setDatanasc(jogadorRequest.getDatanasc());

                return new ResponseEntity<>(rep.save(jogador), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/jogador/{id}")
    public ResponseEntity<HttpStatus> deleteJogador(@PathVariable Long id){
        try {
            Optional<Jogador> jogador = rep.findById(id);
            if(jogador.isPresent()){
                rep.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/jogador/")
    public ResponseEntity<HttpStatus> deleteAllJogadores(){
        try {
            rep.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}