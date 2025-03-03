document.getElementById("Buscar").addEventListener("click", function() {
    const empresaSeleccionada = document.getElementById("empresa").value;
    const contenedorResultados = document.getElementById("resultados");

    // Simulación de quejas
    const quejas = [
        { motivo: "Corte prolongado de agua", empresa: "Acueducto", usuario: "María Camila López", fecha: "20 de febrero de 2025", tipo: "Queja vía Email", vencida:1 },
        { motivo: "Baja Presión del Suministro", empresa: "Acueducto", usuario: "Juan Camilo Mora", fecha: "23 de febrero de 2025", tipo: "Queja App móvil", vencida:0},
        { motivo: "Fuga de Agua en la vía pública", empresa: "Acueducto", usuario: "Diana Milena Rojas", fecha: "04 de de 2025", tipo: "Queja vía Email", vencida:1 },
        { motivo: "Falta de aviso previo en cortes programados", empresa: "Acueducto", usuario: "Walter White", fecha: "10 de diciembre de 2025", tipo: "Queja vía App Móvil", vencida:1 },
        { motivo: "Facturación incorrecta", empresa: "EmCali", usuario: "Juan Pérez", fecha: "15 de enero de 2025", tipo: "Queja vía App móvil", vencida:1  },
        { motivo: "Falla en el servicio eléctrico", empresa: "epm", usuario: "Ana Ramírez", fecha: "8 de marzo de 2025", tipo: "Queja vía Email" , vencida:0 }
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
                <p class="estado"><strong>Estado:</strong> ${queja.vencida === 1 ? "Vencida" : "No vencida"}</p>
                <h2>${queja.tipo}</h2>



                <div class="usuario">
                    <img src="https://cdn-icons-png.flaticon.com/512/2519/2519204.png" alt="Foto usuario">
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
