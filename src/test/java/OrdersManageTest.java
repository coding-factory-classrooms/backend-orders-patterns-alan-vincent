import org.example.models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrdersManageTest {
    private OrdersManage ordersManage;
    private CommandHistory history;

    @Before
    public void before(){
        history = new CommandHistory();
        ordersManage = new OrdersManage(history);
        history.push((OrdersManage) ordersManage.clone());
    }

    @Test
    public void createNewCommand(){
        Order order = new Order();
        Menu menu = new Menu("Test");
        Foodtray foodtray = new Foodtray("Basic plateau");
        foodtray.addFoods(new Food("Maki", 5));
        foodtray.addFoods(new Food("Sushi", 4));
        foodtray.addFoods(new Food("Tempura", 2));
        menu.addFoodtrays(foodtray);
        order.setOrderedMenu(menu);

        ordersManage.createOrder(order);

        Assert.assertEquals(ordersManage.getOrders().size(), 1);
    }

    @Test
    public void historyHasNewCommand(){
        Order order = new Order();
        Menu menu = new Menu("Test");
        Foodtray foodtray = new Foodtray("Basic plateau");
        foodtray.addFoods(new Food("Maki", 5));
        foodtray.addFoods(new Food("Sushi", 4));
        foodtray.addFoods(new Food("Tempura", 2));
        menu.addFoodtrays(foodtray);
        order.setOrderedMenu(menu);
        ordersManage.createOrder(order);
        Assert.assertEquals(history.getHistory().size(), 1);
    }

    //TODO: Faire le test sur l'Observer onOrderStateChange

    @Test
    public void cloneObjectNotUpdatedByOrigin(){
        Order order = new Order();
        Menu menu = new Menu("Test");
        Foodtray foodtray = new Foodtray("Basic plateau");
        foodtray.addFoods(new Food("Maki", 5));
        foodtray.addFoods(new Food("Sushi", 4));
        foodtray.addFoods(new Food("Tempura", 2));
        menu.addFoodtrays(foodtray);
        order.setOrderedMenu(menu);
        ordersManage.createOrder(order);

        Order cloneOrder = (Order) order.clone();
        Order updateOrder = ordersManage.getOrders().get(0);
        updateOrder.setStatus(Order.OrderState.IN_PROGRESS);

        Assert.assertNotEquals(cloneOrder.getStatus(), updateOrder.getStatus());
    }

    @Test
    public void undoRestorePreviousListOrders(){
        Order order = new Order();
        Menu menu = new Menu("Test");
        Foodtray foodtray = new Foodtray("Basic plateau");
        foodtray.addFoods(new Food("Maki", 5));
        foodtray.addFoods(new Food("Sushi", 4));
        foodtray.addFoods(new Food("Tempura", 2));
        menu.addFoodtrays(foodtray);
        order.setOrderedMenu(menu);
        ordersManage.createOrder(order);

        ordersManage.undo();
        Assert.assertTrue(ordersManage.getOrders().isEmpty());
    }

    @Test
    public void redoRestoreNextStateListOrders(){

        Order order = new Order();
        Menu menu = new Menu("Test");
        Foodtray foodtray = new Foodtray("Basic plateau");
        foodtray.addFoods(new Food("Maki", 5));
        foodtray.addFoods(new Food("Sushi", 4));
        foodtray.addFoods(new Food("Tempura", 2));
        menu.addFoodtrays(foodtray);
        order.setOrderedMenu(menu);
        ordersManage.createOrder(order);

        ordersManage.undo();
        ordersManage.redo();
        Assert.assertFalse(ordersManage.getOrders().isEmpty());
    }

}
