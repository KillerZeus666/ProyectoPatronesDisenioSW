package com.proyecto.demo.entidad;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.proyecto.demo.repositorio.EmpresaRepository;
import com.proyecto.demo.repositorio.UsuarioRepository;
import com.proyecto.demo.repositorio.QuejaRepository;
import com.proyecto.demo.repositorio.EntidadVigilanteRepository;
import com.proyecto.demo.repositorio.RespuestaRepository;
import com.proyecto.demo.repositorio.ServicioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Transactional
public class DataBaseInit implements ApplicationRunner {
    
    private final UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;
    private final QuejaRepository quejaRepository;
    private final EntidadVigilanteRepository entidadVigilanteRepository;
    private final ServicioRepository servicioRepository;  // Asegúrate de tener este repositorio

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Inicializar Entidad Vigilante
        EntidadVigilante entidadVigilante = new EntidadVigilante(
                "Superintendencia de Servicios Públicos Domiciliarios", 
                123456789, 
                "sspd@example.com", 
                "sspd123"
        );
        entidadVigilanteRepository.save(entidadVigilante);

        // Insertar usuarios
        Usuario usuarioJuan = new Usuario(
                "Juan Pérez", 
                123456789, 
                3001234567L, 
                "Juan@gmail.com", 
                "123", 
                null
        );
        usuarioRepository.save(usuarioJuan);

        Usuario usuarioMaria = new Usuario(
                "María Gómez", 
                987654321, 
                3109876543L, 
                "maria.gomez@example.com", 
                "maria123", 
                null
        );
        usuarioRepository.save(usuarioMaria);

        // Insertar empresas
        Empresa empresa1 = new Empresa("Acueducto", "1");
        empresaRepository.save(empresa1);

        Empresa empresa2 = new Empresa("Codensa", "2");
        empresaRepository.save(empresa2);

        Empresa empresa3 = new Empresa("Epm", "3");
        empresaRepository.save(empresa3);

        Empresa empresa4 = new Empresa("Aguas de la Sabana Bogota", "4");
        empresaRepository.save(empresa4);

        Empresa empresa5 = new Empresa("Aseo Capital", "5");
        empresaRepository.save(empresa5);

        Empresa empresa6 = new Empresa("EmCali", "6");
        empresaRepository.save(empresa6);

        Empresa empresa7 = new Empresa("InterColombia", "7");
        empresaRepository.save(empresa7);

        Empresa empresa8 = new Empresa("Veolia", "8");
        empresaRepository.save(empresa8);

        // Insertar servicios asociados a las empresas
        Servicio servicioAgua = new Servicio("Agua Potable", empresa1);
        servicioRepository.save(servicioAgua);

        Servicio servicioAlcantarillado = new Servicio("Alcantarillado", empresa1);
        servicioRepository.save(servicioAlcantarillado);

        Servicio servicioGas = new Servicio("Gas Domiciliario", empresa2);
        servicioRepository.save(servicioGas);

        Servicio servicioEnergia = new Servicio("Energía Eléctrica", empresa3);
        servicioRepository.save(servicioEnergia);

        // Insertar quejas asociadas a los usuarios
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Queja de Juan Pérez sobre el servicio de agua
        Queja queja1 = new Queja(
                sdf.parse("2023-10-01"),
                "Reclamo",
                "El agua llega con mal olor y sabor.",
                servicioAgua,
                empresa1,
                usuarioJuan
        );
        quejaRepository.save(queja1);

        // Queja de María Gómez sobre el servicio de gas
        Queja queja2 = new Queja(
                sdf.parse("2023-10-02"),
                "Reclamo",
                "El gas no enciende correctamente.",
                servicioGas,
                empresa2,
                usuarioMaria
        );
        quejaRepository.save(queja2);

        // Queja de Juan Pérez sobre el servicio de energía
        Queja queja3 = new Queja(
                sdf.parse("2023-10-03"),
                "Reclamo",
                "Cortes frecuentes de energía.",
                servicioEnergia,
                empresa3,
                usuarioJuan
        );
        quejaRepository.save(queja3);

        System.out.println("Base de datos inicializada con datos de ejemplo.");
    }   
}
