package gwt.material.errai.table.client.local.factory;

import gwt.material.errai.table.client.shared.User;
import gwt.material.design.client.data.component.RowComponent;
import gwt.material.design.client.data.factory.RowComponentFactory;

public class PersonRowFactory extends RowComponentFactory<User> {

    @Override
    public RowComponent<User> generate(User model) {
        // We won't change the way it loads the RowComponent
        return super.generate(model);
    }

    @Override
    public String getCategory(User model) {
        // We want to override the standard category retrieval
        // This is where we can define a models category.
        // This is useful when we don't want to pollute our
        // object models with the interface HasDataCategory.
        return model.getCategory();
    }
}
