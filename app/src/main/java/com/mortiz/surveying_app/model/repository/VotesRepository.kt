package com.mortiz.surveying_app.model.repository

import com.mortiz.surveying_app.model.entities.Vote

interface VotesRepository {
    fun addVote(vote: Vote): Boolean
    
    fun getAllVotes(): List<Vote>

    fun getVotesByCategory(category: String): List<Vote>

}