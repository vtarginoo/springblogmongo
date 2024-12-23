package com.luke.springblog.repository;

import com.luke.springblog.model.Artigo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ArtigoRepository extends MongoRepository<Artigo,String> {

    public void deleteById(String id);

    public List<Artigo> findByStatusAndDataGreaterThan(Integer status, LocalDateTime data);

    @Query("{ $and: [ {'data': {$gte: ?0}}, {'data': {$lte: ?1}}   ]  }")
    public List<Artigo> obterArtigoPorDataHora (LocalDateTime de, LocalDateTime ate);


    public Page<Artigo> findAll(Pageable pageable);

    public List<Artigo> findByStatusOrderByTituloAsc(Integer status);



}
