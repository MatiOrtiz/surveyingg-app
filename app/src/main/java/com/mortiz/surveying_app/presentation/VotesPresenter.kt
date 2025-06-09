package com.mortiz.surveying_app.presentation

import com.mortiz.surveying_app.model.entities.Vote
import com.mortiz.surveying_app.model.repository.VotesRepository


interface VotesObserver {
    fun onStateChanged(state: VotesState)
}

interface VotesPresenter{
    fun addObserver(observer: VotesObserver)
    fun removeObserver(observer: VotesObserver)

    fun addVote(category: String)
    fun getAllVotes()
    fun getVotesByCategory(category: String)
}

internal class VotesPresenterImpl(
    private val repository: VotesRepository
    ): VotesPresenter {

    private val observers = mutableListOf<VotesObserver>()

    override fun addObserver(observer: VotesObserver) {
        observers.add(observer)
    }

    override fun removeObserver(observer: VotesObserver) {
        observers.remove(observer)
    }

    private fun notifyObservers(state: VotesState) {
        observers.forEach { it.onStateChanged(state) }
    }

    override fun addVote(category: String) {
        try {
            repository.addVote(Vote(0, category))
            //notifyObservers(VotesState.ShowTotalVotes(repository.getAllVotes().size))
        } catch (e: Exception) {
            notifyObservers(VotesState.Error("An error occurred: ${e.message}"))
        }
    }


    override fun getAllVotes() {
        try {
            val totalVotes = repository.getAllVotes().size
            notifyObservers(VotesState.ShowTotalVotes(totalVotes))
        } catch (e: Exception) {
            notifyObservers(VotesState.Error("An error occurred: ${e.message}"))
        }
    }

    override fun getVotesByCategory(category: String) {
        try {
            val totalVotes = repository.getVotesByCategory(category).size
            notifyObservers(VotesState.ShowVotesByCategory(category, totalVotes))
        } catch (e: Exception) {
            notifyObservers(VotesState.Error("An error occurred: ${e.message}"))
        }
    }

}