package com.softtek.acceleo.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.WhereJoinTable;

@Entity
@Table(name = "fideicomiso")
public class Fideicomiso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			          name = "UUID", 
	                  strategy = "org.hibernate.id.UUIDGenerator", 
	                  parameters = {
	                		@Parameter( 
	                				name = "uuid_gen_strategy_class", 
	                				value = "org.hibernate.id.uuid.CustomVersionOneStrategy" 
	                		) 
					  } 
					 )		
	@Column(name = "fideicomisoId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  fideicomisoId;		

	@NotNull
	@Column(name = "anteproyectoprospecto")
	private String anteproyectoprospecto;
	
	@NotNull
	@Column(name = "anteproyectoclave")
	private Integer anteproyectoclave;
	
	@NotNull
	private String anteproyectoadministrador;
	@NotNull
	private String anteproyectotiponegocio;
	@NotNull
	private String anteproyectoclasificacion;
	@NotNull
	@NotNull
	@NotNull
	@NotNull
	@NotNull
	@NotNull
	@Column(name = "generalesclave")
	private Integer generalesclave;
	
	@NotNull
	private String generalesbancoorigen;
	@NotNull
	@Column(name = "generalesnombre")
	private String generalesnombre;
	
	@NotNull
	@Column(name = "generalesfecha")
	private Date generalesfecha;
	
	@NotNull
	private String generalesestatus;
	@NotNull
	@Column(name = "generalesejecutivomonetario")
	private String generalesejecutivomonetario;
	
	@NotNull
	@Column(name = "generalesaquiensecobra")
	private String generalesaquiensecobra;
	
	@NotNull
	@Column(name = "generalesctoeje")
	private String generalesctoeje;
	
	@NotNull
	private String generalestipopersona;
	@NotNull
	@Column(name = "generalesversioncontrato")
	private String generalesversioncontrato;
	
	@NotNull
	@Column(name = "generalesproceso")
	private String generalesproceso;
	
	@NotNull
	@Column(name = "generalescliente")
	private String generalescliente;
	
	@NotNull
	@Column(name = "generalesclasificacionproducto")
	private String generalesclasificacionproducto;
	
	@NotNull
	@Column(name = "generalesadeudohonorarios")
	private String generalesadeudohonorarios;
	
	@NotNull
	private String caracteristicas;
	@NotNull
	private String caracteristicastiponegocio;
	@NotNull
	private String caracteristicasclasificacionproducto;
	@NotNull
	private String caracteristicasproductoestandar;
	@NotNull
	private String caracteristicasproducto;
	@NotNull
	@Column(name = "caracteristicasvalfatca")
	private String caracteristicasvalfatca;
	
	@NotNull
	@Column(name = "caracteristicasmanejosubfisos")
	private String caracteristicasmanejosubfisos;
	
	@NotNull
	@Column(name = "caracteristicassujetoart151")
	private String caracteristicassujetoart151;
	
	@NotNull
	@Column(name = "caracteristicascerrado")
	private String caracteristicascerrado;
	
	@NotNull
	@Column(name = "caracteristicasrevocable")
	private String caracteristicasrevocable;
	
	@NotNull
	@Column(name = "caracteristicassujetoart9lisr")
	private String caracteristicassujetoart9lisr;
	
	@NotNull
	@Column(name = "caracteristicasescontratoeje")
	private String caracteristicasescontratoeje;
	
	@NotNull
	@Column(name = "caracteristicascomitetecnico")
	private String caracteristicascomitetecnico;
	
	@NotNull
	@Column(name = "caracteristicasofibanxico")
	private String caracteristicasofibanxico;
	
	@NotNull
	@Column(name = "caracteristicasmanejamonext")
	private String caracteristicasmanejamonext;
	
	@NotNull
	@Column(name = "caracteristicasivafronterizo")
	private String caracteristicasivafronterizo;
	
	@NotNull
	@Column(name = "caracteristicasfechaalta")
	private Date caracteristicasfechaalta;
	
	@NotNull
	@Column(name = "caracteristicasfechaconstitucion")
	private Date caracteristicasfechaconstitucion;
	
	@NotNull
	@Column(name = "caracteristicasfechavencimiento")
	private Date caracteristicasfechavencimiento;
	
	@NotNull
	private String caracteristicasestado;
	@NotNull
	private String adicionalestipo;
	@NotNull
	@Column(name = "adicionalesconactividadempresarial")
	private String adicionalesconactividadempresarial;
	
	@NotNull
	@Column(name = "adicionalespermisosre")
	private String adicionalespermisosre;
	
	@NotNull
	@Column(name = "adicionalesfechapermisosre")
	private Date adicionalesfechapermisosre;
	
	@NotNull
	@Column(name = "adicionalesprovsustfiduciaria")
	private String adicionalesprovsustfiduciaria;
	
	@NotNull
	@Column(name = "adicionalesfondosinterfaseafore")
	private String adicionalesfondosinterfaseafore;
	
	@NotNull
	@Column(name = "adicionalesrenovaciongobdf")
	private String adicionalesrenovaciongobdf;
	
	@NotNull
	@Column(name = "adicionalesregnalinvext")
	private String adicionalesregnalinvext;
	
	@NotNull
	@Column(name = "adicionalesfechainscripcion")
	private Date adicionalesfechainscripcion;
	
	@NotNull
	@Column(name = "adicionalesinterfasesaca")
	private String adicionalesinterfasesaca;
	
	@NotNull
	private String adicionalestipocontrato;
	@NotNull
	@Column(name = "adicionalesnoescritura")
	private String adicionalesnoescritura;
	
	@NotNull
	@Column(name = "adicionalesfechaescritura")
	private String adicionalesfechaescritura;
	
	@NotNull
	private String adicionalesnombrenotario;
	@NotNull
	@Column(name = "adicionalesnonotario")
	private String adicionalesnonotario;
	
	@NotNull
	@Column(name = "adicionalesciudadnotario")
	private String adicionalesciudadnotario;
	
	@NotNull
	@Column(name = "adicionalesestadonotario")
	private String adicionalesestadonotario;
	
	@NotNull
	@Column(name = "adicionalespaisnotario")
	private String adicionalespaisnotario;
	
	@NotNull
	@Column(name = "adicionalesfolioregistropublico")
	private String adicionalesfolioregistropublico;
	
	@NotNull
	@Column(name = "adicionalesfechainscripcionregpublico")
	private String adicionalesfechainscripcionregpublico;
	
	@NotNull
	@Column(name = "datosbanxicoactividadeconomica")
	private String datosbanxicoactividadeconomica;
	
	@NotNull
	@Column(name = "datosbanxicofiducuario")
	private String datosbanxicofiducuario;
	
	@NotNull
	@Column(name = "datosbanxicosectorbancario")
	private String datosbanxicosectorbancario;
	
	@NotNull
	@Column(name = "datosbanxicolocalidad")
	private String datosbanxicolocalidad;
	
	@NotNull
	@Column(name = "datosbanxicocentroresp")
	private String datosbanxicocentroresp;
	
	@NotNull
	@Column(name = "datosbanxiconocr")
	private String datosbanxiconocr;
	
	@NotNull
	@Column(name = "datosbanxicorfccontrato")
	private String datosbanxicorfccontrato;
	
	@NotNull
	@Column(name = "datosbanxiconumerocliente")
	private String datosbanxiconumerocliente;
	
	@NotNull
	@Column(name = "creditosgarantiaspatrimonio")
	private String creditosgarantiaspatrimonio;
	

	public UUID getFideicomisoId() {
		return fideicomisoId;
	}

	public void setFideicomisoId(UUID fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	
	public String getAnteproyectoprospecto () {
	    return anteproyectoprospecto;
	    }
	public void setAnteproyectoprospecto(String anteproyectoprospecto) {
		this.anteproyectoprospecto = anteproyectoprospecto;
	}
	public Integer getAnteproyectoclave () {
	    return anteproyectoclave;
	    }
	public void setAnteproyectoclave(Integer anteproyectoclave) {
		this.anteproyectoclave = anteproyectoclave;
	}	
	public String getAnteproyectoadministrador () {
	    return anteproyectoadministrador;
	    }
	public void setAnteproyectoadministrador(String anteproyectoadministrador) {
		this.anteproyectoadministrador = anteproyectoadministrador;
	}
	public String getAnteproyectotiponegocio () {
	    return anteproyectotiponegocio;
	    }
	public void setAnteproyectotiponegocio(String anteproyectotiponegocio) {
		this.anteproyectotiponegocio = anteproyectotiponegocio;
	}
	public String getAnteproyectoclasificacion () {
	    return anteproyectoclasificacion;
	    }
	public void setAnteproyectoclasificacion(String anteproyectoclasificacion) {
		this.anteproyectoclasificacion = anteproyectoclasificacion;
	}
	public Integer getGeneralesclave () {
	    return generalesclave;
	    }
	public void setGeneralesclave(Integer generalesclave) {
		this.generalesclave = generalesclave;
	}	
	public String getGeneralesbancoorigen () {
	    return generalesbancoorigen;
	    }
	public void setGeneralesbancoorigen(String generalesbancoorigen) {
		this.generalesbancoorigen = generalesbancoorigen;
	}
	public String getGeneralesnombre () {
	    return generalesnombre;
	    }
	public void setGeneralesnombre(String generalesnombre) {
		this.generalesnombre = generalesnombre;
	}
	public Date getGeneralesfecha () {
	    return generalesfecha;
	    }
	public void setGeneralesfecha(Date generalesfecha) {
		this.generalesfecha = generalesfecha;
	}
	public String getGeneralesestatus () {
	    return generalesestatus;
	    }
	public void setGeneralesestatus(String generalesestatus) {
		this.generalesestatus = generalesestatus;
	}
	public String getGeneralesejecutivomonetario () {
	    return generalesejecutivomonetario;
	    }
	public void setGeneralesejecutivomonetario(String generalesejecutivomonetario) {
		this.generalesejecutivomonetario = generalesejecutivomonetario;
	}
	public String getGeneralesaquiensecobra () {
	    return generalesaquiensecobra;
	    }
	public void setGeneralesaquiensecobra(String generalesaquiensecobra) {
		this.generalesaquiensecobra = generalesaquiensecobra;
	}
	public String getGeneralesctoeje () {
	    return generalesctoeje;
	    }
	public void setGeneralesctoeje(String generalesctoeje) {
		this.generalesctoeje = generalesctoeje;
	}
	public String getGeneralestipopersona () {
	    return generalestipopersona;
	    }
	public void setGeneralestipopersona(String generalestipopersona) {
		this.generalestipopersona = generalestipopersona;
	}
	public String getGeneralesversioncontrato () {
	    return generalesversioncontrato;
	    }
	public void setGeneralesversioncontrato(String generalesversioncontrato) {
		this.generalesversioncontrato = generalesversioncontrato;
	}
	public String getGeneralesproceso () {
	    return generalesproceso;
	    }
	public void setGeneralesproceso(String generalesproceso) {
		this.generalesproceso = generalesproceso;
	}
	public String getGeneralescliente () {
	    return generalescliente;
	    }
	public void setGeneralescliente(String generalescliente) {
		this.generalescliente = generalescliente;
	}
	public String getGeneralesclasificacionproducto () {
	    return generalesclasificacionproducto;
	    }
	public void setGeneralesclasificacionproducto(String generalesclasificacionproducto) {
		this.generalesclasificacionproducto = generalesclasificacionproducto;
	}
	public String getGeneralesadeudohonorarios () {
	    return generalesadeudohonorarios;
	    }
	public void setGeneralesadeudohonorarios(String generalesadeudohonorarios) {
		this.generalesadeudohonorarios = generalesadeudohonorarios;
	}
	public String getCaracteristicas () {
	    return caracteristicas;
	    }
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getCaracteristicastiponegocio () {
	    return caracteristicastiponegocio;
	    }
	public void setCaracteristicastiponegocio(String caracteristicastiponegocio) {
		this.caracteristicastiponegocio = caracteristicastiponegocio;
	}
	public String getCaracteristicasclasificacionproducto () {
	    return caracteristicasclasificacionproducto;
	    }
	public void setCaracteristicasclasificacionproducto(String caracteristicasclasificacionproducto) {
		this.caracteristicasclasificacionproducto = caracteristicasclasificacionproducto;
	}
	public String getCaracteristicasproductoestandar () {
	    return caracteristicasproductoestandar;
	    }
	public void setCaracteristicasproductoestandar(String caracteristicasproductoestandar) {
		this.caracteristicasproductoestandar = caracteristicasproductoestandar;
	}
	public String getCaracteristicasproducto () {
	    return caracteristicasproducto;
	    }
	public void setCaracteristicasproducto(String caracteristicasproducto) {
		this.caracteristicasproducto = caracteristicasproducto;
	}
	public String getCaracteristicasvalfatca () {
	    return caracteristicasvalfatca;
	    }
	public void setCaracteristicasvalfatca(String caracteristicasvalfatca) {
		this.caracteristicasvalfatca = caracteristicasvalfatca;
	}
	public String getCaracteristicasmanejosubfisos () {
	    return caracteristicasmanejosubfisos;
	    }
	public void setCaracteristicasmanejosubfisos(String caracteristicasmanejosubfisos) {
		this.caracteristicasmanejosubfisos = caracteristicasmanejosubfisos;
	}
	public String getCaracteristicassujetoart151 () {
	    return caracteristicassujetoart151;
	    }
	public void setCaracteristicassujetoart151(String caracteristicassujetoart151) {
		this.caracteristicassujetoart151 = caracteristicassujetoart151;
	}
	public String getCaracteristicascerrado () {
	    return caracteristicascerrado;
	    }
	public void setCaracteristicascerrado(String caracteristicascerrado) {
		this.caracteristicascerrado = caracteristicascerrado;
	}
	public String getCaracteristicasrevocable () {
	    return caracteristicasrevocable;
	    }
	public void setCaracteristicasrevocable(String caracteristicasrevocable) {
		this.caracteristicasrevocable = caracteristicasrevocable;
	}
	public String getCaracteristicassujetoart9lisr () {
	    return caracteristicassujetoart9lisr;
	    }
	public void setCaracteristicassujetoart9lisr(String caracteristicassujetoart9lisr) {
		this.caracteristicassujetoart9lisr = caracteristicassujetoart9lisr;
	}
	public String getCaracteristicasescontratoeje () {
	    return caracteristicasescontratoeje;
	    }
	public void setCaracteristicasescontratoeje(String caracteristicasescontratoeje) {
		this.caracteristicasescontratoeje = caracteristicasescontratoeje;
	}
	public String getCaracteristicascomitetecnico () {
	    return caracteristicascomitetecnico;
	    }
	public void setCaracteristicascomitetecnico(String caracteristicascomitetecnico) {
		this.caracteristicascomitetecnico = caracteristicascomitetecnico;
	}
	public String getCaracteristicasofibanxico () {
	    return caracteristicasofibanxico;
	    }
	public void setCaracteristicasofibanxico(String caracteristicasofibanxico) {
		this.caracteristicasofibanxico = caracteristicasofibanxico;
	}
	public String getCaracteristicasmanejamonext () {
	    return caracteristicasmanejamonext;
	    }
	public void setCaracteristicasmanejamonext(String caracteristicasmanejamonext) {
		this.caracteristicasmanejamonext = caracteristicasmanejamonext;
	}
	public String getCaracteristicasivafronterizo () {
	    return caracteristicasivafronterizo;
	    }
	public void setCaracteristicasivafronterizo(String caracteristicasivafronterizo) {
		this.caracteristicasivafronterizo = caracteristicasivafronterizo;
	}
	public Date getCaracteristicasfechaalta () {
	    return caracteristicasfechaalta;
	    }
	public void setCaracteristicasfechaalta(Date caracteristicasfechaalta) {
		this.caracteristicasfechaalta = caracteristicasfechaalta;
	}
	public Date getCaracteristicasfechaconstitucion () {
	    return caracteristicasfechaconstitucion;
	    }
	public void setCaracteristicasfechaconstitucion(Date caracteristicasfechaconstitucion) {
		this.caracteristicasfechaconstitucion = caracteristicasfechaconstitucion;
	}
	public Date getCaracteristicasfechavencimiento () {
	    return caracteristicasfechavencimiento;
	    }
	public void setCaracteristicasfechavencimiento(Date caracteristicasfechavencimiento) {
		this.caracteristicasfechavencimiento = caracteristicasfechavencimiento;
	}
	public String getCaracteristicasestado () {
	    return caracteristicasestado;
	    }
	public void setCaracteristicasestado(String caracteristicasestado) {
		this.caracteristicasestado = caracteristicasestado;
	}
	public String getAdicionalestipo () {
	    return adicionalestipo;
	    }
	public void setAdicionalestipo(String adicionalestipo) {
		this.adicionalestipo = adicionalestipo;
	}
	public String getAdicionalesconactividadempresarial () {
	    return adicionalesconactividadempresarial;
	    }
	public void setAdicionalesconactividadempresarial(String adicionalesconactividadempresarial) {
		this.adicionalesconactividadempresarial = adicionalesconactividadempresarial;
	}
	public String getAdicionalespermisosre () {
	    return adicionalespermisosre;
	    }
	public void setAdicionalespermisosre(String adicionalespermisosre) {
		this.adicionalespermisosre = adicionalespermisosre;
	}
	public Date getAdicionalesfechapermisosre () {
	    return adicionalesfechapermisosre;
	    }
	public void setAdicionalesfechapermisosre(Date adicionalesfechapermisosre) {
		this.adicionalesfechapermisosre = adicionalesfechapermisosre;
	}
	public String getAdicionalesprovsustfiduciaria () {
	    return adicionalesprovsustfiduciaria;
	    }
	public void setAdicionalesprovsustfiduciaria(String adicionalesprovsustfiduciaria) {
		this.adicionalesprovsustfiduciaria = adicionalesprovsustfiduciaria;
	}
	public String getAdicionalesfondosinterfaseafore () {
	    return adicionalesfondosinterfaseafore;
	    }
	public void setAdicionalesfondosinterfaseafore(String adicionalesfondosinterfaseafore) {
		this.adicionalesfondosinterfaseafore = adicionalesfondosinterfaseafore;
	}
	public String getAdicionalesrenovaciongobdf () {
	    return adicionalesrenovaciongobdf;
	    }
	public void setAdicionalesrenovaciongobdf(String adicionalesrenovaciongobdf) {
		this.adicionalesrenovaciongobdf = adicionalesrenovaciongobdf;
	}
	public String getAdicionalesregnalinvext () {
	    return adicionalesregnalinvext;
	    }
	public void setAdicionalesregnalinvext(String adicionalesregnalinvext) {
		this.adicionalesregnalinvext = adicionalesregnalinvext;
	}
	public Date getAdicionalesfechainscripcion () {
	    return adicionalesfechainscripcion;
	    }
	public void setAdicionalesfechainscripcion(Date adicionalesfechainscripcion) {
		this.adicionalesfechainscripcion = adicionalesfechainscripcion;
	}
	public String getAdicionalesinterfasesaca () {
	    return adicionalesinterfasesaca;
	    }
	public void setAdicionalesinterfasesaca(String adicionalesinterfasesaca) {
		this.adicionalesinterfasesaca = adicionalesinterfasesaca;
	}
	public String getAdicionalestipocontrato () {
	    return adicionalestipocontrato;
	    }
	public void setAdicionalestipocontrato(String adicionalestipocontrato) {
		this.adicionalestipocontrato = adicionalestipocontrato;
	}
	public String getAdicionalesnoescritura () {
	    return adicionalesnoescritura;
	    }
	public void setAdicionalesnoescritura(String adicionalesnoescritura) {
		this.adicionalesnoescritura = adicionalesnoescritura;
	}
	public String getAdicionalesfechaescritura () {
	    return adicionalesfechaescritura;
	    }
	public void setAdicionalesfechaescritura(String adicionalesfechaescritura) {
		this.adicionalesfechaescritura = adicionalesfechaescritura;
	}
	public String getAdicionalesnombrenotario () {
	    return adicionalesnombrenotario;
	    }
	public void setAdicionalesnombrenotario(String adicionalesnombrenotario) {
		this.adicionalesnombrenotario = adicionalesnombrenotario;
	}
	public String getAdicionalesnonotario () {
	    return adicionalesnonotario;
	    }
	public void setAdicionalesnonotario(String adicionalesnonotario) {
		this.adicionalesnonotario = adicionalesnonotario;
	}
	public String getAdicionalesciudadnotario () {
	    return adicionalesciudadnotario;
	    }
	public void setAdicionalesciudadnotario(String adicionalesciudadnotario) {
		this.adicionalesciudadnotario = adicionalesciudadnotario;
	}
	public String getAdicionalesestadonotario () {
	    return adicionalesestadonotario;
	    }
	public void setAdicionalesestadonotario(String adicionalesestadonotario) {
		this.adicionalesestadonotario = adicionalesestadonotario;
	}
	public String getAdicionalespaisnotario () {
	    return adicionalespaisnotario;
	    }
	public void setAdicionalespaisnotario(String adicionalespaisnotario) {
		this.adicionalespaisnotario = adicionalespaisnotario;
	}
	public String getAdicionalesfolioregistropublico () {
	    return adicionalesfolioregistropublico;
	    }
	public void setAdicionalesfolioregistropublico(String adicionalesfolioregistropublico) {
		this.adicionalesfolioregistropublico = adicionalesfolioregistropublico;
	}
	public String getAdicionalesfechainscripcionregpublico () {
	    return adicionalesfechainscripcionregpublico;
	    }
	public void setAdicionalesfechainscripcionregpublico(String adicionalesfechainscripcionregpublico) {
		this.adicionalesfechainscripcionregpublico = adicionalesfechainscripcionregpublico;
	}
	public String getDatosbanxicoactividadeconomica () {
	    return datosbanxicoactividadeconomica;
	    }
	public void setDatosbanxicoactividadeconomica(String datosbanxicoactividadeconomica) {
		this.datosbanxicoactividadeconomica = datosbanxicoactividadeconomica;
	}
	public String getDatosbanxicofiducuario () {
	    return datosbanxicofiducuario;
	    }
	public void setDatosbanxicofiducuario(String datosbanxicofiducuario) {
		this.datosbanxicofiducuario = datosbanxicofiducuario;
	}
	public String getDatosbanxicosectorbancario () {
	    return datosbanxicosectorbancario;
	    }
	public void setDatosbanxicosectorbancario(String datosbanxicosectorbancario) {
		this.datosbanxicosectorbancario = datosbanxicosectorbancario;
	}
	public String getDatosbanxicolocalidad () {
	    return datosbanxicolocalidad;
	    }
	public void setDatosbanxicolocalidad(String datosbanxicolocalidad) {
		this.datosbanxicolocalidad = datosbanxicolocalidad;
	}
	public String getDatosbanxicocentroresp () {
	    return datosbanxicocentroresp;
	    }
	public void setDatosbanxicocentroresp(String datosbanxicocentroresp) {
		this.datosbanxicocentroresp = datosbanxicocentroresp;
	}
	public String getDatosbanxiconocr () {
	    return datosbanxiconocr;
	    }
	public void setDatosbanxiconocr(String datosbanxiconocr) {
		this.datosbanxiconocr = datosbanxiconocr;
	}
	public String getDatosbanxicorfccontrato () {
	    return datosbanxicorfccontrato;
	    }
	public void setDatosbanxicorfccontrato(String datosbanxicorfccontrato) {
		this.datosbanxicorfccontrato = datosbanxicorfccontrato;
	}
	public String getDatosbanxiconumerocliente () {
	    return datosbanxiconumerocliente;
	    }
	public void setDatosbanxiconumerocliente(String datosbanxiconumerocliente) {
		this.datosbanxiconumerocliente = datosbanxiconumerocliente;
	}
	public String getCreditosgarantiaspatrimonio () {
	    return creditosgarantiaspatrimonio;
	    }
	public void setCreditosgarantiaspatrimonio(String creditosgarantiaspatrimonio) {
		this.creditosgarantiaspatrimonio = creditosgarantiaspatrimonio;
	}
}		
