package com.mortiz.surveying_app.presentation

sealed class VotesState {
    data class ShowTotalVotes(val totalVotes: Int) : VotesState()
    data class ShowVotesByCategory(val category: String, val totalVotes: Int) : VotesState()
    data class Error(val message: String) : VotesState()
}
