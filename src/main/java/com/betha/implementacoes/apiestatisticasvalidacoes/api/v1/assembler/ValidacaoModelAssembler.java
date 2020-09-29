package com.betha.implementacoes.apiestatisticasvalidacoes.api.v1.assembler;

import com.betha.implementacoes.apiestatisticasvalidacoes.api.v1.model.ValidacaoModel;
import com.betha.implementacoes.apiestatisticasvalidacoes.api.v1.resources.ValidacaoRestService;
import com.betha.implementacoes.apiestatisticasvalidacoes.domain.orm.Validacao;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ValidacaoModelAssembler extends RepresentationModelAssemblerSupport<Validacao, ValidacaoModel> {
    public ValidacaoModelAssembler() {
        super(ValidacaoRestService.class, ValidacaoModel.class);
    }

    @Override
    public ValidacaoModel toModel(Validacao entity) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ValidacaoModel validationModel = createModelWithId(entity.getId(), entity);
        validationModel.setId(entity.getId());
        validationModel.setUuid(entity.getUuid());
        validationModel.setNome(entity.getNome());
        validationModel.setUsuario(entity.getUsuario());
        validationModel.setIdEntidade(entity.getIdEntidade());
        validationModel.setDataGeracao(dateFormat.format(entity.getDataGeracao()));
        validationModel.setTextoHtml(entity.getTextoHtml());
        validationModel.setTabelaCorrigida(entity.getTabelaCorrigida());
        validationModel.setParagrafoCorrigido(entity.getParagrafoCorrigido());
        validationModel.setChave(entity.getChave());
        validationModel.setQuantidadeErros(entity.getQuantidadeErros());
        validationModel.setQuantidadeAvisos(entity.getQuantidadeAvisos());
        validationModel.setQuantidadeErrosFixo(entity.getQuantidadeErrosFixo());
        validationModel.setQuantidadeAvisosFixo(entity.getQuantidadeAvisosFixo());

        return validationModel;
    }
}
