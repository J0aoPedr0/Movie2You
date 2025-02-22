package com.example.movie2you.common.data

interface ApiMapper<Domain,Entity> {
    fun mapToDomain(apiDto: Entity): Domain
}