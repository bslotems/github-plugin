package com.coravy.hudson.plugins.github;

import hudson.EnvVars;
import hudson.model.AbstractBuild;
import hudson.model.EnvironmentContributingAction;
import hudson.model.InvisibleAction;
import hudson.model.ParametersAction;

import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by bslote on 4/7/15.
 */
public class VariableInjectionAction extends InvisibleAction implements EnvironmentContributingAction {
    private static final Logger LOGGER = Logger.getLogger(VariableInjectionAction.class.getName());

    private final Map<String, Object> variableMap;

    public VariableInjectionAction(Map<String, Object> variableMap) {
        this.variableMap = variableMap;
    }

    public void buildEnvVars(AbstractBuild<?, ?> build, EnvVars env) {
        if (variableMap != null && env != null) {
            for (Map.Entry<String, Object> entry : variableMap.entrySet()) {
                env.put(entry.getKey(), entry.getValue().toString());
            }
        }
    }
}
