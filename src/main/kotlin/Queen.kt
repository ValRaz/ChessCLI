class Queen (position: Position, color: Color) : Piece(position, color) {
    //Stub Queen moves in straight lines any direction,OOB stop, blocked stop or capture
    override fun possibleMoves(board: Board): List<Position> {
        val moves = mutableListOf<Position>()
        val directions = listOf(
            1 to  0, -1 to  0,  0 to  1,  0 to -1,
            1 to  1, -1 to  1,  1 to -1, -1 to -1
        )
        for ((dx, dy) in directions) {
            var step = 1
            while (true) {
                val next = Position(
                    (position.file + dx * step).toChar(),
                    position.rank + dy * step
                )
                if (next.file !in 'a'..'h' || next.rank !in 1..8) break

                val occupant = board.getPieceAt(next)
                if (occupant == null) {
                    moves += next
                } else {
                    if (occupant.color != color) moves += next
                    break
                }
                step++
            }
        }
        return moves
    }
    override fun toString() = if (color == Color.WHITE) "Q" else "q"
}