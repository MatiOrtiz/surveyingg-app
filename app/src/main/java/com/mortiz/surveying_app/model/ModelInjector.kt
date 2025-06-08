package com.mortiz.surveying_app.model

import com.mortiz.surveying_app.model.repository.VotesRepository
import com.mortiz.surveying_app.model.repository.VotesRepositoryImpl
import com.mortiz.surveying_app.presentation.VotesPresenter

object ModelInjector {

    fun init(): VotesPresenter {
        val repository = VotesRepositoryImpl()
        return VotesPresenter(repository)
    }

}