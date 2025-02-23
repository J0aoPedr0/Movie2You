package com.example.movie2you.data.mapper

interface ApiMapper<Domain,Entity> {
    fun mapToDomain(apiDto: Entity): Domain
}