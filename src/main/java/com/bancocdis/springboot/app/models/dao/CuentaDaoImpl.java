package com.bancocdis.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bancocdis.springboot.app.models.entity.Cuenta;

@Repository
public class CuentaDaoImpl implements ICuentaDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	@Override
	public List<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Cuenta").getResultList();
	}
	
	@Transactional()
	@Override
	public void save(Cuenta cuenta) {
		// TODO Auto-generated method stub
		if(cuenta.getId() != null & cuenta.getId() > 0) {
			em.merge(cuenta);
		}else {
			em.persist(cuenta);
		}
	}

	@Override
	public Cuenta findOne(Long id) {
		// TODO Auto-generated method stub
		return em.find(Cuenta.class, id);
	}

}
