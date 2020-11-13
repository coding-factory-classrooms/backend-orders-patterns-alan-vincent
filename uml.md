classDiagram
  class OrderState{
    <<enumeration>>
    NEW
    IN_PROGRESS
    FINISH
    CANCELED
  }
  class HandleStateChange{
    <<interface>>
    - onOrderStateChange(order)
  }
  class Order{
    - oredredMenu: Menu
    - state: OrderState
    - handleStateChange: HandleStateChange
    - clone()
  }
  class Menu{
    - title: String
    - foodtrays: List<Foodtray>
    - clone()
  }
  class Foodtray{
    - foods: List<Food>
    - description: String
    - clone()
  }
  class Food{
    - descriptions: String
    - quantity: int
    - clone()
  }
  class OrdersManage{
    - commandsUers: List<commandUser>
    - history: CommandHistory
    - undo()
    - redo()
    - clone()
    - onOrderStateChange(order)
  }
  class Command{
    <<abstract>>
    +execute()
  }
  class CommandHistory{
    - history: List<OrdersManage>
    - currentIndex: int
    - push(orderCommand)
    - getHistory() List<OrdersManage>
  }
  class CommandUndo{
  }
  class CommandRedo{
  }

Foodtray o-- Food
Menu o-- Foodtray
Order o-- Menu
Order -- OrderState

OrdersManage o-- Order
OrdersManage o-- CommandUndo
OrdersManage o-- CommandRedo
OrdersManage o-- CommandHistory

Command <|-- CommandUndo
Command <|-- CommandRedo

Order <|-- HandleStateChange
OrdersManage *-- HandleStateChange