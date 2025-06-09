package com.mortiz.surveying_app.view

interface VotesView {

    fun showAllVotes()

    fun showVotesByCategory(category: String)
    abstract fun showError(s: String)

}