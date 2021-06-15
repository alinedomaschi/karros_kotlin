package br.com.zup.edu

import br.com.zup.edu.carros.CarroNew
import br.com.zup.edu.carros.CarroRepository
import io.micronaut.data.annotation.Repository
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.annotation.TransactionMode
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest(rollback = false,
transactionMode = TransactionMode.SINGLE_TRANSACTION,
transactional = false
    )
class CarrosGrpcTest {

    @Inject
    lateinit var repository: CarroRepository

    @BeforeEach
    fun setup(){
        repository.deleteAll()
    }

    @AfterEach
    fun cleanUp(){
        repository.deleteAll()
    }

    @Test
    fun `deve inserir um novo carro`(){
        //cenario
        repository.deleteAll()
        //ação
         repository.save(CarroNew(modelo = "Gol",placa = "HPX-1234"))
        //vaçidação
        assertEquals(1, repository.count())

        }

        @Test
        fun `deve encontrar carro por placa`(){
            //cenario
            repository.deleteAll()
            //acao
            repository.save(CarroNew(modelo = "Palio",placa = "OIP-9856"))
            //validacao
            val encontrado = repository.existsByPlaca("OIP-9856")

        }
    }
