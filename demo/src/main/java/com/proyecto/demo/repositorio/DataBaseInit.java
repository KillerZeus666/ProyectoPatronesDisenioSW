package com.proyecto.demo.repositorio;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.entidad.EntidadVigilante;
import com.proyecto.demo.entidad.Profesional;
import com.proyecto.demo.entidad.Queja;
import com.proyecto.demo.entidad.Servicio;
import com.proyecto.demo.entidad.TipoQueja;
import com.proyecto.demo.entidad.Usuario;

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
    private final ProfesionalRepository profesionalRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Inicializando la base de datos con datos de ejemplo...");

        try {
            // Inicializar Entidad Vigilante solo si la tabla está vacía
            if (entidadVigilanteRepository.count() == 0) {
                EntidadVigilante entidadVigilante = new EntidadVigilante(
                        "Superintendencia de Servicios Públicos Domiciliarios",
                        123456789,
                        "admin@gmail.com",
                        "123");
                entidadVigilanteRepository.save(entidadVigilante);
                log.info("Entidad Vigilante insertada.");
            } else {
                log.info("La tabla EntidadVigilante ya tiene registros. Se omite la inserción.");
            }

            // Insertar Usuarios (no profesionales) solo si la tabla está vacía
            if (usuarioRepository.count() == 0) {
                Usuario usuarioJuan = new Usuario(
                        "Juan Pérez",
                        123456789,
                        3001234567L,
                        "juan.perez@example.com",
                        "juan123",
                        null);
                usuarioRepository.save(usuarioJuan);

                Usuario usuarioMaria = new Usuario(
                        "María Gómez",
                        987654321,
                        3109876543L,
                        "maria.gomez@example.com",
                        "maria123",
                        null);
                usuarioRepository.save(usuarioMaria);
                log.info("Usuarios base insertados.");
            } else {
                log.info("La tabla Usuario ya tiene registros. Se omite la inserción de usuarios base.");
            }

            // Insertar Empresas solo si la tabla está vacía
            if (empresaRepository.count() == 0) {
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
                log.info("Empresas insertadas.");
            } else {
                log.info("La tabla Empresa ya tiene registros. Se omite la inserción de empresas.");
            }


            if (servicioRepository.count() == 0) {
                
                Empresa empresa1 = new Empresa();
                empresa1.setId(1L);
                Empresa empresa2 = new Empresa();
                empresa2.setId(2L);
                Empresa empresa3 = new Empresa();
                empresa3.setId(3L);

                Servicio servicioAgua = new Servicio("Agua Potable", empresa1);
                servicioRepository.save(servicioAgua);

                Servicio servicioAlcantarillado = new Servicio("Alcantarillado", empresa1);
                servicioRepository.save(servicioAlcantarillado);

                Servicio servicioGas = new Servicio("Gas Domiciliario", empresa2);
                servicioRepository.save(servicioGas);

                Servicio servicioEnergia = new Servicio("Energía Eléctrica", empresa3);
                servicioRepository.save(servicioEnergia);
                log.info("Servicios insertados.");
            } else {
                log.info("La tabla Servicio ya tiene registros. Se omite la inserción de servicios.");
            }

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

                TipoQueja adulteracionContadores = new TipoQueja("Adulteración o cambio de contadores o medidores", 5);
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

            // Insertar Quejas solo si la tabla está vacía
            if (quejaRepository.count() == 0) {
                // Recuperar referencias desde los repositorios (asegúrate de que los IDs usados
                // existen)
                Servicio servicioAgua = servicioRepository.findById(1L)
                        .orElseThrow(() -> new RuntimeException("Servicio con id 1 no encontrado"));
                Servicio servicioGas = servicioRepository.findById(3L)
                        .orElseThrow(() -> new RuntimeException("Servicio con id 3 no encontrado"));
                Servicio servicioEnergia = servicioRepository.findById(4L)
                        .orElseThrow(() -> new RuntimeException("Servicio con id 4 no encontrado"));

                TipoQueja malServicio = tipoQuejaRepository.findById(1L)
                        .orElseThrow(() -> new RuntimeException("TipoQueja con id 1 no encontrado"));
                TipoQueja cobrosIndebidos = tipoQuejaRepository.findById(2L)
                        .orElseThrow(() -> new RuntimeException("TipoQueja con id 2 no encontrado"));
                TipoQueja suspensionSinAviso = tipoQuejaRepository.findById(4L)
                        .orElseThrow(() -> new RuntimeException("TipoQueja con id 4 no encontrado"));

                Empresa empresaRef1 = empresaRepository.findById(1L)
                        .orElseThrow(() -> new RuntimeException("Empresa con id 1 no encontrada"));
                Empresa empresaRef2 = empresaRepository.findById(2L)
                        .orElseThrow(() -> new RuntimeException("Empresa con id 2 no encontrada"));
                Empresa empresaRef3 = empresaRepository.findById(3L)
                        .orElseThrow(() -> new RuntimeException("Empresa con id 3 no encontrada"));

                // Se asume que los usuarios ya existen
                Usuario usuarioJuan = usuarioRepository.findAll().stream().findFirst().orElse(null);
                Usuario usuarioMaria = usuarioRepository.findAll().stream().skip(1).findFirst().orElse(null);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                Queja queja1 = new Queja(
                        sdf.parse("2023-10-01"),
                        malServicio,
                        "El agua llega con mal olor y sabor.",
                        servicioAgua,
                        empresaRef1, // Se usa la instancia gestionada
                        usuarioJuan);
                quejaRepository.save(queja1);

                Queja queja2 = new Queja(
                        sdf.parse("2023-10-02"),
                        cobrosIndebidos,
                        "El gas no enciende correctamente.",
                        servicioGas,
                        empresaRef2, // Se usa la instancia gestionada
                        usuarioMaria);
                quejaRepository.save(queja2);

                Queja queja3 = new Queja(
                        sdf.parse("2023-10-03"),
                        suspensionSinAviso,
                        "Cortes frecuentes de energía.",
                        servicioEnergia,
                        empresaRef3, // Se usa la instancia gestionada
                        usuarioJuan);
                quejaRepository.save(queja3);
                log.info("Quejas insertadas.");
            } else {
                log.info("La tabla Queja ya tiene registros. Se omite la inserción de quejas.");
            }

            // Insertar Profesionales solo si no existen en la tabla Profesional
            if (profesionalRepository.count() == 0) {
                
                List<Servicio> servicios = servicioRepository.findAll();
                List<TipoQueja> tipos = tipoQuejaRepository.findAll();
                int counter = 1;

                for (Servicio servicio : servicios) {
                        for (TipoQueja tipo : tipos) {
                                Profesional profesional = new Profesional(
                                        "Profesional " + counter,
                                        100000000L + counter, // Cedula única
                                        3000000000L + counter, // Celular único
                                        "profesional" + counter + "@example.com",
                                        "password",
                                        servicio,
                                        tipo
                                );
                                profesionalRepository.save(profesional);
                                counter++;
                                log.info("Profesional {} creado para {} - {}", counter, servicio.getTipo(), tipo.getDescripcion());
                        }
                }

                log.info("{} profesionales insertados (uno por cada servicio/tipo).", servicios.size() * tipos.size());
            } else {
                log.info("Ya existen " + profesionalRepository.count()
                        + " profesionales en la base de datos. Se omite la inserción.");
            }

            log.info("Inicialización de la base de datos completada.");
        } catch (Exception e) {
            log.error("Error durante la inicialización de la base de datos: " + e.getMessage(), e);
            throw e;
        }
    }
}
