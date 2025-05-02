class Bishop(position: Position, color: Color) : Piece(position, color) {
    override fun possibleMoves() = listOf(
        Position((position.file + 1).toChar(), position.rank +1),
        Position((position.file - 1).toChar(), position.rank +1)
    )
    override fun toString() = if (color == Color.WHITE) "B" else "b"
}