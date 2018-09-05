package com.softtek.demo.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softtek.acceleo.demo.domain.Cliente;
import com.softtek.acceleo.demo.domain.Destino;
import com.softtek.acceleo.demo.domain.Estadoorden;
import com.softtek.acceleo.demo.domain.Etiquetaasignada;
import com.softtek.acceleo.demo.domain.Linea;
import com.softtek.acceleo.demo.domain.Operadorproduccion;
import com.softtek.acceleo.demo.domain.Ordensimplificada;

import ch.qos.logback.classic.BasicConfigurator;

public abstract class BaseTest {

	protected final static Logger LOGGER = LoggerFactory.getLogger(BasicConfigurator.class);
	
	//protected Cliente cliente = new Cliente();
	protected Integer cliente = new Integer(0);
	protected List<Cliente> clientes = new ArrayList<>();
	
	protected Etiquetaasignada etiquetaasignada = new Etiquetaasignada();
	protected List<Etiquetaasignada> etiquetaasignadas = new ArrayList<>();
	//protected Integer etiquetaAsignada = new Integer(0);
	
	protected Ordensimplificada ordensimplificada = new Ordensimplificada();
	protected List<Ordensimplificada> ordensimplificadas = new ArrayList<>();
	protected List<Ordensimplificada> ordenSimplificada = new ArrayList<>();
	//protected Integer ordenSimplificada = new Integer(0);
	
	protected Operadorproduccion operadorproduccion = new Operadorproduccion();
	protected List<Operadorproduccion> operadorproduccions = new ArrayList<>();
	
	protected Linea linea;
	protected Estadoorden estadoorden;
	protected Destino destino;
	
	protected void setup() {
		this.setMemoryClientes();
		this.setMemoryEtiquetaAsignada();
		this.setMemoryOrdenSimplificada();
		this.setMemoryOperadorproduccion();
	}

	private void setMemoryClientes() {
		
		final Date currentDt = new Date();

		Cliente c1 = new Cliente();
		c1.setClave(001);
		c1.setClienteId(1);
		c1.setNombre("Normaysel Carbajal");
		//c1.setClienteIdS(clientes);
		c1.setEtiquetaasignadas1Id(etiquetaasignadas);
		//c1.setEtiquetaasignadas(etiquetaasignadas);
		//c1.setOrdensimplificada(ordensimplificadas);
		c1.setOrdensimplificada1Id(ordenSimplificada);
		
	}
	
	private void setMemoryEtiquetaAsignada() {
		
		final Date currentDt = new Date();

		Etiquetaasignada e1 = new Etiquetaasignada();
		e1.setClienteId(cliente);
		e1.setEtiquetaasignadaId(1);
		e1.setSap(1);
		e1.setEtiquetaasignadasxpalet(1);
		e1.setMultiplo1(1);
		e1.setMultiplo2(1);
		e1.setMultiplo3(1);
		e1.setF5(1);
		e1.setOrdenSimplificadaId(ordensimplificada);
	}
	
	private void setMemoryOrdenSimplificada() {
		
		final Date currentDt = new Date();

		Ordensimplificada o1 = new Ordensimplificada();
		
		o1.setOrdentrabajo(1);
		o1.setSap(0001);
		o1.setComentario("Ninguno");
		o1.setCantidadproducida(200000);
		o1.setCantidadprogramada(200000);
		o1.setFechafinal(new Timestamp(currentDt.getTime()));
		o1.setFechainicial(new Timestamp(currentDt.getTime()));
		o1.setDestinoId(destino.d1);
		o1.setEstadoorden1Id(estadoorden.e1);
		o1.setEstadoorden2Id(estadoorden.e2);
		o1.setLineaId(linea.a);
		o1.setOperadorproduccion1Id(operadorproduccion);
		o1.setOperadorproduccion2Id(operadorproduccion);
	}
	
	public void setMemoryOperadorproduccion(){
		
		final Date currentDt = new Date();
		
		Operadorproduccion op1 = new Operadorproduccion();
		op1.setNombre("Alejandro Zavala Carbajal");
		op1.setNumeroempleado(002);
		op1.setOperadorproduccionId(1);
	}

}
