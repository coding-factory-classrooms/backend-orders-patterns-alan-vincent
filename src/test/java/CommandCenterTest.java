import org.example.models.CommandCenter;
import org.example.models.CommandUser;
import org.example.models.Food;
import org.example.models.Foodtray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandCenterTest {
    private CommandCenter commandCenter;

    @Before
    public void before(){
        commandCenter = new CommandCenter();
    }

    @Test
    public void createNewCommand(){
        CommandUser commandUser = new CommandUser();
        Foodtray foodtray = new Foodtray();
        foodtray.setDescription("Basic plateau");
        foodtray.addFoods(new Food("Maki", 5));
        foodtray.addFoods(new Food("Sushi", 4));
        foodtray.addFoods(new Food("Tempura", 2));
        commandUser.addCommandFoods(foodtray);

        commandCenter.createCommand(commandUser);

        Assert.assertEquals(commandCenter.getCommands().size(), 1);
    }
}
