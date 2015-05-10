package de.lenzol.ascend.laucherpad.ui.menu;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.IStreamListener;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamMonitor;

public class LaunchLastHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        try {
            ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
            // Load configuration from file
            //manager.getLaunchConfiguration(file)
            ILaunchConfiguration[] configurations;
            configurations = manager.getLaunchConfigurations();
            for (int i = 0; i < configurations.length; i++) {
                ILaunchConfiguration configuration = configurations[i];
                System.out.println("Name: " + configuration.getName());
                System.out.println("Type: " + configuration.getType().getName());
//                DebugUITools.launch(configuration, ILaunchManager.DEBUG_MODE);
//                IProcess[] processes = DebugPlugin.getDefault().getLaunchManager().getProcesses();
//                for (IProcess iProcess : processes) {
//                    if (iProcess.getLaunch().getLaunchConfiguration().equals(configuration)){
//                        iProcess.getStreamsProxy()
//                    }
//                }
                
                ILaunch launch = configuration.launch(ILaunchManager.DEBUG_MODE, null, true);
                for (IProcess process : launch.getProcesses()) {
                    process.getStreamsProxy().getOutputStreamMonitor().addListener(new IStreamListener() {
                        
                        @Override
                        public void streamAppended(String text, IStreamMonitor monitor) {
                            System.out.println(text);
                        }
                    });
//                    process.terminate();
                    System.out.println(process.getLabel());
                }
            }
        } catch (CoreException e) {
            e.printStackTrace();
        }
        return null;
    }

}
