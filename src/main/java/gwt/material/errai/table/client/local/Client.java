package gwt.material.errai.table.client.local;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.errai.table.client.local.widget.Main;
import gwt.material.errai.table.client.shared.User;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.nav.client.local.Navigation;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by Mark Kevin on 6/8/2016.
 */
@EntryPoint
public class Client extends Composite{

    @Inject
    Navigation navigation;

    @Inject
    Main content;

    @Inject
    User currentUser;

    @PostConstruct
    public void init() {
        content.getContainer().add(navigation.getContentPanel());
        RootPanel.get().add(content);
    }
}
