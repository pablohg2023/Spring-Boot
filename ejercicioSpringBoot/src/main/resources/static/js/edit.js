$(document).ready(function() {
    cargarEdit();
});

async function cargarEdit(){
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
            '</tr>';
        alumnosHTML = alumnosHTML + HTML;
    }
    document.querySelector('#alumno tbody').innerHTML = alumnosHTML;
}

async function update(idAlumno) {
    let alumno = {};
    alumno.id = idAlumno;
    alumno.nombre = document.getElementById("nombre").value;
    alumno.nota = document.getElementById("nota").value;

    if (alumno.nombre !== "" && alumno.nota !== "") {

        const request = await fetch('/updateAlumno/', {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(alumno)
        });
    }
    location.href = "../admin.html";
}
