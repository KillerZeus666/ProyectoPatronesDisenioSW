package com.proyecto.demo.servicio;

import java.util.List;
import java.util.Optional;

import com.proyecto.demo.entidad.Empresa;

public interface EmpresaService {

    public List<Empresa> obtenerTodas();

    public Optional<Empresa> obtenerPorId(Long id);

    public Empresa guardar(Empresa empresa);

    public void eliminar(Long id);

    Empresa validarEmpresa(String correo, String contraseña);

    public void actualizarEntidadVigilante(Long id, Long entidadId);

    public void actualizarEntidadVigilanteMultiple(List<Long> empresaIds, Long entidadId);

}
