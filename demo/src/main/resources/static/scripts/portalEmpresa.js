document.addEventListener("DOMContentLoaded", function () {
    const botonVerQuejas = document.getElementById("verQuejas");
    const resultados = document.getElementById("resultados");
    
    botonVerQuejas.addEventListener("click", function () {
        const empresaId = document.getElementById("empresaNombre").dataset.empresaId; // Asegúrate de asignar esto en la vista
        
        fetch(`/quejas/${empresaId}`)
            .then(response => response.json())
            .then(quejas => {
                resultados.innerHTML = ""; // Limpiar resultados previos
                if (quejas.length === 0) {
                    resultados.innerHTML = "<p>No hay quejas registradas para esta empresa.</p>";
                } else {
                    quejas.forEach(queja => {
                        const quejaElemento = document.createElement("p");
                        quejaElemento.textContent = `${queja.descripcion} - ${queja.fecha}`;
                        resultados.appendChild(quejaElemento);
                    });
                }
            })
            .catch(error => console.error("Error obteniendo las quejas:", error));
    });
});
