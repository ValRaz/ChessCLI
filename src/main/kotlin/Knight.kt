class Knight(position: Position, color: Color) : Piece(position, color) {
    override fun possibleMoves() = listOf(
        Position((position.file + 1).toChar(), position.rank + 2),
        Position((position.file - 1).toChar(), position.rank - 2),
    )
    override fun toString() = if (color == Color.WHITE) "N" else "n"
}