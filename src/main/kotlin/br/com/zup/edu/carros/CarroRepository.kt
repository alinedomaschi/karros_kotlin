package br.com.zup.edu.carros

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface CarroRepository : JpaRepository<CarroNew,Long> {

    fun existsByPlaca(placa:String)
}