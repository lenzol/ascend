package de.lenzol.ascend.launcherpad.util;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;

public class IdentificationUtility {

    public static String getIdentifierFor(ILaunchConfiguration launchConfiguration){
        try {
            return launchConfiguration.getMemento();
        } catch (CoreException e) {
            // TODO: logging
            return null;
        }
    }
    
    public static ILaunchConfiguration doSome(String memento){
        ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
        try {
            return manager.getLaunchConfiguration(memento);
        } catch (CoreException e) {
            // TODO: logging
            return null;
        }
    }
    
}
