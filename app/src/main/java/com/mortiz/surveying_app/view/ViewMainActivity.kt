package com.mortiz.surveying_app.view

import android.app.Activity
import android.os.Bundle

class ViewMainActivity : Activity() {
    //Desarrollar una app que permita al usuario
//votar entre tres opciones. La aplicación debe seguir el patrón MVP. La vista
//(MainActivity) debe mostar los botones de votación, el presentador gestionar la lógica
//de votos y actualizar la vista, y el modelo almacenar los votos (puede ser una lista o
//contador en memoria).

//Requisitos:
// Implementar clases separadas para Vista, Presentador y Modelo.
// Inyectar el modelo al presentador (inyección de dependencias).
// La vista debe comunicarse solo con el presentador.
// El presentador debe invocar actualizaciones en la vista mediante una interfaz

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}