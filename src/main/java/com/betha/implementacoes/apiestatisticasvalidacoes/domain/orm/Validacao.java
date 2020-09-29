package com.betha.implementacoes.apiestatisticasvalidacoes.domain.orm;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Validacao {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique=true)
    private String uuid;
    private String nome;
    private String usuario;
    private String idEntidade;
    private String dataGeracao;
    private String textoHtml;
    private String chave;
    private String[] tabelaCorrigida;
    private String[] paragrafoCorrigido;
    private Double quantidadeErros;
    private Double quantidadeAvisos;
    private Double quantidadeErrosFixo;
    private Double quantidadeAvisosFixo;
}
