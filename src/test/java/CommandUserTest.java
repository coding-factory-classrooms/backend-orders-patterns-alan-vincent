import org.example.models.Order;
import org.example.models.Food;
import org.example.models.Foodtray;
import org.example.models.Menu;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandUserTest {
    private Order order;

    @Before
    public void before(){
        order = new Order();
    }

    @Test
    public void newCommandUserHasStatusNew(){
        Assert.assertEquals(order.getStatus(), Order.OrderState.NEW);
    }

    @Test
    public void updatedStatusCommandUserIsValid(){
        order.setStatus(Order.OrderState.IN_PROGRESS);
        Assert.assertEquals(order.getStatus(), Order.OrderState.IN_PROGRESS);
    }

    @Test
    public void createFoodtrayInCommandUser(){
        Menu menu = new Menu("Test");
        Foodtray foodtray = new Foodtray("Basic plateau");
        foodtray.addFoods(new Food("Maki", 5));
        foodtray.addFoods(new Food("Sushi", 4));
        foodtray.addFoods(new Food("Tempura", 2));
        menu.addFoodtrays(foodtray);
        order.setOrderedMenu(menu);

        Assert.assertEquals(order.getOrderedMenu().getFoodtrays(),1);
    }
}
