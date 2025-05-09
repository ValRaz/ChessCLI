import org.junit.jupiter.api.Assertions.*

class MoveTest {
    @org.junit.jupiter.api.Test
    fun testFromReturnsTurnStartPosition() {
        val source = Position('e', 4)
        val dest   = Position('f', 5)
        val move   = Move(source, dest)

        assertEquals(
            source,
            move.from,
            "From property returns the starting position"
        )
    }

    @org.junit.jupiter.api.Test
    fun testToReturnsDestination() {
        val source = Position('a', 1)
        val dest   = Position('h', 8)
        val move   = Move(source, dest)

        assertEquals(
            dest,
            move.to,
            "The `to` returns the destination position"
        )
    }

    @org.junit.jupiter.api.Test
    fun testMoveComponent1ReturnsFromPosition() {
        val source = Position('c', 3)
        val dest   = Position('d', 4)
        val move   = Move(source, dest)

        val extracted = move.component1()

        assertEquals(
            source,
            extracted,
            "First move component returns `from` position value"
        )
    }

    @org.junit.jupiter.api.Test
    fun testMoveComponent2ReturnsToPosition() {
        val source = Position('b', 2)
        val dest   = Position('g', 7)
        val move   = Move(source, dest)

        val extracted = move.component2()

        assertEquals(
            dest,
            extracted,
            "Second move component returns `to` position value"
        )
    }

}