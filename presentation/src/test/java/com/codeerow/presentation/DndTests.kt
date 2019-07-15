package com.codeerow.presentation

import org.junit.Test
import kotlin.random.Random


class DndTests {

    @Test
    fun weeklyStats() {
        val strength = Random.nextInt(1, 20)
        val stamina = Random.nextInt(1, 20)
        val dexterity = Random.nextInt(1, 20)
        val intellect = Random.nextInt(1, 20)
        val wisdom = Random.nextInt(1, 20)
        val charisma = Random.nextInt(1, 20)
        val dick = Random.nextInt(10, 20)

        val race = listOf("Dragonborn", "Dwarf", "Elf", "Human", "Orc", "Tiefling", "Goblin", "Batya", "Ladyboy", "Alexander Shpack", "Android Developer").shuffled()[0]
        val element = listOf("Fire", "Wind", "Water", "Ground").shuffled()[0]

        val monster = listOf("illithid", "beholder", "zombie", "minotaur", "mum", "chinese", "orcs", "marauders", "necromants", "skeleton-virgins").shuffled()[0]

        println("Race: $race")
        println("Element: $element")
        println()
        println("Enemy: $monster")
        println()
        println("strength: $strength")
        println("stamina: $stamina")
        println("dexterity: $dexterity")
        println("intellect: $intellect")
        println("wisdom: $wisdom")
        println("charisma: $charisma")
        println("dick: $dick")
        println()
        println("total: ${strength + stamina + dexterity + intellect + wisdom + charisma + dick}")
    }
}
