classDiagram
  class CommandUserState{
    <<enumeration>>
    NEW
    IN_PROGRESS
    FINISH
    CANCELED
  }
  class CommandUser{
    - foodtray: List<Foodtray>
    - state: CommandUserState
  }
  class Foodtray{
    - foods: List<Food>
    - description: String
  }
  class Food{
    - descriptions: String
    - quantity: int
  }
  class CommandCenter{
    - commandsUers: List<commandUser>
    - history: CommandHistory
  }
  class Command{
    <<abstract>>
    +execute()
  }
  class CommandHistory{
  }
  class CommandUndo{
  }
  class CommandRedo{
  }

Foodtray o-- Food

CommandUser o-- Foodtray
CommandUser -- CommandUserState

CommandCenter o-- CommandUser
CommandCenter o-- CommandUndo
CommandCenter o-- CommandRedo
CommandCenter o-- CommandHistory

Command <|-- CommandUndo
Command <|-- CommandRedo

