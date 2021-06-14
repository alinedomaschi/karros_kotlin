package br.com.zup.edu.carros

import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import javax.inject.Singleton
import javax.validation.Constraint
import kotlin.annotation.AnnotationTarget.*
import kotlin.annotation.AnnotationRetention.RUNTIME

@MustBeDocumented // Gerador de documentação de todas as classes que possui a anotação
@Target(FIELD,CONSTRUCTOR)
@Retention(RUNTIME) // Framework pode examinar na execução
@Constraint(validatedBy = [PlacaValidator::class])
annotation class Placa(
    val message: String="placa com formado inválido"
)

@Singleton
class PlacaValidator : ConstraintValidator <Placa,String>{

    override fun isValid(
        value: String?,
        annotationMetadata: AnnotationValue<Placa>,
        context: ConstraintValidatorContext
    ): Boolean {

        if(value == null){
            return true
        }

        //AAA-0A00 - [A-Z]{3}[0-9][0-9A-Z][0-9]{2}
        return value.matches("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}".toRegex())
    }

}
