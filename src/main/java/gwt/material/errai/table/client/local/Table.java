package gwt.material.errai.table.client.local;

import com.google.gwt.user.client.ui.Composite;
import gwt.material.errai.table.client.local.factory.CustomCategoryFactory;
import gwt.material.errai.table.client.local.factory.PersonRowFactory;
import gwt.material.errai.table.client.local.renderer.CustomRenderer;
import gwt.material.errai.table.client.shared.DataHelper;
import gwt.material.errai.table.client.shared.User;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.data.SelectionType;
import gwt.material.design.client.data.component.CategoryComponent;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.table.MaterialDataTable;
import gwt.material.design.client.ui.table.TableSubHeader;
import gwt.material.design.client.ui.table.cell.TextColumn;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Created by Mark Kevin on 7/20/2016.
 */
@Templated
@Page(path = "table", role = DefaultPage.class)
@ApplicationScoped
public class Table extends Composite{

    public static class CustomCategoryComponent extends CategoryComponent {
        public CustomCategoryComponent(String category) {
            super(category);
        }

        @Override
        protected void render(TableSubHeader subheader) {
            super.render(subheader);

            subheader.setOpenIcon(IconType.FOLDER_OPEN);
            subheader.setCloseIcon(IconType.FOLDER);
        }
    }

    @Inject
    @DataField
    MaterialPanel panel;

    @PostConstruct
    public void init() {
        MaterialDataTable<User> userTable = new MaterialDataTable<>();
        userTable.setHeight("calc(100vh - 68px)");
        userTable.setUseStickyHeader(true);
        userTable.setUseCategories(true);
        userTable.setSelectionType(SelectionType.NONE);
        userTable.setRowHeight(22);

        panel.add(userTable);

        userTable.setRowFactory(new PersonRowFactory());
        userTable.setCategoryFactory(new CustomCategoryFactory());
        userTable.setRenderer(new CustomRenderer<>());

        userTable.addColumn(new TextColumn<User>() {
            @Override
            public String getValue(User object) {
                return object.getUsername();
            }
        }, "Username");

        userTable.addColumn(new TextColumn<User>() {
            @Override
            public String getValue(User object) {
                return object.getFirstName();
            }
        }, "First Name");

        userTable.addColumn(new TextColumn<User>() {
            @Override
            public String getValue(User object) {
                return object.getLastName();
            }
        }, "Last Name");

        userTable.setVisibleRange(0, 1000);
        userTable.setRowData(0, DataHelper.getAllUsers());



    }
}
