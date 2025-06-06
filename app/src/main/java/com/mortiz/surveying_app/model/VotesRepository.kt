package com.mortiz.surveying_app.model

interface VotesRepository {
    fun addVote(vote: String): Boolean
    
    fun getVotes(): List<String>

}