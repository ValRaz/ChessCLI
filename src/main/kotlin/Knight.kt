class Knight(position: Position, color: Color) : Piece(position, color) {
    //Stub knight moves in L-shaped jump, OOB stop, blocked same color or capture
    override fun possibleMoves(board: Board): List<Position> {
        val moves = mutableListOf<Position>()
        val lJumps = listOf(
            1 to  2,  2 to  1,
            -1 to  2, -2 to  1,
            1 to -2,  2 to -1,
            -1 to -2, -2 to -1
        )
        for ((dx, dy) in lJumps) {
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
    override fun toString() = if (color == Color.WHITE) "N" else "n"
}