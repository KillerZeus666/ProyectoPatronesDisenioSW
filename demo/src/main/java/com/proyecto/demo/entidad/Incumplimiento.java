package com.proyecto.demo.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Incumplimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descripcion;
    
    // 1 Queja → 0 o 1 Incumplimiento
    @ManyToOne
    @JoinColumn(
        name = "queja_id", 
        nullable = false, 
        unique = true
    )
    private Queja queja;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "profesional_id", nullable = true)
    private Profesional profesionalAsignado;

    // Constructor con parámetros
    public Incumplimiento(String descripcion, Queja queja, Empresa empresa) {
        this.descripcion = descripcion;
        this.queja = queja;
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Incumplimiento{id=" + id + ", descripcion='" + descripcion + '\'' + ", queja=" + queja + ", empresa=" + empresa + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Incumplimiento that = (Incumplimiento) obj;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
