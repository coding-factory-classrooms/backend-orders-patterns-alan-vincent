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

Foodtray o-- Food
CommandUser o-- Foodtray
CommandUser -- CommandState

