package com.betha.implementacoes.apiestatisticasvalidacoes.domain.repository;

import com.betha.implementacoes.apiestatisticasvalidacoes.domain.orm.Validacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidacaoRepository extends JpaRepository<Validacao, Integer> {

    @Query("FROM Validacao c " +
            "WHERE LOWER(c.uuid) like %:searchTerm% " +
            "OR LOWER(c.chave) like %:searchTerm%")
    Page<Validacao> search(
            @Param("searchTerm") String searchTerm,
            Pageable pageable);

    @Query("FROM Validacao c WHERE LOWER(c.uuid) = :searchTerm")
    Validacao findByUuid(
            @Param("searchTerm") String searchTerm);

    @Query("FROM Validacao c WHERE c.chave =:searchTerm")
    Page<Validacao> findByChave(
            @Param("searchTerm") String searchTerm,
            Pageable pageable);

    @Query("FROM Validacao c WHERE LOWER(c.idEntidade) = :searchTerm")
    Page<Validacao> findByIdEntidade(
            @Param("searchTerm") String searchTerm,
            Pageable pageable);

    Page<Validacao> findAll(Pageable pageable);
}