package de.lenzol.ascend.laucherpad.ui.menu;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IProcess;

public class KillAllHandler extends AbstractHandler {

    public Object execute(ExecutionEvent event) throws ExecutionException {
        ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
        for (IProcess process : manager.getProcesses()) {
            System.out.println("Terminate: " + process.getLaunch().getLaunchConfiguration().getName());
            try {
                process.terminate();
            } catch (DebugException e) {
                e.printStackTrace();
            }
        };
        return null;
    };

}
