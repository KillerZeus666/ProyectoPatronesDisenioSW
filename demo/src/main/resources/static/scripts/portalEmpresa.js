document.getElementById("Buscar").addEventListener("click", function() {
    const empresaSeleccionada = document.getElementById("empresa").value;
    const contenedorResultados = document.getElementById("resultados");

    // Simulación de quejas
    const quejas = [
        { motivo: "Corte prolongado de agua", empresa: "Acueducto", usuario: "María Camila López", fecha: "20 de febrero de 2025" },
        { motivo: "Facturación incorrecta", empresa: "EmCali", usuario: "Juan Pérez", fecha: "15 de enero de 2025" },
        { motivo: "Falla en el servicio eléctrico", empresa: "epm", usuario: "Ana Ramírez", fecha: "8 de marzo de 2025" }
    ];

    // Filtrar quejas por la empresa seleccionada
    const quejasFiltradas = quejas.filter(queja => queja.empresa === empresaSeleccionada);

    // Limpiar resultados anteriores
    contenedorResultados.innerHTML = "";

    // Si hay quejas, generarlas dinámicamente
    if (quejasFiltradas.length > 0) {
        quejasFiltradas.forEach(queja => {
            const tarjeta = document.createElement("div");
            tarjeta.classList.add("tarjeta");

            tarjeta.innerHTML = `
                <h3>${queja.motivo}</h3>
                <p>${queja.empresa}</p>
                <div class="usuario">
                    <img src="https://randomuser.me/api/portraits/women/45.jpg" alt="Foto usuario">
                    <div>
                        <strong>${queja.usuario}</strong>
                        <p class="fecha">${queja.fecha}</p>
                    </div>
                </div>
            `;
            contenedorResultados.appendChild(tarjeta);
        });
    } else {
        contenedorResultados.innerHTML = "<p>No hay quejas registradas para esta empresa.</p>";
    }
});
