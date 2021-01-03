package com.vsystem.evento.repository;

import org.springframework.data.repository.CrudRepository;

import com.vsystem.evento.model.Usuario;

public interface UserRespository extends CrudRepository<Usuario, Integer> {

}
