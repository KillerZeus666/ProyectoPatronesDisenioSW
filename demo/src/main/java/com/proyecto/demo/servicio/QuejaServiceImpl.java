package com.proyecto.demo.servicio;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.entidad.Queja;
import com.proyecto.demo.entidad.Servicio;
import com.proyecto.demo.entidad.TipoQueja;
import com.proyecto.demo.entidad.Usuario;
import com.proyecto.demo.repositorio.EmpresaRepository;
import com.proyecto.demo.repositorio.QuejaRepository;
import com.proyecto.demo.repositorio.ServicioRepository;
import com.proyecto.demo.repositorio.TipoQuejaRepository;
import com.proyecto.demo.repositorio.UsuarioRepository;

import jakarta.annotation.PostConstruct;

@Service
public class QuejaServiceImpl implements QuejaService {

    @Autowired
    private QuejaRepository quejaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository; // Agregado para validar el usuario

    @Autowired
    private EmpresaRepository empresaRepository; // Agregado para validar la empresa

    @Autowired
    private TipoQuejaRepository tipoQuejaRepository; // Agregado para validar el tipo de queja

    private final List<IncumplimientoService> observers;

    @Autowired
    public QuejaServiceImpl(List<IncumplimientoService> observers) {
        this.observers = observers;
    }

    @PostConstruct
    public void init() {
        System.out.println("QuejaServiceImpl ha sido registrado por Spring!");
    }

    @PostConstruct
    public void initializeQuejaCheck() {
        verificarQuejasVencidas();
    }

    @Override
    public Queja registrarQueja(Date fecha, Long idTipoQueja, String descripcion, Long idServicio, Long idEmpresa, Long idUsuario) {
        Servicio servicio = servicioRepository.findById(idServicio)
                .orElseThrow(() -> new IllegalArgumentException("El servicio especificado no existe"));

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("El usuario especificado no existe"));
        
        Empresa empresa = empresaRepository.findById(idEmpresa)
                .orElseThrow(() -> new IllegalArgumentException("La empresa especificada no existe"));

        TipoQueja tipoQueja = tipoQuejaRepository.findById(idTipoQueja)
                .orElseThrow(() -> new IllegalArgumentException("El tipo de queja especificado no existe"));

        if (fecha == null) {
            fecha = new Date(); // Asigna la fecha actual si no se envía
        }

        Queja nuevaQueja = new Queja(fecha, tipoQueja, descripcion, servicio, empresa, usuario);

        return quejaRepository.save(nuevaQueja);
    }


    @Override
    public Queja buscarQueja(Long id) {
        return quejaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Queja> verQuejasPorUsr(Long cedula) {
        return quejaRepository.findByUsuario_Cedula(cedula);
    }

    public List<Queja> verQuejasPorEmpresa(Long empresaId) {
        List<Queja> quejas = quejaRepository.findByEmpresa_Id(empresaId);
        System.out.println("Quejas encontradas para empresa " + empresaId + ": " + quejas.size());
        return quejas;
    }
    

    // Notifica el vencimiento de la queja a todos los observadores (servicios de incumplimiento)
    private void notificarVencimiento(Queja queja) {
        // Log para notificar el envío
        System.out.println("Notificando vencimiento de queja con id: " + queja.getId());

        for (IncumplimientoService observer : observers) {
            observer.onQuejaVencida(queja);
        }
    }

    @Override
    @Scheduled(cron = "*/5 * * * * *") // Ejecutar cada 5 segundos
    public void verificarQuejasVencidas() {
        System.out.println("[SCHEDULER] Iniciando verificación de quejas vencidas...");
        
        // 1. Obtener fecha actual en UTC
        Date fechaActual = Date.from(LocalDateTime.now().atZone(ZoneId.of("UTC")).toInstant());
        
        // 2. Buscar quejas vencidas no procesadas usando la consulta
        List<Queja> quejasVencidas = quejaRepository.findQuejasVencidasNoProcesadas(fechaActual);
        
        // Log de cantidad encontrada
        System.out.println("[SCHEDULER] Quejas vencidas encontradas: " + quejasVencidas.size());
        
        // 3. Procesar cada queja
        quejasVencidas.forEach(queja -> {
            notificarVencimiento(queja);
            queja.setProcesada(true);
            quejaRepository.save(queja);
        });
    }

    // Ejecutar al iniciar la aplicación (solo una vez)
    @EventListener(ApplicationReadyEvent.class)
    public void ejecutarAlInicio() {
        System.out.println("[INICIO] Ejecutando primera verificación de quejas vencidas...");
        verificarQuejasVencidas();
    }
}
