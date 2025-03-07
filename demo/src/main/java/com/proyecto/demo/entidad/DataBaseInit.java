package com.proyecto.demo.entidad;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.proyecto.demo.repositorio.EmpresaRepository;
import com.proyecto.demo.repositorio.UsuarioRepository;
import com.proyecto.demo.repositorio.QuejaRepository;
import com.proyecto.demo.repositorio.EntidadVigilanteRepository;
import com.proyecto.demo.repositorio.RespuestaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
@Transactional
public class DataBaseInit implements ApplicationRunner {
    private final UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;
    private final QuejaRepository quejaRepository;
    private final RespuestaRepository respuestaRepository;
    private final EntidadVigilanteRepository entidadVigilanteRepository; 


    @Override
    public void run(ApplicationArguments args) throws Exception {

        EntidadVigilante entidadVigilante= new EntidadVigilante("Superintendencia de Servicios Públicos Domiciliarios", 123456789, "sspd@example.com", "sspd123");
        entidadVigilanteRepository.save(entidadVigilante); 

        Usuario usuario1= new Usuario("Juan", 102848238, 30132915, "Juan@gmail.com", "123", null); 
        usuarioRepository.save(usuario1); 

        Empresa empresa1= new Empresa("Acueducto", "1");
        empresaRepository.save(empresa1);

        Empresa empresa2= new Empresa("Codensa", "2");
        empresaRepository.save(empresa2);

        Empresa empresa3= new Empresa("Epm", "3");
        empresaRepository.save(empresa3);

        Empresa empresa4= new Empresa("Aguas de la Sabana Bogota", "4");
        empresaRepository.save(empresa4);

        Empresa empresa5= new Empresa("Aseo Capital", "5");
        empresaRepository.save(empresa5);

        Empresa empresa6= new Empresa("EmCali", "6");
        empresaRepository.save(empresa6);

        Empresa empresa7= new Empresa("InterColombia", "7");
        empresaRepository.save(empresa7);

        Empresa empresa8= new Empresa("Veolia", "8");
        empresaRepository.save(empresa8);


        System.out.println("Base de datos inicializada con datos de ejemplo.");
    }   
}
