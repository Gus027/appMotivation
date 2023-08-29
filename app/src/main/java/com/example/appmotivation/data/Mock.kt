package com.example.appmotivation.data

import com.example.appmotivation.infra.MotivationConstVar
import kotlin.random.Random

data class Phrase(val description: String, val categoryId: Int)


class Mock {

    private val REVERSE = MotivationConstVar.FILTER.REVERSE
    private val PERSON = MotivationConstVar.FILTER.PERSON
    private val THEME = MotivationConstVar.FILTER.THEME

    private val listPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", PERSON),
        Phrase("Tudo é possivel, naquele que tem fé.", PERSON),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", PERSON),
        Phrase("Quando está mais escuro, vemos mais estrelas!", PERSON),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", PERSON),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", PERSON),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", PERSON),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", THEME),
        Phrase("Você perde todas as chances que você não aproveita.", THEME),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", THEME),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", THEME),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", THEME),
        Phrase("Se você acredita, faz toda a diferença.", THEME),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", THEME)
    )

    fun randomPhrase(value: Int): String{
        val filtered = listPhrases.filter { it.categoryId == value || value == REVERSE }
        return filtered[Random.nextInt(filtered.size)].description
    }
}