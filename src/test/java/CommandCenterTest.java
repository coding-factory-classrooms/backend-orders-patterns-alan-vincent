import org.example.models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CommandCenterTest {
    private CommandCenter commandCenter;
    private CommandHistory history;

    @Before
    public void before(){
        history = new CommandHistory();
        commandCenter = new CommandCenter(history);
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

    @Test
    public void historyHasNewCommand(){
        CommandUser commandUser = new CommandUser();
        Foodtray foodtray = new Foodtray();
        foodtray.setDescription("Basic plateau");
        foodtray.addFoods(new Food("Maki", 5));
        foodtray.addFoods(new Food("Sushi", 4));
        foodtray.addFoods(new Food("Tempura", 2));
        commandUser.addCommandFoods(foodtray);
        commandCenter.createCommand(commandUser);
        Assert.assertEquals(history.getHistory().size(), 1);
    }

}
