package com.tareitis.lista;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="tarea")
public class Tarea
{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="codusuario", nullable=false)
  private int codusuario;
  @Column(name="posicion")
  private long posicion;
  @Column(name="texto")
  @Length(max=250)
  private String texto;
  
  public Tarea() {}
  
  public Tarea(int usuario, long posicion, String texto)
  {
    this.codusuario = usuario;
    this.posicion = posicion;
    this.texto = texto;
  }
  
  @JsonProperty
  public long getPosicion()
  {
    return this.posicion;
  }
  
  @JsonProperty
  public String getTexto()
  {
    return this.texto;
  }
  
  public int getUsuario()
  {
    return this.codusuario;
  }
  
  @JsonProperty
  public void setPosicion(long posicion)
  {
    this.posicion = posicion;
  }
  
  @JsonProperty
  public void setTexto(String texto)
  {
    this.texto = texto;
  }
  
  public void setUsuario(int usuario)
  {
    this.codusuario = usuario;
  }
}