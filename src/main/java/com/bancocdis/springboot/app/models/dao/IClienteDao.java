package com.bancocdis.springboot.app.models.dao;

import java.util.List;

import com.bancocdis.springboot.app.models.entity.Cliente;

public interface IClienteDao {
	public List<Cliente> findAll();
}
