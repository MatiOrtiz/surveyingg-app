package com.mortiz.surveying_app.model

import com.mortiz.surveying_app.model.repository.VotesRepository
import com.mortiz.surveying_app.model.repository.VotesRepositoryImpl
import com.mortiz.surveying_app.presentation.VotesPresenter
import com.mortiz.surveying_app.presentation.VotesPresenterImpl
import com.mortiz.surveying_app.presentation.VotesObserver

object ModelInjector {
    fun init(observer: VotesObserver): VotesPresenter {
        val repository = VotesRepositoryImpl()
        val presenter = VotesPresenterImpl(repository)
        presenter.addObserver(observer)
        return presenter
    }
}