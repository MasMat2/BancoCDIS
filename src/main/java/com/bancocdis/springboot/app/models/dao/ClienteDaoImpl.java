package com.bancocdis.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bancocdis.springboot.app.models.entity.Cliente;


@Repository
public class ClienteDaoImpl implements IClienteDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	public Cliente findOne(Long id) {
		Cliente cliente = em.find(Cliente.class, id);
		
		if (cliente == null) {
            throw new EntityNotFoundException("No se encontro esa id"
                    + id);
        }
		return cliente;
	}

	@Override
	public Cliente findByPhone(String telefono) {
		// TODO Auto-generated method stub
		return (Cliente) em.createQuery(String.format("from Cliente where numero_telefonico=%s", telefono)).getResultList().get(0);
	}

}
