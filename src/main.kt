import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

sealed class Country {
    object Canada: Country()
}

object Spain: Country()
class Indonesia(val someProperty: String): Country()
data class Malaysia(val someProperty: String): Country()

class Currency(val code: String)

object CurrencyFactory{
    fun currencyForCountry(country: Country): Currency =
        when(country) {
            is Spain -> Currency("EUR")
            is Indonesia -> Currency("IDR")
            is Malaysia -> Currency("MYR")
            is Country.Canada -> Currency("CAD")
        }
}

class FactoryMethodTest{
    @Test
    fun currencyTest(){
        val indonesiaCurrency = CurrencyFactory.currencyForCountry(Indonesia("")).code
        println("Indonesia currency is $indonesiaCurrency")

        val malaysiaCurrency = CurrencyFactory.currencyForCountry(Malaysia("")).code
        println("Malaysia currency is $malaysiaCurrency")

        Assertions.assertEquals("IDR", indonesiaCurrency)
        Assertions.assertEquals("MYR", malaysiaCurrency)
    }

}

