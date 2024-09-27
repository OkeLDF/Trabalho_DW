package dw.trabalho.futebol.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dw.trabalho.futebol.model.Pagamento;
import dw.trabalho.futebol.repository.PagamentoRepository;

@RestController
public class PagamentoController {
    @Autowired
    PagamentoRepository rep;

    @GetMapping("/pagamento/")
    public ResponseEntity<List<Pagamento>> getAllPagamentos() {
        try {
            List<Pagamento> pagamentos = new ArrayList<>();

            rep.findAll().forEach(pagamentos::add);

            if(pagamentos.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pagamentos, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
