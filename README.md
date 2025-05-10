# Overview

This is my attempt to build a simple two-player console chess game named **ChessCLI** 
to deepen my understanding of Kotlin syntax, it's core features and to exercise my ability 
to develop clean usable code. My goals for this project were to:
- Exercise both 'val' and 'var' **variables**, **expressions**, **conditionals**, and **loops**
- Design and instantiate **classes**, including a 'Piece' hierarchy for the major and minor chess pieces.
- Use **functions** and **data classes** to model the board coordinates and moves
- Make use of Kotlin's **'when'** expression to branch piece types.
- Manage the state of the board with Kotlin collections.

In the process of meeting these goals, I implemented turn-taking, basic move validation such as pawn captures
and same color capture prevention. I also implemented an ASCII console UI. In building this project,
I received hands-on experience with object-oriented design, unit testing, and using the unique strengths of Kotlin 
to write clean concise code.


[Software Demo Video](https://www.youtube.com/watch?v=IQskJnS2M_c)

# Development Environment

- **JDK**: OpenJDK 24
- **IDE**: IntilliJ IDEA Community Edition
- **Kotlin**: Included via IntelliJ
- **Testing**: JUnit 5 manually added as a project library to run unit testing.

# Useful Websites

- [Kotlin Programming Language(Wikipedia)](https://en.wikipedia.org/wiki/Kotlin_(programming_language))
- [Official Kotlin Documentation](http://url.link.goes.here)
- [GeeksforGeeks: Kotlin Introduction/Control Flow(Dropdown at the bottom of the page)](https://www.geeksforgeeks.org/introduction-to-kotlin/)
- [Dev.to: Console UI Inspiration](https://dev.to/koddr/kotlin-short-recipes-generating-a-chessboard-for-a-console-game-3a98)
- [Kotlin to Java Comparison](https://kotlinlang.org/docs/comparison-to-java.html)
- [Programiz: Kotlin Data Classes](https://www.programiz.com/kotlin-programming/data-class)

# Future Work

- **Full Rule Enforcement**: Add check, checkmate, and stalemate detection functionality.
- **Special Moves**: Add functionality for castling, pawn promotion, and en passant.
- **Save/Load**: Add save and load functionality.
- **Player Networking**: Add the ability to play over TCP or websockets.