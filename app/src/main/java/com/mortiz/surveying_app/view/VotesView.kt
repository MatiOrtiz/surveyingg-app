package com.mortiz.surveying_app.view

interface VotesView {

    fun showAllVotes(): List<String>

    fun showVotesByCategory(category: String): List<String>

}