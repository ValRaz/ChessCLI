import org.junit.jupiter.api.Assertions.*

class PositionTest {

    @org.junit.jupiter.api.Test
    fun testFileAndRankProduction() {
        val pos = Position('e', 4)
        assertEquals("e4", pos.toString())
    }

    @org.junit.jupiter.api.Test
    fun testFileIndexZeroBasedColumnCalculation() {
        val posA = Position('a', 1)
        assertEquals(0, posA.fileIndex())

        val posF = Position('f', 3)
        assertEquals(5, posF.fileIndex())
    }

    @org.junit.jupiter.api.Test
    fun testRankIndexZeroBasedRowCalculation() {
        val pos1 = Position('a', 1)
        assertEquals(0, pos1.rankIndex())

        val pos8 = Position('h', 8)
        assertEquals(7, pos8.rankIndex())
    }
}