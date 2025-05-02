class Pawn(position: Position, color: Color) : Piece(position, color) {
    //Simple stub pawns move one step forward based on color, black pawns go down, white go up
    override fun possibleMoves(): List<Position> {
        val moves = mutableListOf<Position>()
        //sets direction for white and black
        val dir = if (color == Color.WHITE) + 1 else - 1

        //Moves one square forward
        val oneStep = Position(position.file, position.rank + dir)
        if (oneStep.file in 'a'.. 'h' && oneStep.rank in 1..8) {
            moves.add(oneStep)
        }

        //Two squares forward for first move
        val startRank = if (color == Color.WHITE) 2 else 7
        if (position.rank == startRank) {
            val twoStep =  Position(position.file, position.rank +2 *dir)
            if (twoStep.file in 'a'..'h' && twoStep.rank in 1..8) {
                moves.add(twoStep)
            }
        }
        return moves
    }

    override fun toString(): String =
    if (color == Color.WHITE) "P" else "p"
}