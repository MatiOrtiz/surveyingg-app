package com.mortiz.surveying_app.view

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.mortiz.surveying_app.R
import com.mortiz.surveying_app.model.ModelInjector
import com.mortiz.surveying_app.presentation.VotesPresenter
import com.mortiz.surveying_app.presentation.VotesState
import com.mortiz.surveying_app.presentation.VotesObserver

class ViewMainActivity : Activity(), VotesObserver {
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

    private lateinit var suveyingAppTextView : TextView

    private lateinit var option1Button : Button
    private lateinit var option2Button: Button
    private lateinit var option3Button: Button
    private lateinit var showAllVotesButton: Button
    private lateinit var showVotesByCategoryButton: Button
    private lateinit var categoryEditText :EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = ModelInjector.init(this)
        initProperties()
        initListeners()
    }

    private fun initProperties(){
        suveyingAppTextView = findViewById(R.id.surveyingAppTextView)

        option1Button = findViewById(R.id.option1Button)
        option2Button = findViewById(R.id.option2Button)
        option3Button = findViewById(R.id.option3Button)
        showAllVotesButton = findViewById(R.id.totalVotesButton)
        showVotesByCategoryButton = findViewById(R.id.categoryVotesButton)
        categoryEditText = findViewById(R.id.categoryEditText)
    }

    private fun initListeners() {
        option1Button.setOnClickListener {
            presenter.addVote("Option1")
        }
        option2Button.setOnClickListener {
            presenter.addVote("Option2")
        }
        option3Button.setOnClickListener {
            presenter.addVote("Option3")
        }
        showAllVotesButton.setOnClickListener {
            presenter.getAllVotes()
        }
        showVotesByCategoryButton.setOnClickListener {
            val category = categoryEditText.text.toString()
            if (category.isNotEmpty()) {
                presenter.getVotesByCategory(category)
            } else {
                android.app.AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Please enter a category.")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }
    }


    override fun onStateChanged(state: VotesState) {
        when (state) {
            is VotesState.ShowTotalVotes -> {
                android.app.AlertDialog.Builder(this)
                    .setTitle("Total Votes")
                    .setMessage("Total votes: ${state.totalVotes}")
                    .setPositiveButton("OK", null)
                    .show()
            }

            is VotesState.ShowVotesByCategory -> {
                android.app.AlertDialog.Builder(this)
                    .setTitle("Votes by Category")
                    .setMessage("Total votes for ${state.category}: ${state.totalVotes}")
                    .setPositiveButton("OK", null)
                    .show()
            }

            is VotesState.Error -> {
                android.app.AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage(state.message)
                    .setPositiveButton("OK", null)
                    .show()
            }
        }
    }

}