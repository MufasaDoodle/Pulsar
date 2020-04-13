package pulsar.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pulsar.views.ViewController;

import java.io.IOException;

public class ViewHandler
{
  private Scene mainScene;
  private Stage stage;
  private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }

  public void start()
  {
    stage = new Stage();
    openMainScene();
  }

  public void openMainScene()
  {
    if (mainScene == null)
    {
      try
      {
        Parent root = loadFXML("../views/mainview/Main.fxml");

        stage.setTitle("Main");
        mainScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    stage.setScene(mainScene);
    stage.show();
  }

  private Parent loadFXML(String path) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    ViewController controller = loader.getController();
    controller.init(this, vmf);
    return root;
  }
}
