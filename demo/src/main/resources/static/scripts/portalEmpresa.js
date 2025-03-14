document.addEventListener("DOMContentLoaded", function() {
    const empresaNombre = document.getElementById("empresaNombre").textContent.trim();
    const contenedorResultados = document.getElementById("resultados");

    document.getElementById("verQuejas").addEventListener("click", function() {
        // Simulación de quejas
        const quejas = [
            { motivo: "Corte prolongado de agua", empresa: "Acueducto", usuario: "María Camila López", fecha: "20 de febrero de 2025", tipo: "Queja vía Email", vencida: 1 },
            { motivo: "Facturación incorrecta", empresa: "EmCali", usuario: "Juan Pérez", fecha: "15 de enero de 2025", tipo: "Queja vía App móvil", vencida: 1 },
            { motivo: "Falla en el servicio eléctrico", empresa: "Epm", usuario: "Ana Ramírez", fecha: "8 de marzo de 2025", tipo: "Queja vía Email", vencida: 0 }
        ];

        // Filtrar quejas por la empresa en sesión
        const quejasFiltradas = quejas.filter(queja => queja.empresa.toLowerCase() === empresaNombre.toLowerCase());

        // Limpiar resultados anteriores
        contenedorResultados.innerHTML = "";

        // Mostrar las quejas
        if (quejasFiltradas.length > 0) {
            quejasFiltradas.forEach(queja => {
                const tarjeta = document.createElement("div");
                tarjeta.classList.add("tarjeta");

                tarjeta.innerHTML = `
                    <h3>${queja.motivo}</h3>
                    <p><strong>Tipo:</strong> ${queja.tipo}</p>
                    <p class="estado"><strong>Estado:</strong> ${queja.vencida === 1 ? "Vencida" : "No vencida"}</p>
                    
                    <div class="usuario">
                        <img src="https://cdn-icons-png.flaticon.com/512/2519/2519204.png" alt="Foto usuario">
                        <div>
                            <strong>${queja.usuario}</strong>
                            <p class="fecha">${queja.fecha}</p>
                        </div>
                    </div>
                    
                    <!-- Botón para responder -->
                    <button class="btn-responder">Responder</button>
                `;
                contenedorResultados.appendChild(tarjeta);
            });
        } else {
            contenedorResultados.innerHTML = "<p>No hay quejas registradas para esta empresa.</p>";
        }
    });
});
