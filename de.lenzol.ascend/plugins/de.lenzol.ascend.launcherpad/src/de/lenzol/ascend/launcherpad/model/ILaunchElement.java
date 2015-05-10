package de.lenzol.ascend.launcherpad.model;

import java.io.Serializable;

public interface ILaunchElement extends Serializable {

    String getName();

    String getLaunchConfigurationMomento();

    void run();

    Long getTimeOut();

}
