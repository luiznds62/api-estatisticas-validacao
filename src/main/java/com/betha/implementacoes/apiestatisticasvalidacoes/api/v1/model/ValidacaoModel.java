package com.betha.implementacoes.apiestatisticasvalidacoes.api.v1.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidacaoModel extends RepresentationModel<ValidacaoModel> {
    private Integer id;
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
