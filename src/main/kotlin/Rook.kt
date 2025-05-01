class Rook(position: Position, color: Color) : Piece(position, color) {
    // Simple stub rooks move one step in each cardinal direction
    override fun possibleMoves(): List<Position> {
        return listOf(
            Position(position.file, position.rank + 1),
            Position(position.file, position.rank - 1),
            Position((position.file + 1).toChar(), position.rank),
            Position((position.file - 1).toChar(), position.rank)
        )
    }

    override fun toString(): String =
        if (color == Color.WHITE) "R" else "r"
}