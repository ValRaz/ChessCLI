import org.junit.jupiter.api.Assertions.*

class BoardTest {
    @org.junit.jupiter.api.Test
    fun testPlacePiece() {
        val board = Board()
        val pos = Position('c', 3)
        val pawn = Pawn(pos, Color.WHITE)

        board.placePiece(pawn, pos)

        //Expected: Board will return the same pawn instance/position, then update pawn position
        val found = board.getPieceAt(pos)
        assertSame(pawn, found, "placePiece stores exact instance at the given square")
        assertEquals(pos, pawn.position, "Pawn.position updates to the new square")
    }

    @org.junit.jupiter.api.Test
    fun testMakeMovePawnOpening() {
        val board = Board().apply { initBoard() }
        val from = Position('e', 2)
        val to   = Position('e', 4)

        val result = board.makeMove(from, to)
        assertTrue(result, "makeMove returns true for a valid pawn opening move")

        // Source square should be empty
        assertNull(board.getPieceAt(from), "After move, starting position is empty")
        // Destination should hold a white pawn
        val moved = board.getPieceAt(to)
        assertNotNull(moved, "After move, position is updated")
        assertTrue(moved is Pawn && moved.color == Color.WHITE,
            "Piece at e4 is a white Pawn")
    }

    @org.junit.jupiter.api.Test
    fun testMakeMoveFromEmptySquare() {
        val board = Board().apply { initBoard() }
        val from = Position('d', 5)
        val to   = Position('d', 6)

        val result = board.makeMove(from, to)
        assertFalse(result, "makeMove returns false when attempting to move from an empty square")
        assertNull(board.getPieceAt(to), "Destination square stays empty when move fails")
    }

    @org.junit.jupiter.api.Test
    fun testApplyMoveToMakeMove() {
        val board = Board().apply { initBoard() }
        val from = Position('g', 2)
        val to   = Position('g', 3)

        val direct  = board.makeMove(from, to)
        val board2 = Board().apply { initBoard() }
        val viaMove = board2.applyMove(Move(from, to))

        assertEquals(direct, viaMove,
            "applyMove(move) should return same result as makeMove(from, to)")
    }

    @org.junit.jupiter.api.Test
    fun testSameColorCapturePrevention() {
        val board = Board()
        board.placePiece(Pawn(Position('c',3), Color.WHITE), Position('c', 3))
        board.placePiece(Bishop(Position('d', 4), Color.WHITE), Position('d', 4))

        val result =  board.makeMove(Position('c', 3), Position('d', 4))
    }
}