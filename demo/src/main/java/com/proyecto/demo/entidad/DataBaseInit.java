package com.proyecto.demo.entidad;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.proyecto.demo.repositorio.*;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Transactional
@Slf4j // Soporte para logging
public class DataBaseInit implements ApplicationRunner {

        private final UsuarioRepository usuarioRepository;
        private final EmpresaRepository empresaRepository;
        private final QuejaRepository quejaRepository;
        private final EntidadVigilanteRepository entidadVigilanteRepository;
        private final ServicioRepository servicioRepository;
        private final TipoQuejaRepository tipoQuejaRepository;

        @Override
        public void run(ApplicationArguments args) throws Exception {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                // Inicializar Entidad Vigilante
                EntidadVigilante entidadVigilante = new EntidadVigilante(
                                "Superintendencia de Servicios Públicos Domiciliarios",
                                123456789,
                                "admin@gmail.com",
                                "123");
                entidadVigilanteRepository.save(entidadVigilante);

                // Insertar usuarios
                Usuario[] usuarios = {
                                new Usuario("Juan Pérez", 123456789, 3001234567L, "Juan@gmail.com", "123", null),
                                new Usuario("María Gómez", 987654321, 3109876543L, "maria.gomez@gmail.com", "maria123",
                                                null),
                                new Usuario("Ana Rodríguez", 234567891, 3002345678L, "ana.rodriguez@gmail.com",
                                                "ana789", null),
                                new Usuario("Luis Martínez", 345678912, 3103456789L, "luis.martinez@gmail.com",
                                                "luis321", null),
                                new Usuario("Sofía Ramírez", 456789123, 3154567890L, "sofia@gmail.com", "sofia654",
                                                null),
                                new Usuario("Carlos Torres", 567891234, 3115678901L, "carlos@gmail.com", "carlos987",
                                                null),
                                new Usuario("Laura Fernández", 678912345, 3146789012L, "laura.fernandez@gmail.com",
                                                "laura147", null),
                                new Usuario("Diego Sánchez", 789123456, 3197890123L, "diego.sanchez@gmail.com",
                                                "diego258", null),
                                new Usuario("Paula Herrera", 891234567, 3168912345L, "paula.herrera@gmail.com",
                                                "paula369", null),
                                new Usuario("Fernando Gutiérrez", 912345678, 3179123456L, "fernando.gutierre@gmail.com",
                                                "fernando753",
                                                null),
                                new Usuario("Camila López", 102345678, 3121023456L, "camila.lopez@gmail.com",
                                                "camila852", null)
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
                                new Servicio("Servicio Aseo", empresas[4]) // Aseo Capital
                };
                servicioRepository.saveAll(Arrays.asList(servicios));

                // Insertar Tipos de Queja solo si la tabla está vacía
                if (tipoQuejaRepository.count() == 0) {
                        TipoQueja malServicio = new TipoQueja("Mal servicio", 2);
                        tipoQuejaRepository.save(malServicio);

                        TipoQueja cobrosIndebidos = new TipoQueja("Cobros indebidos", 5);
                        tipoQuejaRepository.save(cobrosIndebidos);

                        TipoQueja incumplimientoNormas = new TipoQueja("Incumplimiento de normas", 3);
                        tipoQuejaRepository.save(incumplimientoNormas);

                        TipoQueja suspensionSinAviso = new TipoQueja("Suspensión del servicio sin previo aviso", 1);
                        tipoQuejaRepository.save(suspensionSinAviso);

                        TipoQueja adulteracionContadores = new TipoQueja(
                                        "Adulteración o cambio de contadores o medidores", 5);
                        tipoQuejaRepository.save(adulteracionContadores);

                        TipoQueja danoPropiedadMobiliaria = new TipoQueja(
                                        "Daño a propiedad mobiliaria causada por empresa prestadora", 7);
                        tipoQuejaRepository.save(danoPropiedadMobiliaria);

                        TipoQueja danoPropiedadInmobiliaria = new TipoQueja(
                                        "Daño a propiedad inmobiliaria causada por empresa prestadora", 7);
                        tipoQuejaRepository.save(danoPropiedadInmobiliaria);
                        log.info("Tipos de queja insertados.");
                } else {
                        log.info("La tabla TipoQueja ya tiene registros. Se omite la inserción de tipos de queja.");
                }

                // Insertar quejas asociadas a los usuarios
                TipoQueja malServicio = tipoQuejaRepository.findById(1L)
                                .orElseThrow(() -> new RuntimeException("TipoQueja con id 1 no encontrado"));
                TipoQueja cobrosIndebidos = tipoQuejaRepository.findById(2L)
                                .orElseThrow(() -> new RuntimeException("TipoQueja con id 2 no encontrado"));
                TipoQueja suspensionSinAviso = tipoQuejaRepository.findById(4L)
                                .orElseThrow(() -> new RuntimeException("TipoQueja con id 4 no encontrado"));

                Queja[] quejas = {
                                new Queja(sdf.parse("2023-10-01"), malServicio, "El agua llega con mal olor y sabor.",
                                                servicios[1],
                                                empresas[0], usuarios[0]),
                                new Queja(sdf.parse("2023-10-02"), malServicio, "El gas no enciende correctamente.",
                                                servicios[2],
                                                empresas[1], usuarios[1]),
                                new Queja(sdf.parse("2023-10-03"), suspensionSinAviso, "Cortes frecuentes de energía.",
                                                servicios[4],
                                                empresas[2], usuarios[0])
                };
                quejaRepository.saveAll(Arrays.asList(quejas));

                System.out.println("Base de datos inicializada con datos de ejemplo.");
        }
}