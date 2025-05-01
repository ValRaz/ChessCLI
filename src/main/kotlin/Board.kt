class Board {
    //Builds the 8x8 chessboard holds nullable piece reference
    private val squares: Array<Array<Piece?>> =
        Array(8) { Array<Piece?>(8) { null } }

    //Puts a piece on the board at its Position, updates state
    fun placePiece( piece: Piece, position: Position) {
        val x = position.fileIndex()
        val y = position.rankIndex()
        if (x in 0..7 && y in 0..7) {
            squares[y][x] = piece
            piece.position = position
        }
    }

    //Renders the board as a multi-line string using '.' for empty squares.
    override fun toString(): String {
        val sb = StringBuilder()
        for (rank in 7 downTo 0) {
            sb.append("${rank + 1}")
            for (file in 0..7) {
                val piece = squares[rank][file]
                sb.append(piece?.toString() ?: ".").append(" ")
            }
            sb.append("\n")
        }
        sb.append(" a b c d e f g h\n")
        return sb.toString()
    }
}