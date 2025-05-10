class Bishop(position: Position, color: Color) : Piece(position, color) {
    // Simple stub bishops move diagonally until blocked, capture enemy or stop
    override fun possibleMoves(board: Board): List<Position> {
        val moves = mutableListOf<Position>()
        // Diagonal directions
        val directions = listOf(1 to 1, -1 to 1, 1 to -1, -1 to -1)
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
                    if (occupant.color != color) moves += next
                    break
                }
                distance++
            }
        }
        return moves
    }
    override fun toString() = if (color == Color.WHITE) "B" else "b"
}