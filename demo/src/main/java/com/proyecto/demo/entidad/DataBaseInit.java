package com.proyecto.demo.entidad;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.proyecto.demo.repositorio.*;

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
    private final ServicioRepository servicioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Inicializar Entidad Vigilante
        EntidadVigilante entidadVigilante = new EntidadVigilante(
                "Superintendencia de Servicios Públicos Domiciliarios", 
                123456789, 
                "sspd@gmail.com", 
                "sspd123"
        );
        entidadVigilanteRepository.save(entidadVigilante);

        // Insertar usuarios
        Usuario[] usuarios = {
            new Usuario("Juan Pérez", 123456789, 3001234567L, "Juan@gmail.com", "123", null),
            new Usuario("María Gómez", 987654321, 3109876543L, "maria.gomez@gmail.com", "maria123", null),
            new Usuario("Ana Rodríguez", 234567891, 3002345678L, "ana.rodriguez@gmail.com", "ana789", null),
            new Usuario("Luis Martínez", 345678912, 3103456789L, "luis.martinez@gmail.com", "luis321", null),
            new Usuario("Sofía Ramírez", 456789123, 3154567890L, "sofia@gmail.com", "sofia654", null),
            new Usuario("Carlos Torres", 567891234, 3115678901L, "carlos@gmail.com", "carlos987", null),
            new Usuario("Laura Fernández", 678912345, 3146789012L, "laura.fernandez@gmail.com", "laura147", null),
            new Usuario("Diego Sánchez", 789123456, 3197890123L, "diego.sanchez@gmail.com", "diego258", null),
            new Usuario("Paula Herrera", 891234567, 3168912345L, "paula.herrera@gmail.com", "paula369", null),
            new Usuario("Fernando Gutiérrez", 912345678, 3179123456L, "fernando.gutierre@gmail.com", "fernando753", null),
            new Usuario("Camila López", 102345678, 3121023456L, "camila.lopez@gmail.com", "camila852", null)
        };
        usuarioRepository.saveAll(Arrays.asList(usuarios));

        // Insertar empresas
        Empresa[] empresas = {
            new Empresa("Acueducto", "1"),
            new Empresa("Codensa", "2"),
            new Empresa("Epm", "3"),
            new Empresa("Aguas de la Sabana Bogota", "4"),
            new Empresa("Aseo Capital", "5"),
            new Empresa("EmCali", "6"),
            new Empresa("InterColombia", "7"),
            new Empresa("Veolia", "8")
        };
        empresaRepository.saveAll(Arrays.asList(empresas));

        // Insertar servicios asociados a las empresas
        Servicio[] servicios = {
            new Servicio("Agua Potable", empresas[5]), // EmCali
            new Servicio("Agua Potable", empresas[0]), // Acueducto
            new Servicio("Energía Eléctrica", empresas[1]), // Codensa
            new Servicio("Energía Eléctrica", empresas[6]), // InterColombia
            new Servicio("Alcantarillado", empresas[2]), // EPM
            new Servicio("Alcantarillado", empresas[3]), // Aguas de la Sabana
            new Servicio("Servicio Aseo", empresas[7]), // Veolia
            new Servicio("Servicio Aseo", empresas[4])  // Aseo Capital
        };
        servicioRepository.saveAll(Arrays.asList(servicios));

        // Insertar quejas asociadas a los usuarios
        Queja[] quejas = {
            new Queja(sdf.parse("2023-10-01"), "Reclamo", "El agua llega con mal olor y sabor.", servicios[1], empresas[0], usuarios[0]),
            new Queja(sdf.parse("2023-10-02"), "Reclamo", "El gas no enciende correctamente.", servicios[2], empresas[1], usuarios[1]),
            new Queja(sdf.parse("2023-10-03"), "Reclamo", "Cortes frecuentes de energía.", servicios[4], empresas[2], usuarios[0])
        };
        quejaRepository.saveAll(Arrays.asList(quejas));

        System.out.println("Base de datos inicializada con datos de ejemplo.");
    }   
}