package pulsar.views;

import pulsar.core.ViewHandler;
import pulsar.core.ViewModelFactory;

public interface ViewController
{
  void init(ViewHandler viewHandler, ViewModelFactory vmf);
}
