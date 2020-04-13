package pulsar.core;

import pulsar.views.mainview.MainViewModel;

public class ViewModelFactory
{
  private ModelFactory mf;
  private MainViewModel mainViewModel;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public MainViewModel getMainViewModel()
  {
    if (mainViewModel == null)
    {
      mainViewModel = new MainViewModel(mf.getModel());
    }

    return mainViewModel;
  }
}
