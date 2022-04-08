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

	@Override
	public Tarjeta findOne(Long id) {
		// TODO Auto-generated method stub
		return em.find(Tarjeta.class, id);
	}

	@Override
	public Tarjeta findByNumero(Long numero) {
		// TODO Auto-generated method stub
		return (Tarjeta) em.createQuery(String.format("from Tarjeta where numero_tarjeta=%d", numero)).getResultList().get(0);
	}

	@Override
	public Tarjeta findByCuenta(Long id) {
		// TODO Auto-generated method stub
		return (Tarjeta) em.createQuery(String.format("from Tarjeta where cuenta=%d", id)).getResultList().get(0);
		
	}

}
