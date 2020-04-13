package pulsar.views.mainview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pulsar.core.ViewHandler;
import pulsar.core.ViewModelFactory;
import pulsar.views.ViewController;

public class MainController implements ViewController
{
  @FXML private Label errorLabel;
  @FXML private Label moneyAmount;
  @FXML private Label satAmount;
  private MainViewModel viewModel;
  private ViewHandler vh;

  @Override public void init(ViewHandler viewHandler, ViewModelFactory vmf)
  {
    this.viewModel = vmf.getMainViewModel();
    this.vh = viewHandler;
    moneyAmount.textProperty().bind(viewModel.moneyProperty());
    satAmount.textProperty().bind(viewModel.satellitesProperty());
    errorLabel.textProperty().bind(viewModel.errorProperty());
  }

  public void onLaunchSat(ActionEvent actionEvent)
  {
    viewModel.launchSatellite();
  }

  public void onAskMoney(ActionEvent actionEvent)
  {
    viewModel.askForMoney();
  }
}
