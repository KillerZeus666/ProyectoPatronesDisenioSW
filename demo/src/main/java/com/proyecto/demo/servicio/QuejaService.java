package com.proyecto.demo.servicio;

import com.proyecto.demo.entidad.Queja;
import com.proyecto.demo.entidad.TipoQueja;

import java.util.Date;
import java.util.List;

public interface QuejaService {

  // Registrar una nueva queja (sin ID, agregando idUsuario)
  Queja registrarQueja(Date fecha, Long idTipoQueja, String descripcion, Long idServicio, Long idEmpresa, Long idUsuario);

  // Buscar una queja por ID
  Queja buscarQueja(Long id);

  // Ver todas las quejas por cédula del usuario
  List<Queja> verQuejasPorUsr(Long cedula);

  // Ver todas las quejas por empresa
  List<Queja> verQuejasPorEmpresa(Long id);

  // Ver todas las quejas de la BD
  List<Queja> obtenerTodasLasQuejas();

  //Método que se ejecuta periodicamente para verificar quejas vencidas
  public void verificarQuejasVencidas();
}
