package br.com.tech.floresta.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="parque")
public class Parque {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

private Integer codigo;

@NotBlank(message = "Informe o Nome")
private String nome;

private BigDecimal area;

private BigDecimal altitude;


public void setId(Integer id) {
	this.id = id;
}
public Integer getId() {
	return this.id;
}
public void setCodigo(Integer codigo) {
	this.codigo = codigo;
}
public Integer getCodigo() {
	return this.codigo;
}
public void setNome(String nome) {
	this.nome= nome;
}
public String getNome() {
	return this.nome;
}
public void setArea(BigDecimal area) {
	this.area = area;
}
public BigDecimal getArea() {
	return this.area;
}
public BigDecimal getAltitude() {
	return altitude;
}
public void setAltitude(BigDecimal altitude) {
	this.altitude = altitude;
}
}
