package Controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import Modelo.Producto;

public class ProductoController {

  public TreeSet<Producto> ordenarProductos(List<Producto> productos){
    Map<String ,  Producto> sinDuplicados = new HashMap<>();
    for( Producto p : productos){
      sinDuplicados.put(p.getCodigo(), p);
    }

    TreeSet<Producto> ordenados = new TreeSet<>();
    ordenados.addAll(sinDuplicados.values());
    return ordenados;
  }

  public Map<String, List<Producto>> clasificarPorUnicidad(Set<Producto> productos){
    LinkedHashMap<String, List<Producto>> clasificados = new LinkedHashMap<>();
    clasificados.put("A", new LinkedList<>());
    clasificados.put("B", new LinkedList<>());
    clasificados.put("C", new LinkedList<>());
    clasificados.put("D", new LinkedList<>());
    clasificados.put("E", new LinkedList<>());

    for( Producto p : productos){
      int porcentaje = p.porcentajeCaracteresUnicos();
      if ( porcentaje >= 90) clasificados.get("A").add(p);
      else if ( porcentaje >= 70) clasificados.get("B").add(p);
      else if ( porcentaje >= 50) clasificados.get("C").add(p);
      else if ( porcentaje >= 30) clasificados.get("D").add(p);
      else clasificados.get("E").add(p);

      
    }
    return clasificados;

  }


 


  
}
