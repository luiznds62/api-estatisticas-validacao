package com.betha.implementacoes.apiestatisticasvalidacoes.service.validacao;

import com.betha.implementacoes.apiestatisticasvalidacoes.api.v1.exceptions.BadRequestException;
import com.betha.implementacoes.apiestatisticasvalidacoes.api.v1.exceptions.NotFoundException;
import com.betha.implementacoes.apiestatisticasvalidacoes.domain.orm.Validacao;
import com.betha.implementacoes.apiestatisticasvalidacoes.domain.repository.ValidacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ValidacaoServiceImpl implements ValidacaoService {

    private final ValidacaoRepository validacaoRepository;

    private void validate(Validacao validacao) {
        if (validacao.getUuid() == null) {
            throw new BadRequestException("Missing property Uuid");
        }

        if (validacao.getChave() == null) {
            throw new BadRequestException("Missing property Chave");
        }
    }

    @Override
    public Page<Validacao> getAll(
            int page,
            int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "uuid");

        return validacaoRepository.findAll(pageRequest);
    }

    @Override
    public Validacao getById(Integer id) {
        Optional<Validacao> product = validacaoRepository.findById(id);
        if (!product.isPresent()) {
            throw new NotFoundException(id);
        }
        return product.get();
    }

    @Override
    public Validacao getByUuid(String uuid) {
        return validacaoRepository.findByUuid(uuid);
    }

    @Override
    public Page<Validacao> getByIdEntidade(String idEntidade) {
        PageRequest pageRequest = PageRequest.of(
                0,
                5,
                Sort.Direction.DESC,
                "id");

        return validacaoRepository.findByIdEntidade(idEntidade, pageRequest);
    }

    @Override
    public Page<Validacao> getByChave(String chave) {
        PageRequest pageRequest = PageRequest.of(
                0,
                5,
                Sort.Direction.DESC,
                "id");

        return validacaoRepository.findByChave(chave, pageRequest);
    }

    @Override
    public Validacao save(Validacao validacao) {
        validate(validacao);
        validacao.setDataGeracao(new Date().toString());
        return validacaoRepository.save(validacao);
    }

    @Override
    public void delete(Integer id) {
        if (id == 0) {
            throw new BadRequestException("Missing property ID");
        } else {
            Optional<Validacao> validacao = validacaoRepository.findById(id);
            if (!validacao.isPresent()) {
                throw new NotFoundException(id, "Validacao");
            } else {
                validacaoRepository.delete(validacao.get());
            }
        }
    }

    @Override
    public Validacao update(String uuid, Validacao validacao) {
        if (uuid.equals("")) {
            throw new BadRequestException("Missing property uuid");
        }

        validate(validacao);
        Validacao validationUpdate = validacaoRepository.findByUuid(uuid);
        if (validationUpdate == null) {
            throw new NotFoundException(uuid);
        }
        validationUpdate.setUuid(validacao.getUuid());
        validationUpdate.setUsuario(validacao.getUsuario());
        validationUpdate.setIdEntidade(validacao.getIdEntidade());
        validationUpdate.setTextoHtml(validacao.getTextoHtml());
        validationUpdate.setTabelaCorrigida(validacao.getTabelaCorrigida());
        validationUpdate.setParagrafoCorrigido(validacao.getParagrafoCorrigido());
        validationUpdate.setChave(validacao.getChave());
        validationUpdate.setQuantidadeErros(validacao.getQuantidadeErros());
        validationUpdate.setQuantidadeAvisos(validacao.getQuantidadeAvisos());
        validationUpdate.setQuantidadeErrosFixo(validacao.getQuantidadeErrosFixo());
        validationUpdate.setQuantidadeAvisosFixo(validacao.getQuantidadeAvisosFixo());
        validate(validationUpdate);
        return validacaoRepository.save(validationUpdate);
    }
}