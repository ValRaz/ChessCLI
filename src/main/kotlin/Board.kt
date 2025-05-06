class Board {
    //Builds the 8x8 chessboard holds nullable piece reference
    private val squares: Array<Array<Piece?>> =
        Array(8) { Array<Piece?>(8) { null } }

    //Puts a piece on the board at its Position, updates state
    fun placePiece( piece: Piece, position: Position) {
        val x = position.fileIndex()
        val y = position.rankIndex()
        if (x in 0..7 && y in 0..7) {
            squares[y][x] = piece
            piece.position = position
        }
    }

    //Initializes the board with all pieces at starting positions
    fun initBoard() {
        //White pawn placement
        for (fileIdx in 0 until 8) {
            val pos = Position(('a' + fileIdx), 2)
            val pawn = Pawn(pos, Color.WHITE)
            placePiece(pawn, pos)
        }

        //Black pawn placement
        for (fileIdx in 0 until 8) {
            val pos = Position(('a' + fileIdx), 7)
            val pawn = Pawn(pos, Color.BLACK)
            placePiece(pawn, pos)
        }

        //Major piece order for Black and White
        val majorOrder = listOf<(Position, Color) -> Piece>(
            ::Rook, ::Knight, ::Bishop, ::Queen,
            ::King, ::Bishop, ::Knight, ::Rook
        )

        //Major piece placement for White
        for ((fileIdx, constructor) in majorOrder.withIndex()) {
            val pos = Position(('a' + fileIdx), 1)
            val piece = constructor(pos, Color.WHITE)
            placePiece(piece, pos)
        }

        //Major piece placement for Black
        for ((fileIdx, constructor) in majorOrder.withIndex()) {
            val pos = Position(('a' + fileIdx), 8)
            val piece = constructor(pos, Color.BLACK)
            placePiece(piece, pos)
        }
    }

    //helper to get the piece at a given position
    private fun getPiece(pos: Position): Piece? =
        squares[pos.rankIndex()][pos.fileIndex()]

    //helper to check if a position exists on the board
    private fun isInBounds(pos: Position): Boolean =
        pos.file in 'a'..'h' && pos.rank in 1..8

    //Moves a piece to a new square. Returns true for valid move and false for invalid move.
    fun makeMove(from: Position, to: Position): Boolean {
        val piece = getPiece(from) ?: return false
        if (!isInBounds(to)) return false

        //Validates move is listed in possible moves for the piece
        if (to !in piece.possibleMoves()) return false

        //Logs which piece is being moved
        when (piece) {
            is Pawn -> println("Pawn moves from $from to $to")
            is Rook -> println("Rook moves from $from to $to")
            is Knight -> println("Knight moves from $from to $to")
            is Bishop -> println("Bishop moves from $from to $to")
            is Queen -> println("Queen moves from $from to $to")
            is King -> println("King moves from $from to $to")
        }

        //Executes the move, clears old square, and updates piece place at new square
        squares[from.rankIndex()][from.fileIndex()] = null
        piece.position = to
        squares[to.rankIndex()][to.fileIndex()] = piece

        return true
    }

    //Helper to apply the move
    fun applyMove(move: Move): Boolean =
        makeMove(move.from, move.to)

    //Renders the board.
    fun drawBoard() {
        print("    ")
        for (c in 'a'..'h') print("$c   ")
        println()

        val divider = "  +" + List(8) {"---+"}.joinToString("")
        for (rank in 8 downTo 1) {
            println(divider)
            print("$rank ")
            for (file in 'a'..'h') {
                val piece = squares[rank - 1][file - 'a']
                val symbol = piece?.toString() ?: " "
                print("| $symbol ")
            }
            println("|")
        }
        println(divider)
    }
}