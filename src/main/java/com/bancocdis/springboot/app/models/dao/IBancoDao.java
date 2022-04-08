package com.bancocdis.springboot.app.models.dao;

import java.util.List;

import com.bancocdis.springboot.app.models.entity.Banco;

public interface IBancoDao {
	public List<Banco> findAll();
}
