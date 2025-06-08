package com.mortiz.surveying_app.presentation

import com.mortiz.surveying_app.model.entities.Vote
import com.mortiz.surveying_app.model.repository.VotesRepository

class VotesPresenter(votes:VotesRepository) {

    private val votesRepository: VotesRepository = votes

    fun addVote(vote: Vote) {
        votesRepository.addVote(vote)
    }

    fun getAllVotes(): List<Vote> {
        return votesRepository.getAllVotes()
    }

    fun getVotesByCategory(category: String): List<Vote> {
        return votesRepository.getVotesByCategory(category)
    }

}