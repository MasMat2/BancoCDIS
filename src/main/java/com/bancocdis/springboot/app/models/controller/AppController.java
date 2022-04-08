package com.bancocdis.springboot.app.models.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bancocdis.springboot.app.models.dao.IBancoDao;
import com.bancocdis.springboot.app.models.dao.IClienteDao;
import com.bancocdis.springboot.app.models.dao.ICuentaDao;
import com.bancocdis.springboot.app.models.dao.IEmpleadoDao;
import com.bancocdis.springboot.app.models.dao.ITarjetaDao;
import com.bancocdis.springboot.app.models.entity.Banco;
import com.bancocdis.springboot.app.models.entity.Cliente;
import com.bancocdis.springboot.app.models.entity.Empleado;
import com.bancocdis.springboot.app.models.entity.Tarjeta;


@Controller
public class AppController {
	
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
	
	@RequestMapping(value="cliente/telefono/{numero}", method=RequestMethod.GET)
	public String editarClienteTelefono(@PathVariable(value="numero") String numero, Map<String, Object> modelo) {
		Cliente cliente;
		
		if(numero.length()>0) {
			cliente = clienteDao.findByPhone(numero);
		}else {
			return "redirect:/listas";
		}
		
		
		String[] objeto_campos = {"Id", "Nombre", "Apellido", "Telefono", "Email", "Cuenta"};
		modelo.put("objeto_campos", objeto_campos);
		String[] objeto_valores = {cliente.getId().toString(), cliente.getNombre(), cliente.getApellido(), cliente.getNumeroTelefonico(), cliente.getEmail(), cliente.getCuenta().getId().toString()};
		modelo.put("objeto_valores", objeto_valores);
		modelo.put("titulo", String.format("Edite cliente %d", cliente.getId()));
		return "form-view";
	}
	
	@RequestMapping(value="tarjeta/numero/{numero}", method=RequestMethod.GET)
	public String editarTarjetaNumero(@PathVariable(value="numero") Long numero, Map<String, Object> modelo) {
		Tarjeta tarjeta;
		
		if(numero>0) {
			tarjeta = tarjetaDao.findByNumero(numero);
		}else {
			return "redirect:/listas";
		}
		
		
		String[] objeto_campos = {"Id", "Numero", "ICV", "Tipo", "Cuenta"};
		modelo.put("objeto_campos", objeto_campos);
		String[] objeto_valores = {tarjeta.getId().toString(), tarjeta.getNumeroTarjeta(), tarjeta.getIcv(), tarjeta.getTipoTarjeta(), tarjeta.getCuenta().getId().toString()};
		modelo.put("objeto_valores", objeto_valores);
		modelo.put("titulo", String.format("Edite Tarjeta %d", tarjeta.getId()));
		return "form-view";
	}
	
	@RequestMapping(value="tarjeta/cuenta/{id}", method=RequestMethod.GET)
	public String editarTarjetaCuenta(@PathVariable(value="id") Long id, Map<String, Object> modelo) {
		Tarjeta tarjeta;
		
		if(id>0) {
			tarjeta = tarjetaDao.findByCuenta(id);
		}else {
			return "redirect:/listas";
		}
		
		
		String[] objeto_campos = {"Id", "Numero", "ICV", "Tipo", "Cuenta"};
		modelo.put("objeto_campos", objeto_campos);
		String[] objeto_valores = {tarjeta.getId().toString(), tarjeta.getNumeroTarjeta(), tarjeta.getIcv(), tarjeta.getTipoTarjeta(), tarjeta.getCuenta().getId().toString()};
		modelo.put("objeto_valores", objeto_valores);
		modelo.put("titulo", String.format("Edite Tarjeta %d", id));
		return "form-view";
	}
	
	@RequestMapping(value="empleado/banco/{id}", method=RequestMethod.GET)
	public String editarEmpleadoBanco(@PathVariable(value="id") Long id, Map<String, Object> modelo) {
		Empleado empleado;
		
		if(id>0) {
			empleado = empleadoDao.findByBanco(id);
		}else {
			return "redirect:/listas";
		}
		
		
		String[] objeto_campos = {"Id", "Nombre", "Apellido", "Puesto", "Dia ingreso", "Banco"};
		modelo.put("objeto_campos", objeto_campos);
		String[] objeto_valores = {empleado.getId().toString(), empleado.getNombre(), empleado.getApellido(), empleado.getPuesto(), empleado.getDiaIngreso().toString(), empleado.getBanco().getId().toString()};
		modelo.put("objeto_valores", objeto_valores);
		modelo.put("titulo", String.format("Edite Empleado %d", id));
		return "form-view";
	}
	
	@RequestMapping(value="cliente/{id}", method=RequestMethod.GET)
	public String editarCliente(@PathVariable(value="id") Long id, Map<String, Object> modelo) {
		Cliente cliente;
		
		if(id>0) {
			cliente = clienteDao.findOne(id);
		}else {
			return "redirect:/listas";
		}
		
		
		String[] objeto_campos = {"Id", "Nombre", "Apellido", "Telefono", "Email", "Cuenta"};
		modelo.put("objeto_campos", objeto_campos);
		String[] objeto_valores = {cliente.getId().toString(), cliente.getNombre(), cliente.getApellido(), cliente.getNumeroTelefonico(), cliente.getEmail(), cliente.getCuenta().getId().toString()};
		modelo.put("objeto_valores", objeto_valores);
		modelo.put("titulo", String.format("Edite cliente %d", id));
		return "form-view";
	}
	
	@RequestMapping(value="banco/{id}", method=RequestMethod.GET)
	public String editarBanco(@PathVariable(value="id") Long id, Map<String, Object> modelo) {
		Banco banco;
		
		if(id>0) {
			banco = bancoDao.findOne(id);
		}else {
			return "redirect:/listas";
		}
		
		
		String[] objeto_campos = {"Id", "Nombre", "Ubicacion"};
		modelo.put("objeto_campos", objeto_campos);
		String[] objeto_valores = {banco.getId().toString(), banco.getNombre(), banco.getUbicacion()};
		modelo.put("objeto_valores", objeto_valores);
		modelo.put("titulo", String.format("Edite Banco %d", id));
		return "form-view";
	}

	@RequestMapping(value="tarjeta/{id}", method=RequestMethod.GET)
	public String editarTarjeta(@PathVariable(value="id") Long id, Map<String, Object> modelo) {
		Tarjeta tarjeta;
		
		if(id>0) {
			tarjeta = tarjetaDao.findOne(id);
		}else {
			return "redirect:/listas";
		}
		
		
		String[] objeto_campos = {"Id", "Numero", "ICV", "Tipo", "Cuenta"};
		modelo.put("objeto_campos", objeto_campos);
		String[] objeto_valores = {tarjeta.getId().toString(), tarjeta.getNumeroTarjeta(), tarjeta.getIcv(), tarjeta.getTipoTarjeta(), tarjeta.getCuenta().getId().toString()};
		modelo.put("objeto_valores", objeto_valores);
		modelo.put("titulo", String.format("Edite Tarjeta %d", id));
		return "form-view";
	}
	
	@RequestMapping(value="empleado/{id}", method=RequestMethod.GET)
	public String editarEmpleado(@PathVariable(value="id") Long id, Map<String, Object> modelo) {
		Empleado empleado;
		
		if(id>0) {
			empleado = empleadoDao.findOne(id);
		}else {
			return "redirect:/listas";
		}
		
		
		String[] objeto_campos = {"Id", "Nombre", "Apellido", "Puesto", "Dia ingreso", "Banco"};
		modelo.put("objeto_campos", objeto_campos);
		String[] objeto_valores = {empleado.getId().toString(), empleado.getNombre(), empleado.getApellido(), empleado.getPuesto(), empleado.getDiaIngreso().toString(), empleado.getBanco().getId().toString()};
		modelo.put("objeto_valores", objeto_valores);
		modelo.put("titulo", String.format("Edite Empleado %d", id));
		return "form-view";
	}

}
