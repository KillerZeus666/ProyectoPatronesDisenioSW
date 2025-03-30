package com.proyecto.demo.servicio;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.proyecto.demo.entidad.Incumplimiento;
import com.proyecto.demo.entidad.Profesional;
import com.proyecto.demo.entidad.Queja;
import com.proyecto.demo.entidad.Servicio;
import com.proyecto.demo.entidad.TipoQueja;
import com.proyecto.demo.repositorio.IncumplimientoRepository;
import com.proyecto.demo.repositorio.ProfesionalRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j; 

@Service
@Slf4j
public class ProfesionalServiceImpl implements ProfesionalService {

    @Autowired
    private ProfesionalRepository profesionalRepository;

    @Autowired
    private IncumplimientoRepository incumplimientoRepository;

    // Ejecutar balanceo al iniciar
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        balancearCargaTrabajo();
        System.out.println("Balanceo inicial completado.");
    }

    @Override
    @Transactional
    public void asignarIncumplimiento(Incumplimiento incumplimiento) {
        Queja queja = incumplimiento.getQueja();
        Servicio servicio = queja.getServicio();
        TipoQueja tipo = queja.getTipo();

        List<Profesional> profesionales = profesionalRepository.findByServicioAndTipo(servicio, tipo);

        if (profesionales.isEmpty()) {
            throw new RuntimeException("No hay profesionales para " + servicio.getTipo() + " y tipo " + tipo.getDescripcion());
        }

        Profesional profesional = profesionales.stream()
                .min(Comparator.comparingInt(Profesional::getCargaTrabajo))
                .orElseThrow(() -> new RuntimeException("Error al seleccionar profesional"));

        incumplimiento.setProfesionalAsignado(profesional);
        profesional.incrementarCargaTrabajo();
        incumplimientoRepository.save(incumplimiento);
        profesionalRepository.save(profesional);
    }

    @Override
    @Transactional
    public void balancearCargaTrabajo() {
        log.info("Iniciando balanceo de carga de trabajo...");
        
        List<Incumplimiento> incumplimientosSinAsignar = incumplimientoRepository.findByProfesionalAsignadoIsNull();
        log.info("Incumplimientos sin asignar encontrados: {}", incumplimientosSinAsignar.size());
    
        for (Incumplimiento inc : incumplimientosSinAsignar) {
            Queja queja = inc.getQueja();
            Servicio servicio = queja.getServicio();
            TipoQueja tipo = queja.getTipo();
            
            log.debug("Procesando incumplimiento ID {} (Servicio: {}, Tipo: {})", 
                     inc.getId(), servicio.getTipo(), tipo.getDescripcion());
    
            List<Profesional> profesionales = profesionalRepository.findByServicioAndTipo(servicio, tipo);
    
            if (profesionales.isEmpty()) {
                log.error("⚠️ No hay profesionales para Servicio: {} - Tipo de Queja: {}", 
                         servicio.getTipo(), tipo.getDescripcion());
                continue;
            }
    
            Profesional profesional = profesionales.stream()
                    .min(Comparator.comparingInt(Profesional::getCargaTrabajo))
                    .get(); 
    
            log.info("Asignando a Profesional ID {} (Carga actual: {})", 
                    profesional.getId(), profesional.getCargaTrabajo());
            
            inc.setProfesionalAsignado(profesional);
            profesional.incrementarCargaTrabajo();
            
            incumplimientoRepository.save(inc);
            profesionalRepository.save(profesional);
            
            log.debug("Incumplimiento ID {} asignado. Nueva carga del profesional: {}", 
                     inc.getId(), profesional.getCargaTrabajo());
        }
        
        log.info("Balanceo de carga completado. Incumplimientos asignados: {}", incumplimientosSinAsignar.size());
    }

    @Override
    @Scheduled(cron = "*/15 * * * * *")
    public void balancearAutomaticamente() {
        balancearCargaTrabajo();
        System.out.println("Balanceo periódico: " + LocalDateTime.now());
    }
}