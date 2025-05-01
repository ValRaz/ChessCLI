class Pawn(position: Position, color: Color) : Piece(position, color) {
    //Simple stub pawns move one step forward based on color, black pawns go down, white go up
    override fun possibleMoves(): List<Position> {
        val moves = mutableListOf<Position>()
        if (color == Color.WHITE) {
            moves.add(Position(position.file, position.rank + 1))
        } else {
            moves.add(Position(position.file, position.rank -1))
        }
        return moves
    }

    override fun toString(): String =
    if (color == Color.WHITE) "P" else "p"
}