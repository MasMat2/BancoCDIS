package com.bancocdis.springboot.app.models.dao;

import java.util.List;

import com.bancocdis.springboot.app.models.entity.Empleado;

public interface IEmpleadoDao {
	public List<Empleado> findAll();
}
