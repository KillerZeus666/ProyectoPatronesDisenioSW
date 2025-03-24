document.addEventListener("DOMContentLoaded", function () {
    let mensaje = document.querySelector('.mensaje-exito');
    if (mensaje) {
        setTimeout(() => {
            mensaje.style.opacity = "0";
            setTimeout(() => {
                mensaje.remove();
            }, 500); // Espera a que termine la animación y lo elimina del DOM
        }, 3000);
    }
});
