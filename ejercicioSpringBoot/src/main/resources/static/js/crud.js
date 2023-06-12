$(document).ready(function() {
    cargarAlumnos();
});

async function cargarAlumnos(){
    const request = await fetch('/listar', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    const alumnos = await request.json();
    console.log(alumnos);

    let alumnosHTML = "";
    for(let alumno of alumnos){
        let HTML = '<tr>' +
            '<td>'+alumno.nombre+'</td>' +
            '<td>'+alumno.nota +'</td>' +
            '<td><button onclick="eliminar('+alumno.id+')">Eliminar</button></td>'+
            '<td><button><a href="../edit.html"></a>Editar</button></td>'+
            '</tr>';
        alumnosHTML = alumnosHTML + HTML;
    }
    document.querySelector('#alumno tbody').innerHTML = alumnosHTML;
}

async function eliminar(id){
    const request = await fetch('/eliminar/' + id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    location.reload();
}

async function añadir(){
    let datos = {};
    datos.nombre = document.getElementById("txtNombre").value;
    datos.nota = document.getElementById("txtNota").value;


    const request = await fetch('/añadirAlumnos', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    location.reload();
}