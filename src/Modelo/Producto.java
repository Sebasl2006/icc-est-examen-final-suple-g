package Modelo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Producto  implements Comparable<Producto>{
  private String nombre;
  private String codigo;
  private List<Double> precios;
  public Producto(String nombre, String codigo, List<Double> precios) {
    this.nombre = nombre;
    this.codigo = codigo;
    this.precios = precios;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getCodigo() {
    return codigo;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  public List<Double> getPrecios() {
    return precios;
  }
  public void setPrecios(List<Double> precios) {
    this.precios = precios;
  }
  
  public int catidadPreciosRepetidos(){
    Map<Double,Integer> conteo = new HashMap<>();
    for(double precio : precios){
      conteo.put(precio, conteo.getOrDefault(precio, 0)+ 1);
    } 
    int repetidos = 0;
    for ( int count : conteo.values()){
      if ( count > 1) repetidos++;
    }
    return repetidos;
  }

  public int porcentajeCaracteresUnicos (){
    String normalizado = nombre.toLowerCase().replaceAll(nombre, codigo);
    Set<Character>  unicos = new HashSet<>();
    for (char c : normalizado.toCharArray()){
      unicos.add(c);
    }
    return (int) ((unicos.size() * 100.0) /normalizado.length());
  }
  @Override
  public int compareTo(Producto o) {
    int compNombre = this.nombre.compareTo(o.nombre);
    if ( compNombre != 0) return compNombre;
    return this.codigo.compareTo(o.codigo);
    
    
  }
  @Override
  public String toString() {
    return nombre  + "( " + codigo  + ")";
  }

  


  


  
  

  
 
 
  
}
