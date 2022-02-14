package br.com.seda.celfons.core

interface ITask {
    fun execute(originTopic: String, message: String)
}