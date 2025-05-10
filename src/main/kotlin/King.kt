class King(position: Position, color: Color) : Piece(position, color) {
    //Simple stub King moves one square any direction, OOB stop, capture enemy occupied
    override fun possibleMoves(board: Board): List<Position> {
        val moves = mutableListOf<Position>()
        val deltas = listOf(
            0 to  1,  1 to  1,  1 to  0,  1 to -1,
            0 to -1, -1 to -1, -1 to  0, -1 to  1
        )
        for ((dx, dy) in deltas) {
            val next = Position(
                (position.file + dx).toChar(),
                position.rank + dy
            )
            if (next.file in 'a'..'h' && next.rank in 1..8) {
                val occupant = board.getPieceAt(next)
                if (occupant == null || occupant.color != color) {
                    moves += next
                }
            }
        }
        return moves
    }
    override fun toString() = if (color == Color.WHITE) "K" else "k"
}