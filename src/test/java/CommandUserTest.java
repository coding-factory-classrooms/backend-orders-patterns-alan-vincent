import org.example.models.CommandUser;
import org.example.models.Food;
import org.example.models.Foodtray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandUserTest {
    private CommandUser commandUser;

    @Before
    public void before(){
        commandUser = new CommandUser();
    }

    @Test
    public void newCommandUserHasStatusNew(){
        Assert.assertEquals(commandUser.getStatus(), CommandUser.CommandState.NEW);
    }

    @Test
    public void updatedStatusCommandUserIsValid(){
        commandUser.setStatus(CommandUser.CommandState.IN_PROGRESS);
        Assert.assertEquals(commandUser.getStatus(), CommandUser.CommandState.IN_PROGRESS);
    }

    @Test
    public void createFoodtrayInCommandUser(){
        Foodtray foodtray = new Foodtray();
        foodtray.setDescription("Basic plateau");
        foodtray.addFoods(new Food("Maki", 5));
        foodtray.addFoods(new Food("Sushi", 4));
        foodtray.addFoods(new Food("Tempura", 2));
        commandUser.addCommandFoods(foodtray);

        Assert.assertEquals(commandUser.getCommandFoods().size(),1);
    }
}
