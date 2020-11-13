sequenceDiagram
    participant Manager
    participant OrderService
    participant Order
    Participant OrdersManage
    Participant History
    Manager ->>+ OrderService : change status of order
    OrderService->>Order : setStatus(newStatus)
    Order->>Order : update Status
    Order->> OrdersManage : notify Listener
    OrdersManage->> History : save State 
    Order->>OrderService : Maj Satatus
    OrderService -->- Manager : Status changed