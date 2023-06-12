async function añadir(){
    let datos = {};
    datos.nombre = document.getElementById("nombre").value;
    datos.contraseña = document.getElementById("password").value;
    datos.admin = 2;

    const request = await fetch('/añadirUsuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    location.href = "../index.html";
}

async function comprobar(){
    let datos = {};
    datos.nombre = document.getElementById("nombre").value;
    datos.contraseña = document.getElementById("password").value;

    const request = await fetch('/buscar/' + datos.nombre + '/' + datos.contraseña, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });

    const bool = await request.json();

    if (bool.id !=0){
        if(bool.admin === 1){
            location.href = "../admin.html"
        }else {
            location.href = "../tabla.html"
        }
    }else{
        alert("No existe");
    }
}
