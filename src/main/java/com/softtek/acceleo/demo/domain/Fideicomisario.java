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
@Table(name = "fideicomisario")
public class Fideicomisario implements Serializable {

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
	@Column(name = "fideicomisarioId", columnDefinition = "VARBINARY(50)")
	@Type(type="uuid-char")	
	private UUID  fideicomisarioId;		

	@NotNull
	private UUID fideicomisoId;
	@NotNull
	@Column(name = "clavefideicomisario")
	private String clavefideicomisario;
	
	@NotNull
	private String tipopersona;
	@NotNull
	@Column(name = "regimensimplificado")
	private String regimensimplificado;
	
	@NotNull
	@Column(name = "participante")
	private String participante;
	
	@NotNull
	@Column(name = "generalescontroladorfideicomiso")
	private String generalescontroladorfideicomiso;
	
	@NotNull
	@Column(name = "generalesnacionalidad")
	private String generalesnacionalidad;
	
	@NotNull
	@Column(name = "generalespaisorigen")
	private String generalespaisorigen;
	
	@NotNull
	@Column(name = "generalesactividad")
	private String generalesactividad;
	
	@NotNull
	@Column(name = "generalesaportarecursos")
	private String generalesaportarecursos;
	
	@NotNull
	@Column(name = "generalespaisresidencia")
	private String generalespaisresidencia;
	
	@NotNull
	@Column(name = "generalesclientescotiabank")
	private String generalesclientescotiabank;
	
	@NotNull
	@Column(name = "generalespep")
	private String generalespep;
	
	@NotNull
	@Column(name = "generalesestatus")
	private String generalesestatus;
	
	@NotNull
	@Column(name = "generalesgrupofilial")
	private String generalesgrupofilial;
	
	@NotNull
	@Column(name = "generalescalidadmigratoria")
	private String generalescalidadmigratoria;
	
	@NotNull
	@Column(name = "generaleslugaroperacion")
	private String generaleslugaroperacion;
	
	@NotNull
	@Column(name = "generalesoperacuentaterceros")
	private String generalesoperacuentaterceros;
	
	@NotNull
	@Column(name = "generalesnivelparticipante")
	private String generalesnivelparticipante;
	
	@NotNull
	@Column(name = "generalesclienterelacionpep")
	private String generalesclienterelacionpep;
	
	@NotNull
	@Column(name = "generalesgrado")
	private String generalesgrado;
	
	@NotNull
	@Column(name = "infopldkychonorarios")
	private String infopldkychonorarios;
	
	@NotNull
	@Column(name = "infopldkyccomisiones")
	private String infopldkyccomisiones;
	
	@NotNull
	@Column(name = "infopldkycotros")
	private String infopldkycotros;
	
	@NotNull
	@Column(name = "infopldkycsueldos")
	private String infopldkycsueldos;
	
	@NotNull
	@Column(name = "infopldkycventa")
	private String infopldkycventa;
	
	@NotNull
	@Column(name = "infopldkycinversiones")
	private String infopldkycinversiones;
	
	@NotNull
	@Column(name = "infopldkycarrendamiento")
	private String infopldkycarrendamiento;
	
	@NotNull
	@Column(name = "infopldkyctipopatrimonio")
	private String infopldkyctipopatrimonio;
	
	@NotNull
	@Column(name = "infopldkycinstrumento")
	private String infopldkycinstrumento;
	
	@NotNull
	@Column(name = "infopldkycrazonapertura")
	private String infopldkycrazonapertura;
	
	@NotNull
	@Column(name = "infopldkyccomentariose")
	private String infopldkyccomentariose;
	
	@NotNull
	@Column(name = "infopldkycnivelriesgo")
	private String infopldkycnivelriesgo;
	
	@NotNull
	@Column(name = "infopldkycestatuscalculopld")
	private String infopldkycestatuscalculopld;
	
	@NotNull
	@Column(name = "infopldkycfechaveriffircosoft")
	private Date infopldkycfechaveriffircosoft;
	
	@NotNull
	@Column(name = "identificacionrfc")
	private String identificacionrfc;
	
	@NotNull
	@Column(name = "identificacioncurp")
	private String identificacioncurp;
	
	@NotNull
	@Column(name = "identificacionnoserieefirma")
	private String identificacionnoserieefirma;
	
	@NotNull
	@Column(name = "identificacionpaisresidfisc1")
	private String identificacionpaisresidfisc1;
	
	@NotNull
	@Column(name = "identificacionpaisresidfisc2")
	private String identificacionpaisresidfisc2;
	
	@NotNull
	@Column(name = "identificacionemail")
	private String identificacionemail;
	
	@NotNull
	@Column(name = "identificacionfechaconstitucion")
	private String identificacionfechaconstitucion;
	
	@NotNull
	private String identificacionsexo;
	@NotNull
	@Column(name = "identificacioncasa")
	private String identificacioncasa;
	
	@NotNull
	@Column(name = "identificacionoficina")
	private String identificacionoficina;
	
	@NotNull
	@Column(name = "identificacioncelular")
	private String identificacioncelular;
	
	@NotNull
	@Column(name = "identificacionfechainiciorelneg")
	private String identificacionfechainiciorelneg;
	
	@NotNull
	@Column(name = "identificacionnoidentificacion")
	private String identificacionnoidentificacion;
	
	@NotNull
	@Column(name = "identificacioncomprobaciondomicilio")
	private String identificacioncomprobaciondomicilio;
	
	@NotNull
	private String identificacionactividadempresarial;
	@NotNull
	@Column(name = "identificacionnoidentfisc1")
	private String identificacionnoidentfisc1;
	
	@NotNull
	@Column(name = "identificacionnoidentfisc2")
	private String identificacionnoidentfisc2;
	
	@NotNull
	@Column(name = "identificacionclasificacionfacta")
	private String identificacionclasificacionfacta;
	
	@NotNull
	@Column(name = "identificacionladacasa")
	private String identificacionladacasa;
	
	@NotNull
	@Column(name = "identificacionladaoficina")
	private String identificacionladaoficina;
	
	@NotNull
	@Column(name = "identificacionnumerotelefono")
	private String identificacionnumerotelefono;
	
	@NotNull
	@Column(name = "identificacionnumerooficina")
	private String identificacionnumerooficina;
	
	@NotNull
	@Column(name = "identificacionnumerocelular")
	private String identificacionnumerocelular;
	
	@NotNull
	@Column(name = "identificacionextoficina")
	private String identificacionextoficina;
	
	@NotNull
	@Column(name = "identificacionextcelular")
	private String identificacionextcelular;
	
	@NotNull
	@Column(name = "identificacionidentoficialvig")
	private String identificacionidentoficialvig;
	
	@NotNull
	@Column(name = "identificacionvigencia")
	private String identificacionvigencia;
	
	@NotNull
	@Column(name = "escrituranoescritura")
	private String escrituranoescritura;
	
	@NotNull
	private String escrituranotario;
	@NotNull
	@Column(name = "escrituranonotaria")
	private String escrituranonotaria;
	
	@NotNull
	@Column(name = "escrituraciudad")
	private String escrituraciudad;
	
	@NotNull
	@Column(name = "escrituratelefono")
	private String escrituratelefono;
	
	@NotNull
	@Column(name = "escrituraemail")
	private String escrituraemail;
	
	@NotNull
	@Column(name = "escriturafecha")
	private Date escriturafecha;
	
	@NotNull
	@Column(name = "escrituraestado")
	private String escrituraestado;
	
	@NotNull
	@Column(name = "cuentaskycnocuenta1")
	private Integer cuentaskycnocuenta1;
	
	@NotNull
	@Column(name = "cuentaskyctipocuenta1")
	private String cuentaskyctipocuenta1;
	
	@NotNull
	@Column(name = "cuentaskycnocuenta2")
	private Integer cuentaskycnocuenta2;
	
	@NotNull
	@Column(name = "cuentaskyctipocuenta2")
	private String cuentaskyctipocuenta2;
	
	@NotNull
	@Column(name = "cuentaskycnocuenta3")
	private Integer cuentaskycnocuenta3;
	
	@NotNull
	@Column(name = "cuentaskyctipocuenta3")
	private String cuentaskyctipocuenta3;
	
	@NotNull
	@Column(name = "cuentaskycnocuenta4")
	private Integer cuentaskycnocuenta4;
	
	@NotNull
	@Column(name = "cuentaskyctipocuenta4")
	private String cuentaskyctipocuenta4;
	

	public UUID getFideicomisarioId() {
		return fideicomisarioId;
	}

	public void setFideicomisarioId(UUID fideicomisarioId) {
		this.fideicomisarioId = fideicomisarioId;
	}
	
	public UUID getFideicomisoId () {
	    return fideicomisoId;
	    }
	public void setFideicomiso(UUID fideicomisoId) {
		this.fideicomisoId = fideicomisoId;
	}
	public String getClavefideicomisario () {
	    return clavefideicomisario;
	    }
	public void setClavefideicomisario(String clavefideicomisario) {
		this.clavefideicomisario = clavefideicomisario;
	}
	public String getTipopersona () {
	    return tipopersona;
	    }
	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}
	public String getRegimensimplificado () {
	    return regimensimplificado;
	    }
	public void setRegimensimplificado(String regimensimplificado) {
		this.regimensimplificado = regimensimplificado;
	}
	public String getParticipante () {
	    return participante;
	    }
	public void setParticipante(String participante) {
		this.participante = participante;
	}
	public String getGeneralescontroladorfideicomiso () {
	    return generalescontroladorfideicomiso;
	    }
	public void setGeneralescontroladorfideicomiso(String generalescontroladorfideicomiso) {
		this.generalescontroladorfideicomiso = generalescontroladorfideicomiso;
	}
	public String getGeneralesnacionalidad () {
	    return generalesnacionalidad;
	    }
	public void setGeneralesnacionalidad(String generalesnacionalidad) {
		this.generalesnacionalidad = generalesnacionalidad;
	}
	public String getGeneralespaisorigen () {
	    return generalespaisorigen;
	    }
	public void setGeneralespaisorigen(String generalespaisorigen) {
		this.generalespaisorigen = generalespaisorigen;
	}
	public String getGeneralesactividad () {
	    return generalesactividad;
	    }
	public void setGeneralesactividad(String generalesactividad) {
		this.generalesactividad = generalesactividad;
	}
	public String getGeneralesaportarecursos () {
	    return generalesaportarecursos;
	    }
	public void setGeneralesaportarecursos(String generalesaportarecursos) {
		this.generalesaportarecursos = generalesaportarecursos;
	}
	public String getGeneralespaisresidencia () {
	    return generalespaisresidencia;
	    }
	public void setGeneralespaisresidencia(String generalespaisresidencia) {
		this.generalespaisresidencia = generalespaisresidencia;
	}
	public String getGeneralesclientescotiabank () {
	    return generalesclientescotiabank;
	    }
	public void setGeneralesclientescotiabank(String generalesclientescotiabank) {
		this.generalesclientescotiabank = generalesclientescotiabank;
	}
	public String getGeneralespep () {
	    return generalespep;
	    }
	public void setGeneralespep(String generalespep) {
		this.generalespep = generalespep;
	}
	public String getGeneralesestatus () {
	    return generalesestatus;
	    }
	public void setGeneralesestatus(String generalesestatus) {
		this.generalesestatus = generalesestatus;
	}
	public String getGeneralesgrupofilial () {
	    return generalesgrupofilial;
	    }
	public void setGeneralesgrupofilial(String generalesgrupofilial) {
		this.generalesgrupofilial = generalesgrupofilial;
	}
	public String getGeneralescalidadmigratoria () {
	    return generalescalidadmigratoria;
	    }
	public void setGeneralescalidadmigratoria(String generalescalidadmigratoria) {
		this.generalescalidadmigratoria = generalescalidadmigratoria;
	}
	public String getGeneraleslugaroperacion () {
	    return generaleslugaroperacion;
	    }
	public void setGeneraleslugaroperacion(String generaleslugaroperacion) {
		this.generaleslugaroperacion = generaleslugaroperacion;
	}
	public String getGeneralesoperacuentaterceros () {
	    return generalesoperacuentaterceros;
	    }
	public void setGeneralesoperacuentaterceros(String generalesoperacuentaterceros) {
		this.generalesoperacuentaterceros = generalesoperacuentaterceros;
	}
	public String getGeneralesnivelparticipante () {
	    return generalesnivelparticipante;
	    }
	public void setGeneralesnivelparticipante(String generalesnivelparticipante) {
		this.generalesnivelparticipante = generalesnivelparticipante;
	}
	public String getGeneralesclienterelacionpep () {
	    return generalesclienterelacionpep;
	    }
	public void setGeneralesclienterelacionpep(String generalesclienterelacionpep) {
		this.generalesclienterelacionpep = generalesclienterelacionpep;
	}
	public String getGeneralesgrado () {
	    return generalesgrado;
	    }
	public void setGeneralesgrado(String generalesgrado) {
		this.generalesgrado = generalesgrado;
	}
	public String getInfopldkychonorarios () {
	    return infopldkychonorarios;
	    }
	public void setInfopldkychonorarios(String infopldkychonorarios) {
		this.infopldkychonorarios = infopldkychonorarios;
	}
	public String getInfopldkyccomisiones () {
	    return infopldkyccomisiones;
	    }
	public void setInfopldkyccomisiones(String infopldkyccomisiones) {
		this.infopldkyccomisiones = infopldkyccomisiones;
	}
	public String getInfopldkycotros () {
	    return infopldkycotros;
	    }
	public void setInfopldkycotros(String infopldkycotros) {
		this.infopldkycotros = infopldkycotros;
	}
	public String getInfopldkycsueldos () {
	    return infopldkycsueldos;
	    }
	public void setInfopldkycsueldos(String infopldkycsueldos) {
		this.infopldkycsueldos = infopldkycsueldos;
	}
	public String getInfopldkycventa () {
	    return infopldkycventa;
	    }
	public void setInfopldkycventa(String infopldkycventa) {
		this.infopldkycventa = infopldkycventa;
	}
	public String getInfopldkycinversiones () {
	    return infopldkycinversiones;
	    }
	public void setInfopldkycinversiones(String infopldkycinversiones) {
		this.infopldkycinversiones = infopldkycinversiones;
	}
	public String getInfopldkycarrendamiento () {
	    return infopldkycarrendamiento;
	    }
	public void setInfopldkycarrendamiento(String infopldkycarrendamiento) {
		this.infopldkycarrendamiento = infopldkycarrendamiento;
	}
	public String getInfopldkyctipopatrimonio () {
	    return infopldkyctipopatrimonio;
	    }
	public void setInfopldkyctipopatrimonio(String infopldkyctipopatrimonio) {
		this.infopldkyctipopatrimonio = infopldkyctipopatrimonio;
	}
	public String getInfopldkycinstrumento () {
	    return infopldkycinstrumento;
	    }
	public void setInfopldkycinstrumento(String infopldkycinstrumento) {
		this.infopldkycinstrumento = infopldkycinstrumento;
	}
	public String getInfopldkycrazonapertura () {
	    return infopldkycrazonapertura;
	    }
	public void setInfopldkycrazonapertura(String infopldkycrazonapertura) {
		this.infopldkycrazonapertura = infopldkycrazonapertura;
	}	
	public String getInfopldkyccomentariose () {
	    return infopldkyccomentariose;
	    }
	public void setInfopldkyccomentariose(String infopldkyccomentariose) {
		this.infopldkyccomentariose = infopldkyccomentariose;
	}	
	public String getInfopldkycnivelriesgo () {
	    return infopldkycnivelriesgo;
	    }
	public void setInfopldkycnivelriesgo(String infopldkycnivelriesgo) {
		this.infopldkycnivelriesgo = infopldkycnivelriesgo;
	}
	public String getInfopldkycestatuscalculopld () {
	    return infopldkycestatuscalculopld;
	    }
	public void setInfopldkycestatuscalculopld(String infopldkycestatuscalculopld) {
		this.infopldkycestatuscalculopld = infopldkycestatuscalculopld;
	}
	public Date getInfopldkycfechaveriffircosoft () {
	    return infopldkycfechaveriffircosoft;
	    }
	public void setInfopldkycfechaveriffircosoft(Date infopldkycfechaveriffircosoft) {
		this.infopldkycfechaveriffircosoft = infopldkycfechaveriffircosoft;
	}
	public String getIdentificacionrfc () {
	    return identificacionrfc;
	    }
	public void setIdentificacionrfc(String identificacionrfc) {
		this.identificacionrfc = identificacionrfc;
	}
	public String getIdentificacioncurp () {
	    return identificacioncurp;
	    }
	public void setIdentificacioncurp(String identificacioncurp) {
		this.identificacioncurp = identificacioncurp;
	}
	public String getIdentificacionnoserieefirma () {
	    return identificacionnoserieefirma;
	    }
	public void setIdentificacionnoserieefirma(String identificacionnoserieefirma) {
		this.identificacionnoserieefirma = identificacionnoserieefirma;
	}
	public String getIdentificacionpaisresidfisc1 () {
	    return identificacionpaisresidfisc1;
	    }
	public void setIdentificacionpaisresidfisc1(String identificacionpaisresidfisc1) {
		this.identificacionpaisresidfisc1 = identificacionpaisresidfisc1;
	}
	public String getIdentificacionpaisresidfisc2 () {
	    return identificacionpaisresidfisc2;
	    }
	public void setIdentificacionpaisresidfisc2(String identificacionpaisresidfisc2) {
		this.identificacionpaisresidfisc2 = identificacionpaisresidfisc2;
	}
	public String getIdentificacionemail () {
	    return identificacionemail;
	    }
	public void setIdentificacionemail(String identificacionemail) {
		this.identificacionemail = identificacionemail;
	}
	public String getIdentificacionfechaconstitucion () {
	    return identificacionfechaconstitucion;
	    }
	public void setIdentificacionfechaconstitucion(String identificacionfechaconstitucion) {
		this.identificacionfechaconstitucion = identificacionfechaconstitucion;
	}
	public String getIdentificacionsexo () {
	    return identificacionsexo;
	    }
	public void setIdentificacionsexo(String identificacionsexo) {
		this.identificacionsexo = identificacionsexo;
	}
	public String getIdentificacioncasa () {
	    return identificacioncasa;
	    }
	public void setIdentificacioncasa(String identificacioncasa) {
		this.identificacioncasa = identificacioncasa;
	}
	public String getIdentificacionoficina () {
	    return identificacionoficina;
	    }
	public void setIdentificacionoficina(String identificacionoficina) {
		this.identificacionoficina = identificacionoficina;
	}
	public String getIdentificacioncelular () {
	    return identificacioncelular;
	    }
	public void setIdentificacioncelular(String identificacioncelular) {
		this.identificacioncelular = identificacioncelular;
	}
	public String getIdentificacionfechainiciorelneg () {
	    return identificacionfechainiciorelneg;
	    }
	public void setIdentificacionfechainiciorelneg(String identificacionfechainiciorelneg) {
		this.identificacionfechainiciorelneg = identificacionfechainiciorelneg;
	}
	public String getIdentificacionnoidentificacion () {
	    return identificacionnoidentificacion;
	    }
	public void setIdentificacionnoidentificacion(String identificacionnoidentificacion) {
		this.identificacionnoidentificacion = identificacionnoidentificacion;
	}
	public String getIdentificacioncomprobaciondomicilio () {
	    return identificacioncomprobaciondomicilio;
	    }
	public void setIdentificacioncomprobaciondomicilio(String identificacioncomprobaciondomicilio) {
		this.identificacioncomprobaciondomicilio = identificacioncomprobaciondomicilio;
	}
	public String getIdentificacionactividadempresarial () {
	    return identificacionactividadempresarial;
	    }
	public void setIdentificacionactividadempresarial(String identificacionactividadempresarial) {
		this.identificacionactividadempresarial = identificacionactividadempresarial;
	}
	public String getIdentificacionnoidentfisc1 () {
	    return identificacionnoidentfisc1;
	    }
	public void setIdentificacionnoidentfisc1(String identificacionnoidentfisc1) {
		this.identificacionnoidentfisc1 = identificacionnoidentfisc1;
	}
	public String getIdentificacionnoidentfisc2 () {
	    return identificacionnoidentfisc2;
	    }
	public void setIdentificacionnoidentfisc2(String identificacionnoidentfisc2) {
		this.identificacionnoidentfisc2 = identificacionnoidentfisc2;
	}
	public String getIdentificacionclasificacionfacta () {
	    return identificacionclasificacionfacta;
	    }
	public void setIdentificacionclasificacionfacta(String identificacionclasificacionfacta) {
		this.identificacionclasificacionfacta = identificacionclasificacionfacta;
	}
	public String getIdentificacionladacasa () {
	    return identificacionladacasa;
	    }
	public void setIdentificacionladacasa(String identificacionladacasa) {
		this.identificacionladacasa = identificacionladacasa;
	}
	public String getIdentificacionladaoficina () {
	    return identificacionladaoficina;
	    }
	public void setIdentificacionladaoficina(String identificacionladaoficina) {
		this.identificacionladaoficina = identificacionladaoficina;
	}
	public String getIdentificacionnumerotelefono () {
	    return identificacionnumerotelefono;
	    }
	public void setIdentificacionnumerotelefono(String identificacionnumerotelefono) {
		this.identificacionnumerotelefono = identificacionnumerotelefono;
	}
	public String getIdentificacionnumerooficina () {
	    return identificacionnumerooficina;
	    }
	public void setIdentificacionnumerooficina(String identificacionnumerooficina) {
		this.identificacionnumerooficina = identificacionnumerooficina;
	}
	public String getIdentificacionnumerocelular () {
	    return identificacionnumerocelular;
	    }
	public void setIdentificacionnumerocelular(String identificacionnumerocelular) {
		this.identificacionnumerocelular = identificacionnumerocelular;
	}
	public String getIdentificacionextoficina () {
	    return identificacionextoficina;
	    }
	public void setIdentificacionextoficina(String identificacionextoficina) {
		this.identificacionextoficina = identificacionextoficina;
	}
	public String getIdentificacionextcelular () {
	    return identificacionextcelular;
	    }
	public void setIdentificacionextcelular(String identificacionextcelular) {
		this.identificacionextcelular = identificacionextcelular;
	}
	public String getIdentificacionidentoficialvig () {
	    return identificacionidentoficialvig;
	    }
	public void setIdentificacionidentoficialvig(String identificacionidentoficialvig) {
		this.identificacionidentoficialvig = identificacionidentoficialvig;
	}
	public String getIdentificacionvigencia () {
	    return identificacionvigencia;
	    }
	public void setIdentificacionvigencia(String identificacionvigencia) {
		this.identificacionvigencia = identificacionvigencia;
	}
	public String getEscrituranoescritura () {
	    return escrituranoescritura;
	    }
	public void setEscrituranoescritura(String escrituranoescritura) {
		this.escrituranoescritura = escrituranoescritura;
	}
	public String getEscrituranotario () {
	    return escrituranotario;
	    }
	public void setEscrituranotario(String escrituranotario) {
		this.escrituranotario = escrituranotario;
	}
	public String getEscrituranonotaria () {
	    return escrituranonotaria;
	    }
	public void setEscrituranonotaria(String escrituranonotaria) {
		this.escrituranonotaria = escrituranonotaria;
	}
	public String getEscrituraciudad () {
	    return escrituraciudad;
	    }
	public void setEscrituraciudad(String escrituraciudad) {
		this.escrituraciudad = escrituraciudad;
	}
	public String getEscrituratelefono () {
	    return escrituratelefono;
	    }
	public void setEscrituratelefono(String escrituratelefono) {
		this.escrituratelefono = escrituratelefono;
	}
	public String getEscrituraemail () {
	    return escrituraemail;
	    }
	public void setEscrituraemail(String escrituraemail) {
		this.escrituraemail = escrituraemail;
	}
	public Date getEscriturafecha () {
	    return escriturafecha;
	    }
	public void setEscriturafecha(Date escriturafecha) {
		this.escriturafecha = escriturafecha;
	}
	public String getEscrituraestado () {
	    return escrituraestado;
	    }
	public void setEscrituraestado(String escrituraestado) {
		this.escrituraestado = escrituraestado;
	}
	public Integer getCuentaskycnocuenta1 () {
	    return cuentaskycnocuenta1;
	    }
	public void setCuentaskycnocuenta1(Integer cuentaskycnocuenta1) {
		this.cuentaskycnocuenta1 = cuentaskycnocuenta1;
	}	
	public String getCuentaskyctipocuenta1 () {
	    return cuentaskyctipocuenta1;
	    }
	public void setCuentaskyctipocuenta1(String cuentaskyctipocuenta1) {
		this.cuentaskyctipocuenta1 = cuentaskyctipocuenta1;
	}
	public Integer getCuentaskycnocuenta2 () {
	    return cuentaskycnocuenta2;
	    }
	public void setCuentaskycnocuenta2(Integer cuentaskycnocuenta2) {
		this.cuentaskycnocuenta2 = cuentaskycnocuenta2;
	}	
	public String getCuentaskyctipocuenta2 () {
	    return cuentaskyctipocuenta2;
	    }
	public void setCuentaskyctipocuenta2(String cuentaskyctipocuenta2) {
		this.cuentaskyctipocuenta2 = cuentaskyctipocuenta2;
	}
	public Integer getCuentaskycnocuenta3 () {
	    return cuentaskycnocuenta3;
	    }
	public void setCuentaskycnocuenta3(Integer cuentaskycnocuenta3) {
		this.cuentaskycnocuenta3 = cuentaskycnocuenta3;
	}	
	public String getCuentaskyctipocuenta3 () {
	    return cuentaskyctipocuenta3;
	    }
	public void setCuentaskyctipocuenta3(String cuentaskyctipocuenta3) {
		this.cuentaskyctipocuenta3 = cuentaskyctipocuenta3;
	}
	public Integer getCuentaskycnocuenta4 () {
	    return cuentaskycnocuenta4;
	    }
	public void setCuentaskycnocuenta4(Integer cuentaskycnocuenta4) {
		this.cuentaskycnocuenta4 = cuentaskycnocuenta4;
	}	
	public String getCuentaskyctipocuenta4 () {
	    return cuentaskyctipocuenta4;
	    }
	public void setCuentaskyctipocuenta4(String cuentaskyctipocuenta4) {
		this.cuentaskyctipocuenta4 = cuentaskyctipocuenta4;
	}
}		
