package net.sf.anathema.platform.fx.selection;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import net.miginfocom.layout.CC;
import net.sf.anathema.lib.control.ObjectValueListener;
import net.sf.anathema.lib.gui.AgnosticUIConfiguration;
import net.sf.anathema.platform.fx.ConfigurableListCellFactory;
import net.sf.anathema.platform.fx.FxObjectSelectionView;
import net.sf.anathema.platform.fx.FxThreading;
import net.sf.anathema.platform.fx.Stylesheet;
import org.jmock.example.announcer.Announcer;
import org.tbee.javafx.scene.layout.MigPane;

import java.util.Arrays;

import static net.sf.anathema.lib.gui.layout.LayoutUtils.withoutInsets;

public class ListSelectionView<T> implements FxObjectSelectionView<T> {
  private ListView<T> list;
  private Label label;
  private MigPane pane;
  private final Announcer<ObjectValueListener> announcer = Announcer.to(ObjectValueListener.class);

  @SuppressWarnings("unchecked")
  public ListSelectionView(final String description, final AgnosticUIConfiguration<T> ui) {
    FxThreading.runOnCorrectThread(new Runnable() {
      @Override
      public void run() {
        list = new ListView<>();
        label = new Label(description);
        pane = new MigPane(withoutInsets());
        pane.add(label);
        pane.add(list, new CC().maxHeight("78pt"));
      }
    });
    FxThreading.runOnCorrectThread(new Runnable() {
      @Override
      public void run() {
        list.setCellFactory(new ConfigurableListCellFactory<>(ui));
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        new Stylesheet("skin/platform/selectionlist.css").applyToParent(list);
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<T>() {
          @Override
          public void changed(ObservableValue<? extends T> observableValue, T v, T newValue) {
            announcer.announce().valueChanged(newValue);
          }
        });
      }
    });
  }

  @Override
  public void setSelectedObject(final T object) {
    FxThreading.runOnCorrectThread(new Runnable() {
      @Override
      public void run() {
        list.getSelectionModel().select(object);
        list.scrollTo(list.getSelectionModel().getSelectedIndex());
      }
    });
  }

  @Override
  public void addObjectSelectionChangedListener(ObjectValueListener<T> listener) {
    announcer.addListener(listener);
  }

  @Override
  public void removeObjectSelectionChangedListener(ObjectValueListener<T> listener) {
    announcer.removeListener(listener);
  }

  @Override
  public void setObjects(final T[] objects) {
    FxThreading.runOnCorrectThread(new Runnable() {
      @Override
      public void run() {
        list.setItems(new ObservableListWrapper<>(Arrays.asList(objects)));
      }
    });
  }

  @Override
  public T getSelectedObject() {
    return list.getSelectionModel().getSelectedItem();
  }

  @Override
  public boolean isObjectSelected() {
    return getSelectedObject() != null;
  }

  @Override
  public void setEnabled(final boolean enabled) {
    FxThreading.runOnCorrectThread(new Runnable() {
      @Override
      public void run() {
        list.setDisable(!enabled);
      }
    });
  }

  @Override
  public Node getNode() {
    return pane;
  }
}