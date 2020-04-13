package pulsar.core;

import pulsar.model.Model;
import pulsar.model.ModelImpl;

public class ModelFactory
{
  private Model model;

  public Model getModel()
  {
    if (model == null)
    {
      model = new ModelImpl();
    }

    return model;
  }
}
