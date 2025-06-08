package com.mortiz.surveying_app.model.repository

import com.mortiz.surveying_app.model.entities.Vote

class VotesRepositoryImpl : VotesRepository {
    private  val votes = mutableListOf<Vote>()

    override fun addVote(vote: Vote): Boolean {
        return if (vote.category in listOf("Option1", "Option2", "Option3")) {
            votes.add(vote)
            true
        } else {
            false
        }
    }

    override fun getAllVotes(): List<Vote> {
        return votes
    }

    override fun getVotesByCategory(category: String): List<Vote> {
        var votesFiltred : List<Vote> = emptyList()
        for (vote in votes) {
            if (vote.category == category) {
                votesFiltred = votes.filter { it.category == category }
            }
        }
        return votesFiltred
    }

}