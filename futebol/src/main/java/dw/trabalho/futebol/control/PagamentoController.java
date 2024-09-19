package dw.trabalho.futebol.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import dw.trabalho.futebol.repository.PagamentoRepository;

@RestController
public class PagamentoController {
    @Autowired
    PagamentoRepository rep;
}
