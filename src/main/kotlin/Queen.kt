class Queen (position: Position, color: Color) : Piece(position, color) {
    override fun possibleMoves() = listOf(
        Position((position.file + 1).toChar(), position.rank),
        Position((position.file + 1).toChar(), position.rank + 1)
    )
    override fun toString() = if (color == Color.WHITE) "Q" else "q"
}