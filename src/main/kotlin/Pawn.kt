class Pawn(position: Position, color: Color) : Piece(position, color) {
    //Simple stub pawns move one step forward based on color, black pawns go down, white go up
    override fun possibleMoves(board: Board): List<Position> {
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
            val twoStep =  Position(position.file, position.rank + 2 * dir)
            val between = Position(position.file, position.rank + dir)
            if (twoStep.file in 'a'..'h' &&
                twoStep.rank in 1..8 &&
                board.getPieceAt(between) == null &&
                board.getPieceAt(twoStep) == null
            ) {
                moves += twoStep
            }
        }

        //Diagonal left capture
        val diagL = Position(position.file - 1, position.rank + dir)
        if (diagL.file in 'a'..'h' && diagL.rank in 1..8) {
            board.getPieceAt(diagL)?.let { target ->
                if (target.color != color) moves += diagL
            }
        }

        //Diagonal Right capture
        val diagR = Position(position.file + 1, position.rank + dir)
        if (diagR.file in 'a'..'h' && diagR.rank in 1..8) {
            board.getPieceAt(diagR)?.let { target ->
                if (target.color != color) moves += diagR
            }
        }
        return moves
    }

    override fun toString(): String =
    if (color == Color.WHITE) "P" else "p"
}