package com.bancocdis.springboot.app.models.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bancocdis.springboot.app.models.dao.IBancoDao;
import com.bancocdis.springboot.app.models.dao.IClienteDao;
import com.bancocdis.springboot.app.models.dao.ICuentaDao;
import com.bancocdis.springboot.app.models.dao.IEmpleadoDao;
import com.bancocdis.springboot.app.models.dao.ITarjetaDao;

@Controller
public class CuentaController {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IBancoDao bancoDao;
	
	@Autowired
	private ICuentaDao cuentaDao;
	
	@Autowired
	private ITarjetaDao tarjetaDao;
	
	@Autowired
	private IEmpleadoDao empleadoDao;
	
	@RequestMapping(value="/listas", method=RequestMethod.GET)
	public String cuentaLista(Model modelo) {
		modelo.addAttribute("titulo", "Listas");
		modelo.addAttribute("clientes", clienteDao.findAll());
		modelo.addAttribute("bancos", bancoDao.findAll());
		modelo.addAttribute("cuentas", cuentaDao.findAll());
		modelo.addAttribute("tarjetas", tarjetaDao.findAll());
		modelo.addAttribute("empleados", empleadoDao.findAll());
		return "listas";
	}
}
