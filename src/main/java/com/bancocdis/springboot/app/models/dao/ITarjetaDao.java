package com.bancocdis.springboot.app.models.dao;

import java.util.List;

import com.bancocdis.springboot.app.models.entity.Tarjeta;


public interface ITarjetaDao {
	
	public List<Tarjeta> findAll();
}
