package pulsar;

import javafx.application.Application;
import javafx.stage.Stage;
import pulsar.core.ModelFactory;
import pulsar.core.ViewHandler;
import pulsar.core.ViewModelFactory;

public class App extends Application
{
  @Override public void start(Stage stage)
  {
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);
    vh.start();
  }
}
