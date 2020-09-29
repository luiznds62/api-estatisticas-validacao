package com.betha.implementacoes.apiestatisticasvalidacoes.service.product;

import com.betha.implementacoes.apiestatisticasvalidacoes.domain.orm.Validacao;
import org.springframework.data.domain.Page;

public interface ValidacaoService {
    Page<Validacao> getAll(
            int page,
            int size);
    Validacao getById(Integer id);
    Validacao getByUuid(String uuid);
    Page<Validacao> getByIdEntidade(String idEntidade);
    Page<Validacao> getByChave(String chave);
    Validacao save(Validacao validacao);
    Validacao update(String uuid, Validacao validacao);
    void delete(Integer id);
}
