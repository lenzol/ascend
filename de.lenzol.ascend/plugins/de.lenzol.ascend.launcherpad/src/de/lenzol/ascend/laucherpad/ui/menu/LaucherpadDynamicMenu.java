package de.lenzol.ascend.laucherpad.ui.menu;

import java.util.Date;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class LaucherpadDynamicMenu extends ContributionItem {

    public LaucherpadDynamicMenu() {
    }

    public LaucherpadDynamicMenu(String id) {
        super(id);
    }

    @Override
    public void fill(Menu menu, int index) {
        MenuItem menuItem = new MenuItem(menu, SWT.CHECK, index);
        menuItem.setText("My menu item (" + new Date() + ")");
        menuItem.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                // what to do when menu is subsequently selected.
                System.err.println("Dynamic menu selected");
            }
        });

        menuItem = new MenuItem(menu, SWT.CHECK, index);
        menuItem.setText("My menu item (" + new Date() + ")");
        menuItem.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                // what to do when menu is subsequently selected.
                System.err.println("Dynamic menu selected");
            }
        });
    }

    @Override
    public boolean isDynamic() {
        return true;
    }

}
