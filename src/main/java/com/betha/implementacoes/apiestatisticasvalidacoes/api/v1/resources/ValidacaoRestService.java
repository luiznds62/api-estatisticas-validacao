package com.betha.implementacoes.apiestatisticasvalidacoes.api.v1.resources;

import com.betha.implementacoes.apiestatisticasvalidacoes.api.v1.assembler.ValidacaoModelAssembler;
import com.betha.implementacoes.apiestatisticasvalidacoes.api.v1.model.ValidacaoModel;
import com.betha.implementacoes.apiestatisticasvalidacoes.domain.orm.Validacao;
import com.betha.implementacoes.apiestatisticasvalidacoes.service.validacao.ValidacaoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/arquivo")
public class ValidacaoRestService {

    private final ValidacaoService validacaoService;
    private ValidacaoModelAssembler validacaoModelAssembler;
    private PagedResourcesAssembler<Validacao> pagedResourcesAssembler;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.GET)
    public PagedModel<ValidacaoModel> getAll(
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size) {
        return pagedResourcesAssembler.toModel(validacaoService.getAll(page, size), validacaoModelAssembler);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public Validacao getByUuid(@PathVariable String uuid) {
        return validacaoService.getByUuid(uuid);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/chave/{chave}", method = RequestMethod.GET)
    public Page<Validacao> getByChave(@PathVariable String chave) {
        return validacaoService.getByChave(chave);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ValidacaoModel save(@RequestBody Validacao validacao) {
        return validacaoModelAssembler.toModel(validacaoService.save(validacao));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        validacaoService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{uuid}", method = RequestMethod.PUT)
    public ValidacaoModel update(@PathVariable String uuid, @RequestBody Validacao validacao) {
        return validacaoModelAssembler.toModel(validacaoService.update(uuid,validacao));
    }
}