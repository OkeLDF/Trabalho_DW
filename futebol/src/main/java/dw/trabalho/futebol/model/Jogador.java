package dw.trabalho.futebol.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property = "cod_jogador")
@Table(name = "jogador", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_jogador;
    
    @Column(nullable = false, length = 60)
    private String nome;
    
    @Column(nullable = false, length = 60)
    private String email;
    
    @Column(nullable = false)
    private LocalDate datanasc;


     @OneToMany(mappedBy = "jogador",cascade = CascadeType.ALL)
    //  @JsonManagedReference
    //  @JsonIgnore
     private List<Pagamento> pagamentos;

    public Jogador(){}

    public Jogador(String nome, String email, LocalDate datanasc) {
        this.nome = nome;
        this.email = email;
        this.datanasc = datanasc;
        // this.pagamentos = null;
    }

    public Jogador(String nome, String email, LocalDate datanasc,List<Pagamento> pagamentos) {
        this.nome = nome;
        this.email = email;
        this.datanasc = datanasc;
        this.pagamentos = pagamentos;
    }


    public Jogador(Long cod_jogador) {
        this.cod_jogador = cod_jogador;
    }

    public Jogador(String nome) {
        this.nome = nome;
    }
    
    public Long getCod_jogador() {
        return cod_jogador;
    }
    public void setCod_jogador(Long cod_jogador) {
        this.cod_jogador = cod_jogador;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getDatanasc() {
        return datanasc;
    }
    public void setDatanasc(LocalDate datanasc) {
        this.datanasc = datanasc;
    }
    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }
    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public void getPagamento(Pagamento pagamento){
        if(pagamentos!= null){
            pagamentos = List.of(pagamento);
        }
    }

    public void addPagamento(Pagamento pagamento){
        this.pagamentos.add(pagamento);
        pagamento.setJogador(this);
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "cod_jogador=" + cod_jogador +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", datanasc=" + datanasc +
                ", pagamentos=" + pagamentos +
                '}';
    }
}
