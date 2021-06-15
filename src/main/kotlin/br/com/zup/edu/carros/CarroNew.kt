package br.com.zup.edu.carros

import io.micronaut.data.annotation.GeneratedValue
import jdk.internal.vm.compiler.collections.Equivalence.IDENTITY
import net.bytebuddy.dynamic.loading.InjectionClassLoader
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class CarroNew (
    @field:NotBlank
    @Column(nullable = false)
    val modelo: String,

    @field:NotBlank
    @Column(nullable = false, unique = true)
    val placa: String,
){

    @Id
    @GeneratedValue//(strategy = IDENTITY)
    val id: Long? = null
}