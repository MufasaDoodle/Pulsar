package pulsar.views.mainview;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import pulsar.model.Model;

public class MainViewModel
{
  private Model model;
  private StringProperty money;
  private StringProperty satellites;
  private StringProperty error;

  public MainViewModel(Model model)
  {
    this.model = model;
    money = new SimpleStringProperty();
    satellites = new SimpleStringProperty();
    error = new SimpleStringProperty();
    money.set("1000");
    satellites.set("0");
  }

  public void askForMoney()
  {
    incrementProperty(money, 500);
  }

  public void launchSatellite()
  {
    makePurchase(satellites, 1000, 1);
  }

  private void makePurchase(StringProperty property, int cost, int amount)
  {
    if (checkPurchase(cost))
    {
      incrementProperty(property, amount);
      decrementProperty(money, cost);
    }
    else
    {
      error.set("Not enough money");
      Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> error.set("")));
      timeline.play();
    }
  }

  private boolean checkPurchase(int cost)
  {
    if (Integer.parseInt(money.getValue()) >= cost)
    {
      return true;
    }
    return false;
  }

  private void incrementProperty(StringProperty property, int amount)
  {
    int temp = Integer.parseInt(property.getValue());
    temp += amount;
    property.set(String.valueOf(temp));
  }

  private void decrementProperty(StringProperty property, int amount)
  {
    int temp = Integer.parseInt(property.getValue());
    temp -= amount;
    property.set(String.valueOf(temp));
  }

  public StringProperty moneyProperty()
  {
    return money;
  }

  public StringProperty satellitesProperty()
  {
    return satellites;
  }

  public StringProperty errorProperty()
  {
    return error;
  }
}
