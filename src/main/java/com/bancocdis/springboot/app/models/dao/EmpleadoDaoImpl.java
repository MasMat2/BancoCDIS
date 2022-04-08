package com.bancocdis.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bancocdis.springboot.app.models.entity.Empleado;

@Repository
public class EmpleadoDaoImpl implements IEmpleadoDao {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Empleado").getResultList();
	}

}
