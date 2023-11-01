package io.ballerina.lib.convertor;

import io.ballerina.runtime.api.Environment;
import io.ballerina.runtime.api.Module;

public final class ModuleUtils {

    private static Module copybookModule;

    private ModuleUtils() {}

    public static void setModule(Environment env) {
        copybookModule = env.getCurrentModule();
    }

    public static Module getModule() {
        return copybookModule;
    }
}
