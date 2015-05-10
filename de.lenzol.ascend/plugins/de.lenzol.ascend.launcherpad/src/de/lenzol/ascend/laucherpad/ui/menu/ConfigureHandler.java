package de.lenzol.ascend.laucherpad.ui.menu;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.handlers.HandlerUtil;

import de.lenzol.ascend.launcherpad.util.Constants;

public class ConfigureHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        PreferencesUtil.createPreferenceDialogOn(HandlerUtil.getActiveWorkbenchWindow(event).getShell(),
                Constants.LAUCHERPAD_PREFERENCE_PAGE_ID,
                new String[] { Constants.LAUCHERPAD_PREFERENCE_PAGE_ID }, Collections.EMPTY_MAP).open();
        return null;
    }
}
