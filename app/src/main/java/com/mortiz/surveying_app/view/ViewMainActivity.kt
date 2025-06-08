package com.mortiz.surveying_app.view

import android.app.Activity
import android.os.Bundle
import com.mortiz.surveying_app.R
import com.mortiz.surveying_app.model.ModelInjector
import com.mortiz.surveying_app.model.entities.Vote
import com.mortiz.surveying_app.model.repository.VotesRepositoryImpl
import com.mortiz.surveying_app.presentation.VotesPresenter

class ViewMainActivity : VotesView, Activity() {
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
    private lateinit var presenter: VotesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = ModelInjector.init()

    }

    override fun showAllVotes() {
        // Implementación para mostrar todos los votos

    }

    override fun showVotesByCategory(category: String) {

    }

}