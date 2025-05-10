class Rook(position: Position, color: Color) : Piece(position, color) {
    // Simple stub rooks move one step in each cardinal direction
    override fun possibleMoves(board: Board): List<Position> {
        val moves = mutableListOf<Position>()
        //slides through until blocked, OOB stop, and capture or stop for occupied square
        val directions = listOf(
            1 to 0,
            -1 to 0,
            0 to 1,
            0 to -1
        )
        for ((dx, dy) in directions) {
            var distance = 1
            while (true) {
                val next = Position(
                    (position.file + dx * distance).toChar(),
                    position.rank + dy * distance
                )
                if (next.file !in 'a'..'h' || next.rank !in 1..8) break

                val occupant = board.getPieceAt(next)
                if (occupant == null) {
                    moves += next
                } else {
                    if (occupant.color != this.color) {
                        moves += next
                    }
                    break
                }
                distance++
            }
        }
        return moves
    }

    override fun toString(): String =
        if (color == Color.WHITE) "R" else "r"
}