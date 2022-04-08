package com.bancocdis.springboot.app.models.dao;

import java.util.List;

import com.bancocdis.springboot.app.models.entity.Cuenta;

public interface ICuentaDao {
	
	public List<Cuenta> findAll();
	
	public void save(Cuenta cuenta);
}
