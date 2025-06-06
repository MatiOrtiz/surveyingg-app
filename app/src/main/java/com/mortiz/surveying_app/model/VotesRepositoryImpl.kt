package com.mortiz.surveying_app.model

class VotesRepositoryImpl : VotesRepository {
    private  val votes = mutableListOf<String>()

    override fun addVote(vote: String): Boolean {
        return if (vote in listOf("Option1", "Option2", "Option3")) {
            votes.add(vote)
            true
        } else {
            false
        }
    }

    override fun getVotes(): List<String> {
        return votes
    }

}