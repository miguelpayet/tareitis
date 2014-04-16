package com.tareitis.lista;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class Lista
{
  private ArrayList<Tarea> tareas;
  
  public Lista() {}
  
  public Lista(ArrayList<Tarea> tareas)
  {
    this.tareas = tareas;
  }
  
  @JsonProperty
  public ArrayList<Tarea> getTareas()
  {
    return this.tareas;
  }
  
  @JsonProperty
  public void setTareas(ArrayList<Tarea> tareas)
  {
    this.tareas = tareas;
  }
}