package dw.trabalho.futebol.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogador")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_jogador;
    
    @Column(nullable = false, length = 60)
    private String nome;
    
    @Column(nullable = false, length = 60)
    private String email;
    
    @Column(nullable = false)
    private Date datanasc;

    @OneToMany(mappedBy = "jogador")
    private List<Pagamento> pagamentos;
    
    public long getCod_jogador() {
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
    public Date getDatanasc() {
        return datanasc;
    }
    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }
    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }
    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }
}
