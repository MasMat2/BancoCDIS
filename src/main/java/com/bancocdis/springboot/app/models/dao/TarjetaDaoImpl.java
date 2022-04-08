package com.bancocdis.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bancocdis.springboot.app.models.entity.Tarjeta;

@Repository
public class TarjetaDaoImpl implements ITarjetaDao {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	@Override
	public List<Tarjeta> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Tarjeta").getResultList();
	}

}
