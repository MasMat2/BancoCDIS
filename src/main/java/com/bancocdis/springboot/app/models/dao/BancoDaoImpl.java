package com.bancocdis.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bancocdis.springboot.app.models.entity.Banco;

@Repository
public class BancoDaoImpl implements IBancoDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	@Override
	public List<Banco> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Banco").getResultList();
	}

}
